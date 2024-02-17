package com.unibuc.Spring.Project.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(long id){
        super("Product with id " + id + " doesn't exist");
    }

}
