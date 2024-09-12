//package com.scalerproject.psmicroservice.productservice;
//
//import com.scalerproject.psmicroservice.productservice.model.Category;
//import com.scalerproject.psmicroservice.productservice.model.Product;
//import com.scalerproject.psmicroservice.productservice.repository.CategoryRepo;
//import com.scalerproject.psmicroservice.productservice.repository.ProductRepo;
//import com.scalerproject.psmicroservice.productservice.repository.projections.ProductProjection;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class ProductServiceApplicationTests {
//
//    @Autowired
//    private ProductRepo productRepo;
//
//    @Autowired
//    private CategoryRepo categoryRepo;
//
//    @Test
//    @Transactional
//    void testingQueries() {
//        ProductProjection prod = productRepo.getProductByTitle("red hoodie");
//        System.out.println(prod);
//
//        System.out.println("Doing getter...");
//
//        System.out.println(prod.getId());
//        System.out.print(prod.getTitle());
//    }
//
//}
