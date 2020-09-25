package com.teja.blog.repository;

import com.teja.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    Comment findByPostId(Long id);
    int countCommentsByPostId(Long id);

}
