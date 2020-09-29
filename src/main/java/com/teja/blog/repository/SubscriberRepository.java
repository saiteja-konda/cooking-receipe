package com.teja.blog.repository;

import com.teja.blog.model.Subcribers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubscriberRepository extends JpaRepository<Subcribers,Long> {

}
