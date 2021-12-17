package com.homebudgetmanager.categoryservice.interfaces;

import com.homebudgetmanager.categoryservice.dao.Category;

public interface ICategoryService {
    void updateCategory(Long id, Category category);
    void deleteByType(String type);
    void addCategory(Category category);
}
