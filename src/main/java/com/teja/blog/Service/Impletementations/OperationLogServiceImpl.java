package com.teja.blog.Service.Impletementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teja.blog.Service.Services.OperationLogService;
import com.teja.blog.model.OperationLog;
import com.teja.blog.repository.OperationLogRepository;
import com.teja.blog.utils.IP2Location;
import com.teja.blog.utils.PageUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.*;

@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    private OperationLogRepository operationLogRepository;

    @Autowired
    private ObjectMapper objectMapper;

    Logger logger = LoggerFactory.getLogger(OperationLogServiceImpl.class);

    @Override
    public Page<OperationLog> listOperationLogs(Integer pageSize, Integer page) {
        PageUtil.validPage(pageSize, page, this.operationLogRepository);
        Sort sort = Sort.by(Sort.Direction.DESC, "time");
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        return this.operationLogRepository.findAll(pageable);
    }

    @Override
    public void deleteOperationLog(Long id) {
        this.operationLogRepository.deleteById(id);
    }

    @Override
    public void addOperationLog(ProceedingJoinPoint proceedingJoinPoint, OperationLog operationLog) {

        operationLog.setTime(new Date());

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        operationLog.setMethod(signature.getName());

        String[] parameters = new LocalVariableTableParameterNameDiscoverer().getParameterNames(signature.getMethod());
        Object[] args = proceedingJoinPoint.getArgs();
        StringBuilder params = new StringBuilder();
        try {
            if (parameters != null) {
                handleParams(params, args, Arrays.asList(parameters));
                if (params.length() > 100) {
                    operationLog.setArgs(params.substring(0, 90) + "...");
                } else {
                    operationLog.setArgs(params.toString());
                }
            }
            operationLog.setLocation(IP2Location.convert(operationLog.getIp()));
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        com.teja.blog.Annotation.OperationLog annotation = signature.getMethod().getAnnotation(
            com.teja.blog.Annotation.OperationLog.class);
        if (annotation != null) {
            operationLog.setDescription(annotation.value());
        }

        this.operationLogRepository.save(operationLog);
    }

    private void handleParams(StringBuilder params, Object[] args, List<String> paramNames) throws JsonProcessingException {
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Map) {
                Set set = ((Map) args[i]).keySet();
                List list = new ArrayList();
                List paramList = new ArrayList();
                for (Object key : set) {
                    list.add(((Map) args[i]).get(key));
                    paramList.add(key);
                }
                handleParams(params, list.toArray(), paramList);
            } else {
                if (args[i] instanceof Serializable) {
                    Class<?> clazz = args[i].getClass();
                    try {
                        clazz.getDeclaredMethod("toString", new Class[]{null});
                        params.append(" ").append(paramNames.get(i)).append(this.objectMapper.writeValueAsString(args[i]));
                    } catch (NoSuchMethodException e) {
                        params.append(" ").append(paramNames.get(i)).append(this.objectMapper.writeValueAsString(args[i].toString()));
                    }
                } else if (args[i] instanceof MultipartFile) {
                    MultipartFile file = (MultipartFile) args[i];
                    params.append(" ").append(paramNames.get(i)).append(": ").append(file.getName());
                } else {
                    params.append(" ").append(paramNames.get(i)).append(": ").append(args[i]);
                }
            }
        }
    }
}
