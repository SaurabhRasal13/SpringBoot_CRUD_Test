package com.example.ecommerce.demo.serviceImpl;

import com.example.ecommerce.demo.entity.Category;
import com.example.ecommerce.demo.repository.CategoryRepository;
import com.example.ecommerce.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category addCategory(Category category)
    {
        Category category1 = categoryRepository.save(category);
        return category1;
    }

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category getById(Long id)
    {
        Category category = categoryRepository.findById(id).get();
        return category;
    }

    @Override
    public Category updateCategoryById(Long id, Category category)
    {
        Category category1 = categoryRepository.findById(id).get();
        category1.setName(category.getName());
        categoryRepository.save(category1);
        return category1;
    }

    @Override
    public void deleteCategoryById(Long id)
    {
        categoryRepository.deleteById(id);
    }
}
