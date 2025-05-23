package com.example.backendconstructionapplication.exception;

public class MaterialNotFoundException extends RuntimeException{
    public MaterialNotFoundException() {
    }

    public MaterialNotFoundException(String message) {
        super(message);
    }
}
