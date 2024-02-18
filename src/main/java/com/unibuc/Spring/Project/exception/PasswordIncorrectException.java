package com.unibuc.Spring.Project.exception;

public class PasswordIncorrectException extends RuntimeException{
    public PasswordIncorrectException(){
        super("The password is incorrect!");
    }
}
