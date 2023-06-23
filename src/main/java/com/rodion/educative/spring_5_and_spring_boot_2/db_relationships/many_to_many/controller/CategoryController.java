package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.controller;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.Category;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> allCategories() {
        return service.allCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable int id) {
        return service.getCategory(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return service.addCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id) {
        service.deleteCategory(id);
    }
}
