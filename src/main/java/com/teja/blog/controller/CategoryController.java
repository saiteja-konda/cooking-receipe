package com.teja.blog.controller;

import com.teja.blog.model.Category;
import com.teja.blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*", exposedHeaders = "X-Total-Count")
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
    public List<Category> getcategory() {
        return categoryRepository.findAll();

    }

    @PutMapping("category/{id}")
    public ResponseEntity<?> updateCategory( @RequestBody Category oldCategory,@PathVariable Long id ) throws FileNotFoundException {
        try {
            Category category = categoryRepository.findById(id).orElseThrow(FileNotFoundException::new);
            category.setName(oldCategory.getName());
            categoryRepository.save(category);
            return new ResponseEntity(" Category update successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity("Category with given id is not found", HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        try {
            categoryRepository.deleteById(id);
            return new ResponseEntity(" Category Deleted successfully with the Id " + id, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity("No Category found with the Id " + id, HttpStatus.BAD_REQUEST);
    }
}



