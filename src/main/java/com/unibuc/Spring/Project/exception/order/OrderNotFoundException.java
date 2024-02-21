package com.unibuc.Spring.Project.exception.order;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(long id){
        super("The order with id " + id + "does not exist");
    }
}
