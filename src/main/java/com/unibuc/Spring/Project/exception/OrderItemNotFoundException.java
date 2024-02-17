package com.unibuc.Spring.Project.exception;

public class OrderItemNotFoundException extends RuntimeException{
    public OrderItemNotFoundException(long id){
        super("The item with id " + id + " does not exist");
    }
}
