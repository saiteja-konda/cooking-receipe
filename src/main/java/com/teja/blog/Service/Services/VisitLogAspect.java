package com.teja.blog.Service.Services;

import com.teja.blog.model.VisitLog;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
@Transactional
public interface VisitLogAspect {

    void addVisitLog(String ip);

    Page<VisitLog> listVisitLog(Integer pageSize, Integer page, Date startDate, Date endDate);

    void deleteVisitLog(Long id);
}
