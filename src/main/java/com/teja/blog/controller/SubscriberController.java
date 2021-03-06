package com.teja.blog.controller;

import com.teja.blog.Annotation.OperationLog;
import com.teja.blog.Service.Impletementations.SubscribersServiceImpl;
import com.teja.blog.model.Subcribers;
import com.teja.blog.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", exposedHeaders = "X-Total-Count")
public class SubscriberController {
    @Autowired
    public SubscriberRepository subscriberRepository;
    @Autowired
    public SubscribersServiceImpl subscribersService;

    @PostMapping("subscribers")
    @OperationLog("Added new Subscriber")
    public ResponseEntity<?> crateSubscriber(@RequestBody Subcribers subcribers) {
        subscriberRepository.save(subcribers);
        Map<String, Object> model = new HashMap<>();
        model.put("Name", subcribers.getName());
        model.put("location", "Bangalore,India");
        subscribersService.mySendEmail(subcribers, model);
        return new ResponseEntity<Subcribers>(subcribers, HttpStatus.CREATED);
    }

    @GetMapping("admin/subscribers")
    public List<Subcribers> getSubscriber() {
        List<Subcribers> subcribersList = subscriberRepository.findAll();
        subcribersList.forEach(s -> System.out.println(s.getEmail()));
        return subscriberRepository.findAll();
    }
}
