package com.teja.blog.controller;

import com.teja.blog.Annotation.OperationLog;
import com.teja.blog.Annotation.VisitLog;
import com.teja.blog.Query.Postpage;
import com.teja.blog.Exception.ResourceNotFoundException;
import com.teja.blog.Service.Impletementations.PostSerivceImpl;
import com.teja.blog.Service.Services.PostService;
import com.teja.blog.model.Category;
import com.teja.blog.model.Post;
import com.teja.blog.repository.CategoryRepository;
import com.teja.blog.repository.CommentRepository;
import com.teja.blog.repository.PostRepository;

import com.teja.blog.utils.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.*;

@CrossOrigin(origins = "*", exposedHeaders = "X-Total-Count")
@RestController
@RequestMapping("/")
public class PostController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostSerivceImpl postSerivce;

    //Public Routes GET
    @GetMapping({"admin/post", "post"})
    @VisitLog
    public List<Post> getAllPosts() {

        return postRepository.findAll();
    }


    @GetMapping({"admin/post/{id}", "post/{id}"})
    @VisitLog
    public ResponseEntity<?> getPostbyId(@PathVariable Long id) {

        try {
            Post post = postSerivce.getPostById(id);
            post.setViews(post.getViews() + 1);
            postRepository.save(post);
            return new ResponseEntity(post, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity("No Post found with the Id " + id, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("post/count")
    public Long getPostCount() {

        return postRepository.count();

    }

    @GetMapping("post/order/views")
    public List<Post> getPostorderByViews() {

        return postRepository.findTop6ByOrderByViewsDesc();

    }

    @GetMapping("post/order/likes")
    public List<Post> getPostorderByLike() {

        return postRepository.findTop6ByOrderByLikesDesc();

    }

    @GetMapping("post/order/comments")
    public List<Post> getPostorderByComments() {

        return postRepository.findTop6ByOrderByTotalCommentsDesc();

    }

    @GetMapping("post/genres/{genre}")
    public List<Post> getPostbyGenre(@PathVariable String genre) {
        return postRepository.findAllByGenre(genre);
    }

    @GetMapping("post/genres/count/{genre}")
    public int getPostbyGenreCount(@PathVariable String genre) {
        return postRepository.findAllByGenre(genre).size();
    }

    @GetMapping("post/type/{type}")
    public List<Post> getPostbyType(@PathVariable String type) {
        return postRepository.findPostsByTypeOrderByPostedOnAsc(type);
    }

    @GetMapping("post/comments/count/{id}")
    public int getCommentCount(@PathVariable Long id) {
        return commentRepository.countCommentsByPostId(id);
    }

    @GetMapping("like/{id}")
    public int like(@PathVariable Long id) {
        Post post = postSerivce.getPostById(id);
        post.setLikes(post.getLikes() + 1);
        postRepository.save(post);
        return post.getLikes();
    }

    @GetMapping("wow/{id}")
    public int wow(@PathVariable Long id) {
        Post post = postSerivce.getPostById(id);
        post.setWow(post.getWow() + 1);
        postRepository.save(post);
        return post.getWow();
    }

    @GetMapping("laugh/{id}")
    public int laugh(@PathVariable Long id) {
        Post post = postSerivce.getPostById(id);
        post.setLaugh(post.getLaugh() + 1);
        postRepository.save(post);
        return post.getLaugh();
    }

    @GetMapping("angery/{id}")
    public int angery(@PathVariable Long id) {
        Post post = postSerivce.getPostById(id);
        post.setAngery(post.getAngery() + 1);
        postRepository.save(post);
        return post.getAngery();
    }

    @GetMapping("sad/{id}")
    public int sad(@PathVariable Long id) {
        Post post = postSerivce.getPostById(id);
        post.setSad(post.getSad() + 1);
        postRepository.save(post);
        return post.getSad();
    }

    @GetMapping("superb/{id}")
    public int superb(@PathVariable Long id) {
        Post post = postSerivce.getPostById(id);
        post.setSuperb(post.getSuperb() + 1);
        postRepository.save(post);
        return post.getSuperb();
    }

    @GetMapping("post/tags/{name}")
    public Set<Post> getPostsByTags(@PathVariable String name) {
        return postRepository.findByTagsName(name);
    }

    @GetMapping("/post/search/{keyword}")
    public Result searchPost(@PathVariable String keyword) {
        System.out.println(keyword);
        return new Result(this.postSerivce.searchPost(keyword));
    }

    //Private Routes  CREATE UPDATE DELETE
    @PostMapping("admin/post")
    @OperationLog("Added a new post")
    public ResponseEntity<?> createPost(@Valid @RequestBody Post post, BindingResult result) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity("No Category found with the given Id please create one", HttpStatus.BAD_REQUEST);
    }


    @PutMapping("admin/post/{id}")
    @OperationLog("updated post")
    public ResponseEntity<?> updatePost(@Valid @RequestBody Post oldPost, @PathVariable Long id) throws FileNotFoundException {
        try {
            Post post = postRepository.findById(id).orElseThrow(FileNotFoundException::new);
            post.setTitle(oldPost.getTitle());
            post.setDescription(oldPost.getDescription());
            post.setContent(oldPost.getContent());
            post.setCategoryId(oldPost.getCategoryId());
            post.setTags(oldPost.getTags());
            post.setImageUrl(oldPost.getImageUrl());
            post.setThumbnailImageUrl(oldPost.getThumbnailImageUrl());
            post.setType(oldPost.getType());
            Optional<Category> opt = categoryRepository.findById(oldPost.getCategoryId());
            oldPost.setGenre(opt.get().getName());
            postRepository.save(post);
            return new ResponseEntity("Post update successfully", HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity("Post with given id is not found", HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("admin/post/{id}")
    @OperationLog("Deleted post")
    public ResponseEntity<?> deletePost(@PathVariable Long id) throws ResourceNotFoundException {

        try {
            postRepository.deleteById(id);
            return new ResponseEntity(" Post Deleted successfully with the Id " + id, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return new ResponseEntity("No Post found with the Id " + id, HttpStatus.BAD_REQUEST);
    }

}
