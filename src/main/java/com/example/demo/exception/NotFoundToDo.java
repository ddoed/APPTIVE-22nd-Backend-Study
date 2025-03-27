package com.example.demo.exception;

public class NotFoundToDo extends RuntimeException {
    public NotFoundToDo(String message) {
        super(message);
    }
}
