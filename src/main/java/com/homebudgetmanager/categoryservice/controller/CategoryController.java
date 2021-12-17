package com.homebudgetmanager.categoryservice.controller;

import com.homebudgetmanager.categoryservice.dao.Category;
import com.homebudgetmanager.categoryservice.enums.Type;
import com.homebudgetmanager.categoryservice.interfaces.ICategoryService;
import com.homebudgetmanager.categoryservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/category/")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ICategoryService categoryService;

    //  http://localhost:8100/category/all
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    //  http://localhost:8100/category/id/1
    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryRepository.findById(id);
    }

    //  http://localhost:8100/category/type/income
    @GetMapping("type/{type}")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getCategoryByType(@PathVariable String type) {
        return categoryRepository.findByType(Type.valueOf(type.toUpperCase()));
    }

    //  http://localhost:8100/category/type/income/user-id/2
    @GetMapping("type/{type}/user-id/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getCategoryByTypeAndUserId(@PathVariable String type, @PathVariable Long userId) {
        return categoryRepository.findByTypeAndUserId(Type.valueOf(type.toUpperCase()), userId);
    }

    //  http://localhost:8100/category/update/id/1
    @PutMapping("update/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCategory(@PathVariable(name="id") Long id, @RequestBody Category category){
        categoryService.updateCategory(id, category);
    }

    //  http://localhost:8100/category
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
    }

    //  http://localhost:8100/category/delete/id/1
    @DeleteMapping("delete/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoryById(@PathVariable Long id){
        categoryRepository.deleteById(id);
    }

    //  http://localhost:8100/category/delete/type/income
    @DeleteMapping("delete/type/{type}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoryByType(@PathVariable String type){
        categoryService.deleteByType(type);
    }
}