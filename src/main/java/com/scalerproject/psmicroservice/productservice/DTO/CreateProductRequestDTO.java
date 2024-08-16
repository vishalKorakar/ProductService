package com.scalerproject.psmicroservice.productservice.DTO;

import lombok.Getter;

@Getter
public class CreateProductRequestDTO {
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;
}
