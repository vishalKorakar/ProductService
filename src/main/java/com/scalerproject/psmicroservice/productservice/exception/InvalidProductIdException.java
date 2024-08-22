package com.scalerproject.psmicroservice.productservice.exception;

public class InvalidProductIdException extends Exception{

    // Code block when we do not pass any message in the parameter.
    public InvalidProductIdException() {
    }

    // Code block when we do pass any message in the parameter
    public InvalidProductIdException(String message) {
        super(message);
    }
}
