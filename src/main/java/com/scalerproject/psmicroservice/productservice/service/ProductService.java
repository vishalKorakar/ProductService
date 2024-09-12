package com.scalerproject.psmicroservice.productservice.service;

import com.scalerproject.psmicroservice.productservice.model.Product;
import com.scalerproject.psmicroservice.productservice.repository.projections.ProductProjection;
import org.springframework.data.domain.Page;

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
    public Product updateProduct(Integer id,
                                 String title,
                                 String description,
                                 String price,
                                 String image,
                                 String category);
    public List<Product> limitProductResults(int limit);
//    public ProductProjection getProductByTitle(String title);

    public Product getProductByIdAndTitle(Integer id, String title);

    public Page<Product> getPaginatedProduct(Integer page, Integer size);
}
