package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.service;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.Category;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository categoryRepository) {
        this.repo = categoryRepository;
    }

    public List<Category> allCategories() {
        return repo.findAll();
    }

    public Category getCategory(int id) {
        return repo.findById(id).get();
    }

    public Category addCategory(Category category) {
        category.setId(0);
        return repo.save(category);
    }

    public void deleteCategory(int id) {
        repo.deleteById(id);
    }
}
