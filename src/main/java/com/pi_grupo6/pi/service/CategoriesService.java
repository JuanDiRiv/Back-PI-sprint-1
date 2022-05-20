package com.pi_grupo6.pi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pi_grupo6.pi.model.entities.Categories;
import com.pi_grupo6.pi.model.dto.CategoriesDTO;
import com.pi_grupo6.pi.repository.ICategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoriesService implements ICategoriesService{

    @Autowired
    ICategoriesRepository categoriesRepository;

    @Autowired
    ObjectMapper mapper;

    //realizo un metodo privado para guardar y reutilizar
    private void saveCategory(CategoriesDTO categoryDTO){
        Categories category = mapper.convertValue(categoryDTO, Categories.class);
        categoriesRepository.save(category);
    }
    @Override
    public void addCategory(CategoriesDTO categoryDTO) {
        saveCategory(categoryDTO);

    }

    @Override
    public Set<CategoriesDTO> allCategories() {
        List<Categories> categories = categoriesRepository.findAll();
        Set<CategoriesDTO> categoriesDTO = new HashSet<>();

        for(Categories category: categories){
            categoriesDTO.add(mapper.convertValue(category, CategoriesDTO.class));
        }

        return categoriesDTO;
    }

    @Override
    public void updateCategory(CategoriesDTO categoryDTO) {
        saveCategory(categoryDTO);
    }

    @Override
    public void deleteCategory(Long id) {

        categoriesRepository.deleteById(id);

    }
}
