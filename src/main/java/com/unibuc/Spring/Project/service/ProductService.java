package com.unibuc.Spring.Project.service;

import com.unibuc.Spring.Project.exception.ProductNotFoundException;
import com.unibuc.Spring.Project.model.Product;
import com.unibuc.Spring.Project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            return productOptional.get();
        } else {
            throw new ProductNotFoundException(id);
        }
    }
}
