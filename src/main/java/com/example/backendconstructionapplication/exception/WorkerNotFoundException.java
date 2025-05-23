package com.example.backendconstructionapplication.exception;

public class WorkerNotFoundException extends RuntimeException {
    public WorkerNotFoundException() {
    }

    public WorkerNotFoundException(String message) {
        super(message);
    }
}
