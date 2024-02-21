package com.unibuc.Spring.Project.exception.user;

public class UsernameAlreadyInUseException extends RuntimeException{
    public UsernameAlreadyInUseException(){
        super("The username is already in use");
    }
}
