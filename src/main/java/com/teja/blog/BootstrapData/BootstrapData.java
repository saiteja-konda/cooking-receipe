package com.teja.blog.BootstrapData;

import com.github.javafaker.Faker;
import com.teja.blog.model.Category;
import com.teja.blog.model.Post;
import com.teja.blog.repository.CategoryRepository;
import com.teja.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    @Autowired
    public PostRepository postRepository;
    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Faker");
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            Post post = new Post();
            post.setTitle(faker.programmingLanguage().name());
            post.setContent(faker.lorem().paragraph(3));
            post.setDescription(faker.lorem().sentence(15));
//            post.setCategoryId(faker.number().numberBetween(1,10));
            postRepository.save(post);
        }
//        for (int i = 0; i < 4; i++) {
//            Category category = new Category();
//            category.setName(faker.music().genre());
//            categoryRepository.save(category);
//        }
        System.out.println("Fake posts count" + postRepository.count());
        System.out.println("Fake Category count" + categoryRepository.count());

    }
}
