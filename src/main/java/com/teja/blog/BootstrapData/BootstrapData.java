package com.teja.blog.BootstrapData;

import com.github.javafaker.Faker;
import com.teja.blog.model.Category;
import com.teja.blog.model.Post;
import com.teja.blog.model.Subcribers;
import com.teja.blog.repository.CategoryRepository;
import com.teja.blog.repository.PostRepository;
import com.teja.blog.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class BootstrapData implements CommandLineRunner {
    @Autowired
    public PostRepository postRepository;
    @Autowired
    public CategoryRepository categoryRepository;
    long generatedLong = new Random().nextLong();
    @Autowired
    public SubscriberRepository subscriberRepository;
    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Faker");
        Faker faker = new Faker();

//        for (int i = 0; i < 4; i++) {
//            Post post = new Post();
//            post.setTitle(faker.rickAndMorty().character());
//            post.setContent(faker.lorem().paragraph(3));
//            post.setDescription(faker.lorem().sentence(15));
////            post.setCategoryId(generatedLong);
//            post.setType("Trending");
//            postRepository.save(post);
//
//            for (int j = 0; j < 1; j++) {
//                Category category = new Category();
//                category.setName(faker.gameOfThrones().city());
//                categoryRepository.save(category);
//            }
//        }
//
//        for (int i = 0; i < 5; i ++){
//            Subcribers subcribers = new Subcribers();
//            subcribers.setName(faker.name().toString());
//            subcribers.setName(faker.gameOfThrones().character()+"@"+faker.gameOfThrones().house()+".com");
//            subscriberRepository.save(subcribers);
//
//        }
        System.out.println("Fake posts count" + postRepository.count());
        System.out.println("Fake Category count" + categoryRepository.count());

    }
}
