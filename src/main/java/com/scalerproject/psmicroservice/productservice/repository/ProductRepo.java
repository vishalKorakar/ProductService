package com.scalerproject.psmicroservice.productservice.repository;

import com.scalerproject.psmicroservice.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    // Method for finding Product by specified id
    Product findProductById(int id);

    // Creates a product and saves it in the db. [The save can also be used to update a product by passing a specified column name ]
    Product save(Product product);

    // Returns all the products
    List<Product> findAll();
}
