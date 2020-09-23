package com.teja.blog.controller;

import com.teja.blog.model.Category;
import com.teja.blog.model.Post;
import com.teja.blog.repository.CategoryRepository;
import com.teja.blog.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/")
public class PostController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    //Public Routes GET
    @GetMapping("post")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("post/{id}")
    public ResponseEntity<?> getPostbyId(@PathVariable Long id) {

        try {
            return new ResponseEntity(postRepository.findById(id).orElseThrow(Exception::new), HttpStatus.ACCEPTED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity("No Post found with the Id " + id, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("post/count")
    public Long getPostCount() {

        return postRepository.count();

    }

    @GetMapping("post/genres/{genre}")
    public List<Post> getPostbyGenre(@PathVariable String genre) {
        return postRepository.findAllByGenre(genre);
    }
    @GetMapping("post/genres/count/{genre}")
    public int getPostbyGenreCount(@PathVariable String genre) {
        return postRepository.findAllByGenre(genre).size();
    }

//    @GetMapping("post/genres/count/{genre}")
//    public Long getPostCountByGenre(@PathVariable String genre) {
//        return postRepository.
//    }

    //Private Routes  CREATE UPDATE DELETE
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

    @PutMapping("post/{id}")
    public ResponseEntity<?> updatePost(@Valid @RequestBody Post oldPost, @PathVariable Long id) {

        Post post = postRepository.findById(id).orElse(null);
        post.setTitle(oldPost.getTitle());
        post.setDescription(oldPost.getDescription());
        post.setContent(oldPost.getContent());
        post.setCategoryId(oldPost.getCategoryId());
        // set genre with reference to categoryId
        Optional<Category> opt = categoryRepository.findById(oldPost.getCategoryId());
        oldPost.setGenre(opt.get().getName());
        postRepository.save(post);
        return new ResponseEntity("update successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {

        try {
            postRepository.deleteById(id);
            return new ResponseEntity(" Post Deleted successfully with the Id " + id, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity("No Post found with the Id " + id, HttpStatus.BAD_REQUEST);
    }

}
