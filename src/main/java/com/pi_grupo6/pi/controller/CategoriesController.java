package com.pi_grupo6.pi.controller;

import com.pi_grupo6.pi.model.dto.CategoriesDTO;
import com.pi_grupo6.pi.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoryService;

    @GetMapping("/allCategories")
    public Set<CategoriesDTO> allTheCategories(){
        return categoryService.allCategories();
    }

    @PostMapping("/addCategory")
    public ResponseEntity<String> addACategory(@RequestBody CategoriesDTO categoryDTO){
        categoryService.addCategory(categoryDTO);
        return ResponseEntity.ok(HttpStatus.OK + " Categoria agregada con éxito");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteACategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(HttpStatus.OK + " Categoria eliminada con éxito");
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateACategory(@RequestBody CategoriesDTO categoryDTO) {
        categoryService.updateCategory(categoryDTO);
        return ResponseEntity.ok(HttpStatus.OK + " Categoria actualizada con éxito");
    }
}
