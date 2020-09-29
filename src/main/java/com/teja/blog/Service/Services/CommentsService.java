package com.teja.blog.Service.Services;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface CommentsService {
    void commentNotifcation(String postTitle,Map<String, Object> model);
}
