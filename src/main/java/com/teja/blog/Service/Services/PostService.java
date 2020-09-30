package com.teja.blog.Service.Services;

import com.teja.blog.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
public interface PostService {
    List<Post> searchPost(String keyword);
}
