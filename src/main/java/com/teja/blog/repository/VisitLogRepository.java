package com.teja.blog.repository;

import com.teja.blog.model.VisitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface VisitLogRepository extends JpaRepository<VisitLog, Long>,
    JpaSpecificationExecutor<VisitLog> {

    List<VisitLog> findByIp(String ip);
}
