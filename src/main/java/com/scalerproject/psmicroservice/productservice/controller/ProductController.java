package com.scalerproject.psmicroservice.productservice.controller;


import com.scalerproject.psmicroservice.productservice.DTO.CreateProductRequestDTO;
import com.scalerproject.psmicroservice.productservice.DTO.DeletedProductResponseDTO;
import com.scalerproject.psmicroservice.productservice.DTO.ProductResponseDTO;
import com.scalerproject.psmicroservice.productservice.DTO.UpdateProductRequestDTO;
import com.scalerproject.psmicroservice.productservice.builder.ProductMapper;
import com.scalerproject.psmicroservice.productservice.exception.InvalidProductIdException;
import com.scalerproject.psmicroservice.productservice.exception.ProductNotFoundException;
import com.scalerproject.psmicroservice.productservice.model.Product;
import com.scalerproject.psmicroservice.productservice.service.CategoryService;
import com.scalerproject.psmicroservice.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    /**
     * it can also be named as (private FakeStoreService svc)
     * But as we are implementing the ProductService interface into the FakeStoreService class
     * we are using the ProductService name here
     */
    private ProductService svc;
    private CategoryService categoryService;
    private ProductMapper mapper;

    public ProductController(@Qualifier("selfproductservice") ProductService svc, ProductMapper mapper, CategoryService categoryService) {
        this.svc = svc;
        this.mapper = mapper;
        this.categoryService = categoryService;
    }

    @PostMapping("/products")
    public ProductResponseDTO createProduct(@RequestBody CreateProductRequestDTO dto) {
        // Validation

        // Step 1: Call to service layer
        Product productCreate = svc.createProduct(dto.getTitle(),
                dto.getDescription(), dto.getCategory(), dto.getPrice(), dto.getImage());

        // S3. convert this to DTO and return.
        return mapper.convertToProductResponseDTO(productCreate);
    }

    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductByID(@PathVariable("id") Integer id) throws InvalidProductIdException, ProductNotFoundException {


        if (id == null) {
            throw new InvalidProductIdException("The provided code is incorrect, please provide the correct id.");
        }

        // Step 1:  call to service layer
        Product product = svc.getProductById(id);
        if (product == null) {
            throw new ProductNotFoundException("The product with id " + id + " does not exist.");
        }

        // Step 2: Map to ResponseDTO
        ProductResponseDTO response = mapper.convertToProductResponseDTO(product);

        // Step 3: Return
        return response;
    }

//    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProduct() throws ProductNotFoundException {
        // Step 1:  call to service layer
        List<Product> productList = svc.getAllProduct();

        if (productList == null || productList.size() == 0) {
            throw new ProductNotFoundException("There are no product to be displayed.");
        }

        List<ProductResponseDTO> response = new ArrayList<>();

        // converting models to dtolist
        for (Product p : productList) {
            response.add(mapper.convertToProductResponseDTO(p));
        }

        return response;

    }

    @DeleteMapping("/products/{id}")
    public DeletedProductResponseDTO deleteProduct(@PathVariable("id") Integer id) throws InvalidProductIdException, ProductNotFoundException {

        //Validation
        if (id == null) {
            throw new InvalidProductIdException("Cannot be deleted as the id entered is not valid");
        }

        // Step 1:  call to service layer
        Product product = svc.deleteProduct(id);
        if (product == null) {
            throw new ProductNotFoundException("cannot be deleted as the entered product id " + id + " is not found");
        }

        // Step 2 and 3: Return Map to ResponseDTO
        return mapper.mapeToDeletedProductResponseDTO(product);

    }

    @PutMapping("/products/{id}")
    public ProductResponseDTO updateProduct(@RequestBody UpdateProductRequestDTO dto, @PathVariable("id") Integer id) throws InvalidProductIdException, ProductNotFoundException {

        // Validation
        if (id == null){
            throw new InvalidProductIdException("The provided id in your request is incorrect");
        }

        // Step 1: Call to service layer
        Product productUpdate = svc.updateProduct(id, dto.getTitle(),
                dto.getDescription(), dto.getPrice(), dto.getImage(), dto.getCategory());

        if (productUpdate == null){
            throw new ProductNotFoundException("The product you are searching is not available");
        }

        // S3. convert this to DTO and return.
        return mapper.convertToProductResponseDTO(productUpdate);
    }

//    @GetMapping("products/categories")
//    public List<String> getAllCategories(){
//
//        List<Category> categoryList = categoryService.getAllCategories();
//
//        List<String> response = new ArrayList<>();
//
//        // converting models to dtolist
//        for (Category c : categoryList) {
//            response.add(c.getTitle());
//        }
//
//        return response;
//    }

//    @GetMapping("/products/category/{categoryName}")
//    public List<ProductResponseDTO> getProductByCategory(@PathVariable("categoryName") String categoryName){
//
//        List<Product> prodCatList = categoryService.getProductByCategory(categoryName);
//
//        List<ProductResponseDTO> response = new ArrayList<>();
//
//        // converting models to dtolist
//        for (Product p : prodCatList) {
//            response.add(mapper.convertToProductResponseDTO(p));
//        }
//
//        return response;
//    }

    @GetMapping("/products")
    public List<ProductResponseDTO> limitProductResults(@RequestParam(required = false) Integer limit) throws ProductNotFoundException {

        if (limit == null) {
            return getAllProduct();
        } else {
            // Implementation to get limited products
            List<Product> productList = svc.limitProductResults(limit);

            List<ProductResponseDTO> response = new ArrayList<>();

            // converting models to dtolist
            for (Product p : productList) {
                response.add(mapper.convertToProductResponseDTO(p));
            }

            return response;
        }
    }
}


