package com.scalerproject.psmicroservice.productservice.service;

import com.scalerproject.psmicroservice.productservice.model.Category;
import com.scalerproject.psmicroservice.productservice.model.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(Integer id);
    public Product createProduct(String title,
                                 String description,
                                 String category,
                                 String price,
                                 String imageURL);
    public List<Product> getAllProduct();
    public Product deleteProduct(Integer id);
    public Product updateProduct(String title,
                                 String description,
                                 String category,
                                 String price,
                                 String image,
                                 Integer id);
//    public List<Category> getAllCategories();
//    public List<Product> getProductByCategory(String categoryName);
    public List<Product> limitProductResults(int limit);
}
