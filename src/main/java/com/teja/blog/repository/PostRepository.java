package com.teja.blog.repository;

import com.teja.blog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
    List<Post> findAllByGenre(String genre);

    List<Post> findPostsByTypeOrderByPostedOnAsc(String type);

    Page<Post> findAllByType(String type, Pageable pageable);

    @Transactional(readOnly = true)
    Set<Post> findByTagsName(String name);

    List<Post> findTop6ByOrderByViewsDesc();

    List<Post> findTop6ByOrderByTotalCommentsDesc();

    List<Post> findTop6ByOrderByLikesDesc();
}
/*
//TODO
* @Transactional(readOnly = true)
Page<Post> findByTagsName(String name, Pageable pageable);
*
* */
