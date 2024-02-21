package com.unibuc.Spring.Project.exception.auth;

public class PasswordIncorrectException extends RuntimeException{
    public PasswordIncorrectException(){
        super("The password is incorrect!");
    }
}
