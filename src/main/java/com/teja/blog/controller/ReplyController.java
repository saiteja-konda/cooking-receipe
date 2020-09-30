package com.teja.blog.controller;

import com.teja.blog.Annotation.OperationLog;
import com.teja.blog.model.Comment;
import com.teja.blog.model.Reply;
import com.teja.blog.repository.CommentRepository;
import com.teja.blog.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class ReplyController {
    @Autowired
    public ReplyRepository replyRepository;

    @Autowired
    public CommentRepository commentRepository;

    @PostMapping("reply/{id}")
    @OperationLog("New Reply to comment")
    public Reply addReply(@RequestBody Reply reply, @PathVariable Long id) {

        Comment c = commentRepository.findById(id).orElse(null);
        int y = c.getTotalReplies();
        c.setTotalReplies(y + 1);
        commentRepository.save(c);

        return commentRepository.findById(id).map(comment -> {
            reply.setComment(comment);
            comment.getReplies().add(reply);

            return replyRepository.save(reply);
        }).orElseThrow(null);
    }


    @GetMapping("reply+/{id}")
    private Reply upVoteReply(@PathVariable Long id) {
        Reply c = replyRepository.findById(id).orElse(null);
        int x = c.getVotes();
        c.setVotes(x + 1);
        replyRepository.save(c);
        return replyRepository.findById(id).orElse(null);
    }

    @GetMapping("reply-/{id}")
    private Reply downVoteReply(@PathVariable Long id) {
        Reply c = replyRepository.findById(id).orElse(null);
        int x = c.getVotes();
        c.setVotes(x - 1);
        replyRepository.save(c);
        return replyRepository.findById(id).orElse(null);
    }


    //Only Admin can perform this Request

    @DeleteMapping("reply/{id}")
    public ResponseEntity<?> deleteReply(@PathVariable Long id) {
        replyRepository.deleteById(id);
        return new ResponseEntity(" Reply Deleted successfully with the Id " + id, HttpStatus.ACCEPTED);

    }

}
