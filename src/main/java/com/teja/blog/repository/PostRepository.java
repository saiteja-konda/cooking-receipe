package com.teja.blog.repository;

import com.teja.blog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PostRepository extends JpaRepository<Post,Long> {
   List<Post> findAllByGenre(String genre);
   List<Post> findPostsByTypeOrderByPostedOnAsc(String type);

   Page<Post> findAllByType(String type, Pageable pageable);

    @Transactional(readOnly = true)
    Set<Post> findByTagsName(String name);



}
