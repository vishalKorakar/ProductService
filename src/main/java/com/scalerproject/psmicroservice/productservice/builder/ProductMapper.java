package com.scalerproject.psmicroservice.productservice.builder;

import com.scalerproject.psmicroservice.productservice.DTO.FakeStoreProductDTO;
import com.scalerproject.psmicroservice.productservice.DTO.ProductResponseDTO;
import com.scalerproject.psmicroservice.productservice.model.Category;
import com.scalerproject.psmicroservice.productservice.model.Product;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {

    // Method for returning the response for the clients from converting the model to dto
    public ProductResponseDTO convertToProductResponseDTO(Product product) {

        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setCategory(product.getCategory());
        dto.setDescription(product.getDescription());
        dto.setId(product.getId());
        dto.setPrice(product.getPrice());
        dto.setTitle(product.getTitle());
        dto.setImageURL(product.getImageURL());
        return dto;
    }

    //org.assertj.core.util.Maps to the Product Model
    public Product mapToProduct(FakeStoreProductDTO dto) {
        // Product object
        Product product = new Product();
        // Category object
        Category category = new Category();

        // set category
        category.setTitle(dto.getCategory());

        //set Product
        product.setCategory(category);
        product.setTitle(dto.getTitle());
        product.setId(dto.getId());
        product.setImageURL(dto.getImage());
        product.setPrice(Double.valueOf(dto.getPrice()));
        product.setDescription(dto.getDescription());
        return product;
    }
}
