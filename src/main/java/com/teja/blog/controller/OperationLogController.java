package com.teja.blog.controller;

import com.teja.blog.model.OperationLog;
import com.teja.blog.repository.OperationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", exposedHeaders = "X-Total-Count")
@RestController
@RequestMapping("/")
public class OperationLogController {
    @Autowired
    private OperationLogRepository logRepository;

    @GetMapping("logs")
    public List<OperationLog> getlogs() {
        return logRepository.findAll();
    }
}
