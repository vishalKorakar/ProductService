package com.scalerproject.psmicroservice.productservice.service;

import com.scalerproject.psmicroservice.productservice.model.Category;
import com.scalerproject.psmicroservice.productservice.model.Product;
import com.scalerproject.psmicroservice.productservice.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("selfcategoryservice")
public class SelfCategoryService implements CategoryService{

    private CategoryRepo categoryRepo;

    public SelfCategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public List<Product> getProductByCategory(String categoryName) {
        return List.of();
    }

    @Override
    public Category getCategoryByTitle(String title) {
        Category getCategory = categoryRepo.findByTitle(title);
        return getCategory;
    }

    @Override
    public Category addCategory(String title) {
        Category addNewCategory = new Category();

        // for creating new category we are passing the values to the model to create a new row in db.
        addNewCategory.setTitle(title);
        addNewCategory.setCreatedAt(new Date());
        addNewCategory.setLastUpdatedAt(new Date());
        addNewCategory.setIsDeleted(false);

        Category newCategory = categoryRepo.save(addNewCategory);
        return newCategory;
    }

}
