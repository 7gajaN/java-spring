package com.unibuc.Spring.Project.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(long id){
        super("The order with id " + id + "does not exist");
    }
}
