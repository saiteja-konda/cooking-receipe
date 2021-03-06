package com.teja.blog.controller;
import com.teja.blog.Service.Impletementations.CommentServiceImpl;
import com.teja.blog.model.Comment;

import com.teja.blog.model.Post;
import com.teja.blog.repository.CommentRepository;
import com.teja.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class CommentsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    public CommentServiceImpl commentService;

    @PostMapping("comment/{id}")
    private Comment addComment(@RequestBody Comment comment, @PathVariable(value = "id") Long id) {

        Post p = postRepository.findById(id).orElse(null);
        int x = p.getTotalComments();
        p.setTotalComments(x + 1);
        postRepository.save(p);

        return postRepository.findById(id).map(post -> {
            comment.setPost(post);
            post.getComments().add(comment);
//Sending email notification

            Map<String, Object> model = new HashMap<>();
            model.put("Title", post.getTitle());
            model.put("Name", comment.getCommentor());
            model.put("Comment", comment.getComment());
//            commentService.commentNotifcation(post.getTitle(), model);

            return commentRepository.save(comment);
        }).orElseThrow(null);
    }

    @GetMapping("comment+/{id}")
    private Comment upVoteComment(@PathVariable Long id) {
        Comment c = commentRepository.findById(id).orElse(null);
        int x = c.getVotes();
        c.setVotes(x + 1);
        commentRepository.save(c);
        return commentRepository.findById(id).orElse(null);
    }

    @GetMapping("comment-/{id}")
    private Comment downVoteComment(@PathVariable Long id) {
        Comment c = commentRepository.findById(id).orElse(null);
        int x = c.getVotes();
        c.setVotes(x - 1);
        commentRepository.save(c);
        return commentRepository.findById(id).orElse(null);
    }

    //Only Admin can perform this Request

    @DeleteMapping("admin/comment/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return new ResponseEntity(" Comment Deleted successfully with the Id " + id, HttpStatus.ACCEPTED);
    }
}
