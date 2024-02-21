package com.unibuc.Spring.Project.exception.product;

public class ProductAlreadyExistsException extends RuntimeException{
    public ProductAlreadyExistsException(){
        super("Product with this name already exists!");
    }
}
