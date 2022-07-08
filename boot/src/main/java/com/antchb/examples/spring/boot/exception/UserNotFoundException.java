package com.antchb.examples.spring.boot.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long userId) {
        super("User Not Found. ID: " + userId);
    }

}
