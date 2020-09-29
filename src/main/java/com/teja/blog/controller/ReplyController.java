package com.teja.blog.controller;

import com.teja.blog.model.Reply;
import com.teja.blog.repository.CommentRepository;
import com.teja.blog.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class ReplyController {
    @Autowired
    public ReplyRepository replyRepository;

    @Autowired
    public CommentRepository commentRepository;

    @PostMapping("reply/{id}")
    public Reply addReply(@RequestBody Reply reply, @PathVariable Long id) {
        return commentRepository.findById(id).map(comment -> {
            reply.setComment(comment);
            comment.getReplies().add(reply);

            return replyRepository.save(reply);
        }).orElseThrow(null);
    }

}
