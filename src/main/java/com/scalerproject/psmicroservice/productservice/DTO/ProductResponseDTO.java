package com.scalerproject.psmicroservice.productservice.DTO;

import com.scalerproject.psmicroservice.productservice.model.Category;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductResponseDTO {
    private long id;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private Category category;
}
