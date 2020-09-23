package com.teja.blog.repository;

import com.teja.blog.model.Subcribers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subcribers,Long> {
}
