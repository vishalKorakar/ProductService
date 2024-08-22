package com.scalerproject.psmicroservice.productservice.Advise;

import com.scalerproject.psmicroservice.productservice.DTO.ErrorDTO;
import com.scalerproject.psmicroservice.productservice.exception.InvalidProductIdException;
import com.scalerproject.psmicroservice.productservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.InvalidAlgorithmParameterException;

@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ErrorDTO> handleInvalidProductIdException(InvalidProductIdException e) {
        ErrorDTO dto = new ErrorDTO();
        dto.setCode("Invalid Id : code 502"); // this is not HTTP status code.
        dto.setMessage(e.getMessage());

        return new ResponseEntity<>(dto, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException exception) {
        ErrorDTO dto = new ErrorDTO();
        dto.setCode("product not found : code 404"); // this is not HTTP status code.
        dto.setMessage(exception.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception exception) {
        ErrorDTO dto = new ErrorDTO();
        dto.setCode("some_status_code"); // this is not HTTP status code.
        dto.setMessage("Product Not Found..");
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
