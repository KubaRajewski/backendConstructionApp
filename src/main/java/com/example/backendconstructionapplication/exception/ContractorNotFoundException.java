package com.example.backendconstructionapplication.exception;

public class ContractorNotFoundException extends RuntimeException{
    public ContractorNotFoundException() {
    }

    public ContractorNotFoundException(String message) {
        super(message);
    }
}
