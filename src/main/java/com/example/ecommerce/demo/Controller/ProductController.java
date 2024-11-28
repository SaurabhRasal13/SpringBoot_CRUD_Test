package com.example.ecommerce.demo.Controller;

import com.example.ecommerce.demo.entity.Product;
import com.example.ecommerce.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product)
    {
        Product newProduct = productService.addProduct(product);
        return newProduct;
    }

    @GetMapping
    public List<Product> getAllCategory(Pageable pageable)
    {
        Page<Product> products = productService.getAll(pageable);
        return products.getContent();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id)
    {
        Product product = productService.getById(id);
        return product;
    }

    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable Long id, @RequestBody Product product)
    {
        Product updatedProduct = productService.updateProductById(id, product);
        return updatedProduct;
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id)
    {
        productService.deleteProductById(id);
    }
}
