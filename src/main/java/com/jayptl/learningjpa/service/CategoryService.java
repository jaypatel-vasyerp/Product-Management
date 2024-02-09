package com.jayptl.learningjpa.service;

import java.util.List;

import com.jayptl.learningjpa.model.Category;

public interface CategoryService {

    Category getCategoryById(long id);

    Category addCategory(Category category);

    Category updateCategory(Category category);

    List<Category> getAllCategory();

    String deleteCategoryById(long id);
}
