package com.teja.blog.controller;

import com.teja.blog.model.Tag;
import com.teja.blog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin({"http://localhost:3000","https://saiteja-blog.herokuapp.com"})
@RestController
@RequestMapping("/")
public class TagController {

    @Autowired
    public TagRepository tagRepository;

    @GetMapping("tags")
    public List<Tag> getTags(){
        return tagRepository.findAll();
    }
}
