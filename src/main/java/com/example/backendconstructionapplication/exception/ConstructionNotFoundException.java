package com.example.backendconstructionapplication.exception;

public class ConstructionNotFoundException extends RuntimeException{
    public ConstructionNotFoundException() {
    }

    public ConstructionNotFoundException(String message) {
        super(message);
    }
}
