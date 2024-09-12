package com.scalerproject.psmicroservice.productservice.repository;

import com.scalerproject.psmicroservice.productservice.model.Product;
import com.scalerproject.psmicroservice.productservice.repository.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    // Method for finding Product by specified id
    Product findProductById(Integer id);

    // Creates a product and saves it in the db. [The save can also be used to update a product by passing a specified column name ]
    Product save(Product product);

    // Returns all the products
    List<Product> findAll();

    // Updating is deleted.
//    Product save(Boolean isDeleted);

    /*
     * The below is an example of using HQL queries in Hibernate.
     * ==========================================================
     * The below queries gets all the info and all the products with the title provided.
     */

//    @Query("select p.id as id, p.title as title from Product p where p.title = :title")
//    ProductProjection getProductByTitle(@Param("title") String title);
//
    @Query("select p from Product p where p.id = :id and p.title = :title")
    Product findProductByIdAndtitle(@Param("id") Integer id, @Param("title") String title);

    /**
     * The below is for pagination.
     */


}
