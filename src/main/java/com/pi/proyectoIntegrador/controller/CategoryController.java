package com.pi.proyectoIntegrador.controller;

import com.pi.proyectoIntegrador.entity.Category;
import com.pi.proyectoIntegrador.exception.ResourceNotFoundException;
import com.pi.proyectoIntegrador.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public List<Category> listarPacientes() {
        return categoryService.findAll();
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategory(@PathVariable Long id) {
        if (categoryService.findById(id).isPresent()) {
            return ResponseEntity.ok(categoryService.findById(id).get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws ResourceNotFoundException {
        categoryService.delete(id);
        return ResponseEntity.ok("Category deleted");
    }

}