package com.teja.blog.Aspect;

import com.teja.blog.Service.Impletementations.VisitLogService;
import com.teja.blog.utils.IPUtil;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class VisitorLogAspect {
    @Autowired
    VisitLogService visitLogService;

    @Pointcut("@annotation(com.teja.blog.Annotation.VisitLog)")
    public void pointCut() {
    }

    @After("pointCut()")
    public void after() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes();
        String ip = IPUtil.getIp(attributes.getRequest());
        this.visitLogService.addVisitLog(ip);
    }
}
