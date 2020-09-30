package com.teja.blog.Service.Services;

import com.teja.blog.model.OperationLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Async;

public interface OperationLogService {

    Page<OperationLog> listOperationLogs(Integer pageSize, Integer page);

    void deleteOperationLog(Long id);

    @Async
    void addOperationLog(ProceedingJoinPoint proceedingJoinPoint, OperationLog operationLog);
}

