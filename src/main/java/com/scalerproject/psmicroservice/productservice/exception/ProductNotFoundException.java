package com.scalerproject.psmicroservice.productservice.exception;

public class ProductNotFoundException extends Exception{

    // Code block when we do not pass any message in the parameter
    public ProductNotFoundException() {
    }

    // Code block when we do pass any message in the parameter
    public ProductNotFoundException(String message) {
        super(message);
    }
}
