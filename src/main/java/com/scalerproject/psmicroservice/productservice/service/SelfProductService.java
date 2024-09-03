package com.scalerproject.psmicroservice.productservice.service;

import com.scalerproject.psmicroservice.productservice.model.Category;
import com.scalerproject.psmicroservice.productservice.model.Product;
import com.scalerproject.psmicroservice.productservice.repository.ProductRepo;
import com.scalerproject.psmicroservice.productservice.repository.projections.ProductProjection;
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

        if (product == null) {
            return null;
        }
        return product;
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
        List<Product> allProducts = productRepo.findAll();

        if (allProducts == null) {
            return null;
        }

        return allProducts;
    }

    @Override
    public Product deleteProduct(Integer id) {
        Product deletedProducts = productRepo.findProductById(id);

        if (deletedProducts == null) {
            return null;
        }

        deletedProducts.setIsDeleted(true);

        return productRepo.save(deletedProducts);
    }

    @Override
    public Product updateProduct(Integer id, String title, String description, String price, String image, String category) {
        Product updatedProduct = productRepo.findProductById(id);

        if (updatedProduct == null) {
            return null;
        }

//        Category cat = new Category();
//        cat.setTitle(category);

        updatedProduct.setTitle(title);
        updatedProduct.setDescription(description);
        updatedProduct.setPrice(Double.valueOf(price));
        updatedProduct.setLastUpdatedAt(new Date());
//        updatedProduct.setCategory(cat);
        updatedProduct.setImageURL(image);

        return productRepo.save(updatedProduct);
    }

    @Override
    public List<Product> limitProductResults(int limit) {
        return List.of();
    }

    @Override
    public ProductProjection getProductByTitle(String title) {
        return productRepo.getProductByTitle(title);
    }

    @Override
    public Product getProductByPrice(Double price) {
        Product product = productRepo.findProductByPrice(price);

        if (product == null) {
            return null;
        }
        return product;
    }
}
