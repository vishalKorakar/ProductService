package com.scalerproject.psmicroservice.productservice.service;

import com.scalerproject.psmicroservice.productservice.model.Category;
import com.scalerproject.psmicroservice.productservice.model.Product;
import com.scalerproject.psmicroservice.productservice.repository.CategoryRepo;
import com.scalerproject.psmicroservice.productservice.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("selfproductservice")
public class SelfProductService implements ProductService {

    private ProductRepo productRepo;
    private CategoryService categorysvc;

    public SelfProductService(ProductRepo productRepo, CategoryService categorysvc) {
        this.productRepo = productRepo;
        this.categorysvc = categorysvc;
    }

    @Override
    public Product getProductById(Integer id) {
        Product product = productRepo.findProductById(id);
        return null;
    }

    @Override
    public Product createProduct(String title, String description, String category, String price, String imageURL) {

        Category existingCategory = categorysvc.getCategoryByTitle(category);

        if (existingCategory == null) {
            // either create a new category or provide an exception
            existingCategory = categorysvc.addCategory(category);

        }

        //Creation of product
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setCategory(existingCategory);
        product.setCreatedAt(new Date());
        product.setLastUpdatedAt(new Date());
        product.setIsDeleted(false);
        product.setImageURL(imageURL);
        product.setPrice(Double.valueOf(price));

        // saving the product in db
        Product newProduct = productRepo.save(product);

        return newProduct;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public Product deleteProduct(Integer id) {
        return null;
    }

    @Override
    public Product updateProduct(String title, String description, String category, String price, String image, Integer id) {
        return null;
    }

    @Override
    public List<Product> limitProductResults(int limit) {
        return List.of();
    }
}
