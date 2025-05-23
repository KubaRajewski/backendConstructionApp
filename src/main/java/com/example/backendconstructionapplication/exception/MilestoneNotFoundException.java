package com.example.backendconstructionapplication.exception;

public class MilestoneNotFoundException extends RuntimeException {
    public MilestoneNotFoundException() {
    }

    public MilestoneNotFoundException(String message) {
        super(message);
    }
}
