package com.example.ecommerce.demo.service;

import com.example.ecommerce.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    public Product addProduct(Product product);

    public Page<Product> getAll(Pageable pageable);

    public Product getById(Long id);

    public Product updateProductById(Long id, Product product);

    public void deleteProductById(Long id);



}
