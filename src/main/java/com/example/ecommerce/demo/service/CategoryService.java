package com.example.ecommerce.demo.service;

import com.example.ecommerce.demo.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    public Category addCategory(Category category);

    public Page<Category> getAll(Pageable pageable);

    public Category getById(Long id);

    public Category updateCategoryById(Long id, Category category);

    public void deleteCategoryById(Long id);
}
