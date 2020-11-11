package com.teja.blog.Service.Impletementations;

import com.teja.blog.Service.Services.PostService;
import com.teja.blog.model.Post;
import com.teja.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service


public class PostSerivceImpl implements PostService {
    @Autowired
    public PostRepository postRepository;


    @Override
    @Cacheable("post")
    public Post getPostById(Long id) {
        return getPostSlow(id);
    }

    private Post getPostSlow(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        post.setViews(post.getViews() + 1);
        return postRepository.save(post);
    }


    @Override
    public List<Post> searchPost(String keyword) {
        Sort sort = Sort.by(Sort.Direction.DESC, "postedOn");
        if (!StringUtils.isEmpty(keyword)) {
            return this.postRepository.findAll(new Specification<Post>() {
                @Override
                public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> criteriaQuery,
                                             CriteriaBuilder criteriaBuilder) {
                    String queryString = "%" + keyword + "%";
                    Predicate title = criteriaBuilder.like(root.get("title"), queryString);
                    Predicate content = criteriaBuilder.like(root.get("content"), queryString);
                    Predicate genre = criteriaBuilder.like(root.get("genre"), queryString);
                    Predicate type = criteriaBuilder.like(root.get("type"), queryString);
//                    Predicate tags = criteriaBuilder.like(root.get("tags"), queryString);
                    return criteriaBuilder.or(title, content, genre, type
//                        , tags
                    );
                }
            }, sort);
        }
        return this.postRepository.findAll(sort);
    }
}
