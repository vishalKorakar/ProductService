package com.scalerproject.psmicroservice.productservice.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequestDTO {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;
}
