package com.teja.blog.controller;

import com.teja.blog.model.Category;
import com.teja.blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;


    @PostMapping("category")
    public ResponseEntity<Category> createCatefory(@Valid @RequestBody Category category) throws Exception {
        try {
            categoryRepository.save(category);
            return new ResponseEntity<Category>(category, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity("category with name '" + category.getName() + "' already exists", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("category")
    public List<Category> getcategory(Category category) {
        return categoryRepository.findAll();

    }
}


