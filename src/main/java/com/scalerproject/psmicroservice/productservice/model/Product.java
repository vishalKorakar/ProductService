package com.scalerproject.psmicroservice.productservice.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private long id;
    private String title;
    private String description;
    private double price;
    private String imageURL;

    private Category category; //this is a field from category model
}
