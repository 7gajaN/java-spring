package com.unibuc.Spring.Project.exception;

public class UsernameAlreadyInUseException extends RuntimeException{
    public UsernameAlreadyInUseException(){
        super("The username is already in use");
    }
}
