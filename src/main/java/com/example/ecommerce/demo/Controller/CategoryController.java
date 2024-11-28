package com.example.ecommerce.demo.Controller;

import com.example.ecommerce.demo.entity.Category;
import com.example.ecommerce.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public Category addCategory(@RequestBody Category category)
    {
        Category newCategory = categoryService.addCategory(category);
        return newCategory;
    }

    @GetMapping
    public List<Category> getAllCategory(Pageable pageable)
    {
       Page<Category> categories = categoryService.getAll(pageable);
       return categories.getContent();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id)
    {
        Category category = categoryService.getById(id);
        return category;
    }

    @PutMapping("/{id}")
    public Category updateCategoryById(@PathVariable Long id, @RequestBody Category category)
    {
        Category updatedCategory = categoryService.updateCategoryById(id, category);
        return updatedCategory;
    }


    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id)
    {
        categoryService.deleteCategoryById(id);
    }
}
