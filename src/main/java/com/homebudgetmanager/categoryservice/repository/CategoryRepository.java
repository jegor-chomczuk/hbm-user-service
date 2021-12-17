package com.homebudgetmanager.categoryservice.repository;

import com.homebudgetmanager.categoryservice.dao.Category;
import com.homebudgetmanager.categoryservice.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByType(Type type);
    void deleteByType(Type type);
    List<Category> findByTypeAndUserId(Type type, Long userId);
}
