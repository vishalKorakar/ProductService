//package com.scalerproject.psmicroservice.productservice.service;
//
//import com.scalerproject.psmicroservice.productservice.builder.ProductMapper;
//import com.scalerproject.psmicroservice.productservice.DTO.FakeStoreProductDTO;
//import com.scalerproject.psmicroservice.productservice.model.Category;
//import com.scalerproject.psmicroservice.productservice.model.Product;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Service // that this is a special class
//public class FakeStoreService implements ProductService {
//
//    private RestTemplate restTemplate;
//    private ProductMapper mapper;
////
//    public FakeStoreService(RestTemplate restTemplate, ProductMapper mapper) {
//        this.restTemplate = restTemplate;
//        this.mapper = mapper;
//    }
//
//
//    @Override
//    public Product getProductById(Integer id) {
//        //s1. Call the FakeStore API
//        ResponseEntity<FakeStoreProductDTO> response = restTemplate.
//                getForEntity("https://fakestoreapi.com/products/" + id,
//                        FakeStoreProductDTO.class);
//
//        if (response == null || response.getBody() == null) {
//            return null;
//        }
//
//        // S2 Get the Body from response Entity
//        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
//
//        //S3: Finally return the Model
//        return mapper.mapToProduct(fakeStoreProductDTO);
//    }
//
//    @Override
//    public Product createProduct(String title, String description, String category,
//                                 String price, String image) {
//
//        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();
//        requestBody.setTitle(title);
//        requestBody.setDescription(description);
//        requestBody.setPrice(String.valueOf(price));
//        requestBody.setCategory(category);
//
//        // S2. Call FakeStore API
//        FakeStoreProductDTO response = restTemplate.postForObject(
//                "https://fakestoreapi.com/products",
//                requestBody, FakeStoreProductDTO.class);
//
//
//        // S3. Get ProductModel
//        Product productmodel = mapper.mapToProduct(response);
//
//        // S4. Return Product
//        return productmodel;
//    }
//
//    @Override
//    public List<Product> getAllProduct() {
//        List<Product> products = new ArrayList<>();
//        ResponseEntity<FakeStoreProductDTO[]> responseEntity = restTemplate.getForEntity(
//                "https://fakestoreapi.com/products",
//                FakeStoreProductDTO[].class);
//
//        FakeStoreProductDTO[] dtos = responseEntity.getBody();
//        if (dtos == null || dtos.length == 0) {
//            System.out.println("Something went wrong..");
//            return new ArrayList<>();
//        }
//
//
//        // create products
//        for (FakeStoreProductDTO dto : dtos) {
//            Product product = mapper.mapToProduct(dto);
//            products.add(product);
//        }
//
//        return products;
//    }
//
//    public Product deleteProduct(Integer id) {
//
//        // gets the product from the fakestore
//        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity(
//                "https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);
//
//        if (responseEntity.getBody() == null) {
//            return null;
//        }
//
//        // S2 Get the Body from response Entity
//        FakeStoreProductDTO fakeStoreProductDTO = responseEntity.getBody();
//
//        // To delete the product mentioned in by the user
//        restTemplate.delete("https://fakestoreapi.com/products/" + id);
//
//
//        //S3: Finally return the Model
//        return mapper.mapToProduct(fakeStoreProductDTO);
//    }
//
////    @Override
////    public Product updateProduct(String title, String description, String category, String price, String image, Integer id) {
////        FakeStoreProductDTO requestUpdateBody = new FakeStoreProductDTO();
////        requestUpdateBody.setTitle(title);
////        requestUpdateBody.setDescription(description);
////        requestUpdateBody.setPrice(String.valueOf(price));
////        requestUpdateBody.setCategory(category);
////
////
////        // Update the product for the give id in FakeStore
////        restTemplate.put("https://fakestoreapi.com/products/" + id,  requestUpdateBody);
////
////        // calling the fakestore api to get back the response for the update made
////        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(
////                "https://fakestoreapi.com/products/" + id,
////                FakeStoreProductDTO.class);
////
////        // Get the Body from response Entity
////        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
////
////        if (fakeStoreProductDTO == null || response.getBody() == null) {
////            return null;
////        }
////
////        // Get Product Model
////        Product productmodel = mapper.mapToProduct(fakeStoreProductDTO);
////
////        // Return Product
////        return productmodel;
////    }
//
////    @Override
////    public List<Category> getAllCategories() {
////
////        List<Category> categories = new ArrayList<>();
////        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity(
////                "https://fakestoreapi.com/products/categories",
////                String[].class);
////
////        String[] categoryNames  = responseEntity.getBody();
////        if (categoryNames == null || categoryNames.length == 0) {
////            System.out.println("Something went wrong..");
////            return new ArrayList<>();
////        }
////
////
////        // Get all categories
////        for (String categoryName : categoryNames) {
////            Category category = new Category();
////            category.setTitle(categoryName);
////            categories.add(category);
////        }
////
////        return categories;
////    }
//
////    @Override
////    public List<Product> getProductByCategory(String categoryName) {
////
////        List<Product> products = new ArrayList<>();
////
////        ResponseEntity<FakeStoreProductDTO[]> responseEntity = restTemplate.getForEntity(
////                "https://fakestoreapi.com/products/category/" + categoryName,
////                FakeStoreProductDTO[].class);
////
////        FakeStoreProductDTO[] dtos = responseEntity.getBody();
////
////        if (dtos == null || dtos.length == 0) {
////            System.out.println("Something went wrong..");
////            return new ArrayList<>();
////        }
////
////
////        // Get products by Category name
////        for (FakeStoreProductDTO dto : dtos) {
////            Product prod = mapper.mapToProduct(dto);
////            products.add(prod);
////        }
////
////        return products;
////    }
//
//    @Override
//    public List<Product> limitProductResults(int limit) {
//        List<Product> products = new ArrayList<>();
//
//        ResponseEntity<FakeStoreProductDTO[]> responseEntity = restTemplate.getForEntity(
//                "https://fakestoreapi.com/products?limit=" + limit, FakeStoreProductDTO[].class);
//
//        FakeStoreProductDTO[] dtos = responseEntity.getBody();
//
//        if (dtos == null || dtos.length == 0) {
//            System.out.println("Something went wrong..");
//            return new ArrayList<>();
//        }
//
//
//        // Get products by Category name
//        for (FakeStoreProductDTO dto : dtos) {
//            Product prod = mapper.mapToProduct(dto);
//            products.add(prod);
//        }
//
//        return products;
//    }
//
//}