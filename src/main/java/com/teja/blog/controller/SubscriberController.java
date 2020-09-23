package com.teja.blog.controller;

import com.teja.blog.model.Subcribers;
import com.teja.blog.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class SubscriberController {
    @Autowired
    public SubscriberRepository subscriberRepository;

    @PostMapping("/subscribers")
    public ResponseEntity<?> crateSubscriber(@RequestBody Subcribers subcribers){
        subscriberRepository.save(subcribers);
        return new ResponseEntity<Subcribers>(subcribers, HttpStatus.CREATED);
    }

    @GetMapping("/subscribers")
    public List<Subcribers> getSubscriber(){
    return subscriberRepository.findAll();
    }
}
