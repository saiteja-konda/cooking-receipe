package com.teja.blog.Aspect;

import com.teja.blog.Service.Impletementations.OperationLogServiceImpl;
import com.teja.blog.model.OperationLog;
import com.teja.blog.utils.IPUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Component
public class OperationLogAspect {
    @Autowired
    private OperationLogServiceImpl operationLogServiceImpl;

    @Pointcut("@annotation(com.teja.blog.Annotation.OperationLog)")
    public void pointCut(){
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        Long startTime = System.currentTimeMillis();
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
//            throw new CommonException(throwable.getMessage());
        }
        Long endTime = System.currentTimeMillis();
        OperationLog operationLog = new OperationLog();
        operationLog.setTimeSpent(endTime - startTime);
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(requestAttributes).getRequest();
        String ip = IPUtil.getIp(request);
        operationLog.setIp(ip);
        this.operationLogServiceImpl.addOperationLog(proceedingJoinPoint, operationLog);
        return result;
    }
}
