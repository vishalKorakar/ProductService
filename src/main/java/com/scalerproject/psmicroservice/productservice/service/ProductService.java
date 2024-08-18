package com.scalerproject.psmicroservice.productservice.service;

import com.scalerproject.psmicroservice.productservice.model.Category;
import com.scalerproject.psmicroservice.productservice.model.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(long id);
    public Product createProduct(String title,
                                 String description,
                                 String category,
                                 String price,
                                 String image);
    public List<Product> getAllProduct();
    public Product deleteProduct(long id);
    public Product updateProduct(String title,
                                 String description,
                                 String category,
                                 String price,
                                 String image,
                                 long id);
    public List<Category> getAllCategories();
    public List<Product> getProductByCategory(String categoryName);
    public List<Product> limitProductResults(int limit);
}
