package com.scalerproject.psmicroservice.productservice.model;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category extends BaseModel implements Serializable {
    private String title;
}
