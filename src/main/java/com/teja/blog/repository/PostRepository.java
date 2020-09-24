package com.teja.blog.repository;

import com.teja.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
   List<Post> findAllByGenre(String genre);
   List<Post> findPostsByTypeOrderByPostedOnAsc(String type);
}
