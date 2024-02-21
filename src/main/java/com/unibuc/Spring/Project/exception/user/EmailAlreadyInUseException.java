package com.unibuc.Spring.Project.exception.user;

public class EmailAlreadyInUseException extends RuntimeException{
    public EmailAlreadyInUseException(){
        super("Email is already in use by another user");
    }
}
