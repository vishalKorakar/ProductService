package com.scalerproject.psmicroservice.productservice.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequest {
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;
}
