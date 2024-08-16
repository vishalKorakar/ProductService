package com.scalerproject.psmicroservice.productservice.controller;


import com.scalerproject.psmicroservice.productservice.DTO.CreateProductRequestDTO;
import com.scalerproject.psmicroservice.productservice.DTO.ProductResponseDTO;
import com.scalerproject.psmicroservice.productservice.DTO.UpdateProductRequest;
import com.scalerproject.psmicroservice.productservice.builder.ProductMapper;
import com.scalerproject.psmicroservice.productservice.exception.InvalidProductIdException;
import com.scalerproject.psmicroservice.productservice.exception.ProductNotFoundException;
import com.scalerproject.psmicroservice.productservice.model.Category;
import com.scalerproject.psmicroservice.productservice.model.Product;
import com.scalerproject.psmicroservice.productservice.service.ProductService;
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
    private ProductMapper mapper;

    public ProductController(ProductService svc, ProductMapper mapper) {
        this.svc = svc;
        this.mapper = mapper;
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
    public ProductResponseDTO getProductByID(@PathVariable("id") long id) throws InvalidProductIdException, ProductNotFoundException {


        if (id == 0) {
            throw new InvalidProductIdException("some message");
        }

        // Step 1:  call to service layer
        Product product = svc.getProductById(id);
        if (product == null) {
            throw new ProductNotFoundException();
        }

        // Step 2: Map to ResponseDTO
        ProductResponseDTO response = mapper.convertToProductResponseDTO(product);

        // Step 3: Return
        return response;
    }

    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProduct() {
        // Step 1:  call to service layer
        List<Product> productList = svc.getAllProduct();

        if (productList == null || productList.size() == 0) {
            return null;
        }

        List<ProductResponseDTO> response = new ArrayList<>();

        // converting models to dtolist
        for (Product p : productList) {
            response.add(mapper.convertToProductResponseDTO(p));
        }

        return response;

    }

    @DeleteMapping("/products/{id}")
    public ProductResponseDTO deleteProduct(@PathVariable("id") long id) throws InvalidProductIdException, ProductNotFoundException {

        //Validation
        if (id == 0) {
            throw new InvalidProductIdException("Cannot be deleted as the id entered is not valid");
        }

        // Step 1:  call to service layer
        Product product = svc.getProductById(id);
        if (product == null) {
            throw new ProductNotFoundException("cannot be deleted as the entered product is not found");
        }

        // Step 2: Map to ResponseDTO
        ProductResponseDTO response = mapper.convertToProductResponseDTO(product);

        // Step 3: Return
        return response;

    }

    @PutMapping("/products/{id}")
    public ProductResponseDTO updateProduct(@RequestBody UpdateProductRequest dto, @PathVariable("id") long id) {

        // Validation

        // Step 1: Call to service layer
        Product productUpdate = svc.updateProduct(dto.getTitle(),
                dto.getDescription(), dto.getCategory(), dto.getPrice(), dto.getImage(), id);

        // S3. convert this to DTO and return.
        return mapper.convertToProductResponseDTO(productUpdate);
    }

    @GetMapping("products/categories")
    public List<String> getAllCategories(){

        List<Category> categoryList = svc.getAllCategories();

        List<String> response = new ArrayList<>();

        // converting models to dtolist
        for (Category c : categoryList) {
            response.add(c.getTitle());
        }

        return response;
    }

    @GetMapping("/products/category/{categoryName}")
    public List<ProductResponseDTO> getProductByCategory(@PathVariable("categoryName") String categoryName){

        List<Product> prodCatList = svc.getProductByCategory(categoryName);

        List<ProductResponseDTO> response = new ArrayList<>();

        // converting models to dtolist
        for (Product p : prodCatList) {
            response.add(mapper.convertToProductResponseDTO(p));
        }

        return response;
    }

    @GetMapping("/products")
    public void limitProductResults(@RequestParam int limitNumber){

        List<Product> productList = svc.limitProductResults(limitNumber);
    }
}
