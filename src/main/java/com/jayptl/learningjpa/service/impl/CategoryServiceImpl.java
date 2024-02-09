package com.jayptl.learningjpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayptl.learningjpa.exception.EntityNotFoundException;
import com.jayptl.learningjpa.model.Category;
import com.jayptl.learningjpa.repository.CategoryRepository;
import com.jayptl.learningjpa.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " not exists"));
        return category;
    }

    @Override
    public Category addCategory(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            updateCategory(category);
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Category updatedCategory = categoryRepository.findById(category.getId())
                .orElseThrow(() -> new EntityNotFoundException("Category with id " + category.getId() + " not exists"));
        if (category.getCategoryName() != null && category.getCategoryName().isEmpty()) {
            updatedCategory.setCategoryName(category.getCategoryName());
        }

        if (category.getCategoryDescription() != null && !category.getCategoryDescription().isEmpty()) {
            updatedCategory.setCategoryDescription(category.getCategoryDescription());
        }

        return categoryRepository.save(updatedCategory);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public String deleteCategoryById(long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return "Deleted";
        }
        throw new EntityNotFoundException("Category with id " + id + " not exists.");
    }

}
