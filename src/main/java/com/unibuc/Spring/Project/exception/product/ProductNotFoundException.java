package com.unibuc.Spring.Project.exception.product;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(){
        super("Product not found");
    }

}
