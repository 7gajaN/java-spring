package com.unibuc.Spring.Project.service;

import com.unibuc.Spring.Project.exception.product.ProductAlreadyExistsException;
import com.unibuc.Spring.Project.exception.product.ProductNotFoundException;
import com.unibuc.Spring.Project.model.Product;
import com.unibuc.Spring.Project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Boolean exists(String name){
        Product product = productRepository.findByName(name);
        return product != null;
    }

    public Product getProductById(long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            return productOptional.get();
        } else {
            throw new ProductNotFoundException();
        }
    }

    public Product getProductByName(String name){
        Product product = productRepository.findByName(name);

        if(product != null)
            return product;
        else
            throw new ProductNotFoundException();
    }

    public Product createProduct(Product product){
        Product productWithSameName =  productRepository.findByName(product.getName());
        if(productWithSameName != null){
            throw new ProductAlreadyExistsException();
        }

        return productRepository.save(product);
    }

    public void deleteProduct(Product product){
        Product auxProduct = productRepository.findByName(product.getName());
        if(auxProduct != null){
            productRepository.delete(product);
        }else{
            throw new ProductNotFoundException();
        }

    }



}
