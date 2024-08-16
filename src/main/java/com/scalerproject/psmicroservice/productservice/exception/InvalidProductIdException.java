package com.scalerproject.psmicroservice.productservice.exception;

public class InvalidProductIdException extends Exception{
    public InvalidProductIdException() {
    }

    public InvalidProductIdException(String message) {
        super(message);
    }
}
