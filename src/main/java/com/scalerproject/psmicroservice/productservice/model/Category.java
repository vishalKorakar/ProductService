package com.scalerproject.psmicroservice.productservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category extends BaseModel implements Serializable {
    private String title;

    /**
     * The below can be included based on the user requirement for fetching lists of products from the db
     * for a category specified. This can also be fetched by going to product table and specifying the category name.
     * The below will reduce that query timing for the above idea.
     */

    @JsonIgnore // This prevents the result from going a infinite loop. this is because each category have products and each products model json has a category which in turn gets the category of the same.
    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE}) // @OneToMany(mappedBy = "category") This is used to make spring understand that the relationships are the same.if we do not mention this then hibernate creates a new FK for the below and the relation specified in the product model
    List<Product> productList;
}
