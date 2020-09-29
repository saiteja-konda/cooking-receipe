package com.teja.blog.repository;

import com.teja.blog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
   List<Post> findAllByGenre(String genre);
   List<Post> findPostsByTypeOrderByPostedOnAsc(String type);

   Page<Post> findAllByType(String type, Pageable pageable);




}
