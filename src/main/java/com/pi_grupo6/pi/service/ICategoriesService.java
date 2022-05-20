package com.pi_grupo6.pi.service;

import com.pi_grupo6.pi.model.dto.CategoriesDTO;

import java.util.Set;

public interface ICategoriesService {
    void addCategory(CategoriesDTO categoryDTO);
    Set<CategoriesDTO> allCategories();
    void updateCategory(CategoriesDTO categoryDTO);

    void deleteCategory(Long id);

}
