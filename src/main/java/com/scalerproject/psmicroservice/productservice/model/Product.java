package com.scalerproject.psmicroservice.productservice.model;


import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product extends BaseModel implements Serializable {
    private String title;
    private String description;
    private double price;
    private String imageURL;

    private Category category; //this is a field from category model
}
