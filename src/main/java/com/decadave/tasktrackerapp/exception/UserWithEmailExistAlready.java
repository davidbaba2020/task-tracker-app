package com.decadave.tasktrackerapp.exception;

public class UserWithEmailExistAlready extends RuntimeException {
    public UserWithEmailExistAlready(String message) {
        super(message);
    }
}
