package com.scalerproject.psmicroservice.productservice.DTO;

import com.scalerproject.psmicroservice.productservice.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.net.Inet4Address;

@Getter
@Setter
public class DeletedProductResponseDTO {
    private Integer id;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private Boolean isDeleted;
    private Category category;
}
