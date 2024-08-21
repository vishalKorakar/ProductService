package com.scalerproject.psmicroservice.productservice.service;

import com.scalerproject.psmicroservice.productservice.model.Category;
import com.scalerproject.psmicroservice.productservice.model.Product;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();
    public List<Product> getProductByCategory(String categoryName);
    public Category getCategoryByTitle(String title);
    public Category addCategory(String title);

}
