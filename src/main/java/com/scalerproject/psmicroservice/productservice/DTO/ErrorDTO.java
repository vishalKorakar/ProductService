package com.scalerproject.psmicroservice.productservice.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
    private String code;
    private String message;
}
