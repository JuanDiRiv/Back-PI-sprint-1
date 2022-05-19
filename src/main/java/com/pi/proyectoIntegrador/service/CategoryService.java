package com.pi.proyectoIntegrador.service;

import com.pi.proyectoIntegrador.entity.Category;
import com.pi.proyectoIntegrador.exception.ResourceNotFoundException;
import com.pi.proyectoIntegrador.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category save(Category category) {
        return repository.save(category);
    }

    public Category update(Category category) {
        if(findById(category.getId()).isPresent())
            return repository.save(category);
        else
            return null;
    }

    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) throws ResourceNotFoundException{
        Optional<Category> categoryFound=findById(id);
        if(categoryFound.isPresent())
            repository.deleteById(id);
        else{
            throw new ResourceNotFoundException("the category with the id= "+id+". doesn´t exist");
        }
    }
}
