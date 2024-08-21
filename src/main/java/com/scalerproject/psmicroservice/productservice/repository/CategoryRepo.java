package com.scalerproject.psmicroservice.productservice.repository;

import com.scalerproject.psmicroservice.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * In the below when using jpa interface we need to provide with 2info 1st is the model name and second is the data type of
 * the Primary key of the model specified.
 */
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    Category findByTitle(String title);
    Category save(String title);
}
