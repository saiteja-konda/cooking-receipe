package com.teja.blog.repository;

import com.teja.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findCategoryByName(String category);

}

