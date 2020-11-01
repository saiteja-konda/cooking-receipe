package com.teja.blog.controller;

import com.teja.blog.repository.PostRepository;
import com.teja.blog.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", exposedHeaders = "X-Total-Count")
@RequestMapping("/")
public class DashBoardController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private SubscriberRepository subscriberRepository;


    class Stats {
        long totalPostCount;
        long totalSubscribers;

        public Stats(long totalPostCount, long totalSubscribers) {
            this.totalPostCount = totalPostCount;
            this.totalSubscribers = totalSubscribers;
        }

        public long getTotalPostCount() {
            return totalPostCount;
        }

        public void setTotalPostCount(long totalPostCount) {
            this.totalPostCount = totalPostCount;
        }

        public long getTotalSubscribers() {
            return totalSubscribers;
        }

        public void setTotalSubscribers(long totalSubscribers) {
            this.totalSubscribers = totalSubscribers;
        }
    }

    @GetMapping("admin/dashboard")
    public Stats myMethod() {
        Stats stats = new Stats(postRepository.count(), subscriberRepository.count());
        return stats;
    }
}
