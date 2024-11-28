package com.example.ecommerce.demo.serviceImpl;

import com.example.ecommerce.demo.entity.Category;
import com.example.ecommerce.demo.entity.Product;
import com.example.ecommerce.demo.repository.CategoryRepository;
import com.example.ecommerce.demo.repository.ProductRepository;
import com.example.ecommerce.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Product addProduct(Product product)
    {

        Long categoryId = product.getCategory().getId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        Product product1 = productRepository.save(product);
        return product1;
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getById(Long id)
    {
        Product products = productRepository.findById(id).get();
        return products;
    }

    @Override
    public Product updateProductById(Long id, Product product)
    {
        Product product1 = productRepository.findById(id).get();
        product1.setName(product.getName());
        productRepository.save(product1);
        return product1;
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }


}
