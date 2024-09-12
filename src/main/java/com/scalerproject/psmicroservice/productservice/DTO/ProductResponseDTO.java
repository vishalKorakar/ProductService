package com.scalerproject.psmicroservice.productservice.DTO;

import com.scalerproject.psmicroservice.productservice.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
public class ProductResponseDTO implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private Date createdAt;
    private Date lastUpdatedAt;
    private Boolean isDeleted;
    private Category category;
}
