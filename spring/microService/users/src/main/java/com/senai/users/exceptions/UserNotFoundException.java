package com.senai.users.exceptions;

public class UserNotFoundException extends UserException{

    public UserNotFoundException() {
        super("User not found!","user-not-found");
    }

    public UserNotFoundException(String message, String code) {
        super(message, code);
    }
}
