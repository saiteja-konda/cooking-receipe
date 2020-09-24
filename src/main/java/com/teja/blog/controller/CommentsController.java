package com.teja.blog.controller;

import com.teja.blog.model.Comment;

import com.teja.blog.model.Post;
import com.teja.blog.repository.CommentRepository;
import com.teja.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CommentsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    private Long id;

    @PostMapping("comment/{id}")
    private Comment addComment(@RequestBody Comment comment, @PathVariable(value = "id") Long id) {
//        Post post = postRepository.findById(id).orElse(null);
//        comment.setComment(comment.getComment());
//        comment.setDisplayName(comment.getDisplayName());
//        comment.setSkey(comment.getSkey());
//        comment.setPost(post);
//        commentRepository.save(comment);
        return postRepository.findById(id).map(post -> {
            comment.setPost(post);
            post.getComment().add(comment);
            return commentRepository.save(comment);
        }).orElseThrow(null);
    }
}
