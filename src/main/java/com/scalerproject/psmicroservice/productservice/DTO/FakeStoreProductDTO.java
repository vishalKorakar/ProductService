package com.scalerproject.psmicroservice.productservice.DTO;

import com.scalerproject.psmicroservice.productservice.model.Category;
import com.scalerproject.psmicroservice.productservice.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private int id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;
}
