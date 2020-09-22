package com.teja.blog.controller;

import com.teja.blog.model.Category;
import com.teja.blog.model.Post;
import com.teja.blog.repository.CategoryRepository;
import com.teja.blog.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/")
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("post")
    public ResponseEntity<?> createPost(@Valid @RequestBody Post post, BindingResult result) throws Exception {

        Optional<Category> opt = categoryRepository.findById(post.getCategoryId());
        post.setGenre(opt.get().getName());

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        postRepository.save(post);
        return new ResponseEntity<Post>(post, HttpStatus.CREATED);
    }

    @GetMapping("post")
    public List<Post> getAllPosts() {
        return postRepository.findAll();

    }

    @GetMapping("post/{id}")
    public ResponseEntity<?> getPost(Post post, @PathVariable Long id, BindingResult result) {

        try {
            return new ResponseEntity<Post>(postRepository.findById(id).orElseThrow(Exception::new), HttpStatus.ACCEPTED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity("No Post found with the Id " + id , HttpStatus.BAD_REQUEST);
    }

    @GetMapping("posts")
    public ResponseEntity getposts(Model model) {
        return ResponseEntity.ok(model);
    }
}
