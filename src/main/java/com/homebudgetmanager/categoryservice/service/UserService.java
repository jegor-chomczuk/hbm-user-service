package com.homebudgetmanager.categoryservice.service;

import com.homebudgetmanager.categoryservice.dao.Category;
import com.homebudgetmanager.categoryservice.dao.User;
import com.homebudgetmanager.categoryservice.enums.Type;
import com.homebudgetmanager.categoryservice.interfaces.IUserService;
import com.homebudgetmanager.categoryservice.repository.CategoryRepository;
import com.homebudgetmanager.categoryservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;

    public void addUser(User user) throws Exception {
        Optional<User> storedUser = userRepository.findByUsername(user.getUsername());
        if (!storedUser.isPresent()) {
            User newUser = new User (user.getUsername(), user.getEmail(), user.getPassword());
            userRepository.save(newUser);
            createDefaultCategories(newUser.getUserId());
        }else {
            throw new Exception("User with given name already exists. Please choose another Username.");
        }
    }

    public void createDefaultCategories(Long userId){
        // EXPENSES CATEGORIES
        categoryService.addCategory(new Category("Debt repayment", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Debt overpayment", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Savings", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Food", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Apartment / house", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Insurance", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Transportation", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Telecommunications", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Healthcare", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Clothing", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Hygiene", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Children", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Education", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Tourism", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Entertainment", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Gifts", Type.EXPENSES, userId));
        categoryService.addCategory(new Category("Other expenses", Type.EXPENSES, userId));
//        categoryService.addCategory(new Category("Other 1", Type.EXPENSES, userId));
//        categoryService.addCategory(new Category("Other 2", Type.EXPENSES, userId));
//        categoryService.addCategory(new Category("Other 3", Type.EXPENSES, userId));
//        categoryService.addCategory(new Category("Other 4", Type.EXPENSES, userId));
//        categoryService.addCategory(new Category("Other 5", Type.EXPENSES, userId));
//        categoryService.addCategory(new Category("Other 6", Type.EXPENSES, userId));

        // INCOME CATEGORIES
        categoryService.addCategory(new Category("Salary", Type.INCOME, userId));
        categoryService.addCategory(new Category("Partner's salary", Type.INCOME, userId));
        categoryService.addCategory(new Category("Bonus", Type.INCOME, userId));
        categoryService.addCategory(new Category("Interest", Type.INCOME, userId));
        categoryService.addCategory(new Category("Dividends", Type.INCOME, userId));
        categoryService.addCategory(new Category("Sales", Type.INCOME, userId));
        categoryService.addCategory(new Category("Tax refund", Type.INCOME, userId));
        categoryService.addCategory(new Category("Bank bonuses", Type.INCOME, userId));
//        categoryService.addCategory(new Category("Other 1", Type.INCOME, userId));
//        categoryService.addCategory(new Category("Other 2", Type.INCOME, userId));
//        categoryService.addCategory(new Category("Other 3", Type.INCOME, userId));
    }
}
