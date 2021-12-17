package com.homebudgetmanager.categoryservice;

import com.homebudgetmanager.categoryservice.dao.Category;
import com.homebudgetmanager.categoryservice.dao.User;
import com.homebudgetmanager.categoryservice.enums.Type;
import com.homebudgetmanager.categoryservice.repository.CategoryRepository;
import com.homebudgetmanager.categoryservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Data {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    public void populate() {
//        userRepository.save(new User("User 1", "Password 1", "email@domain.com"));

//        // EXPENSES CATEGORIES
//        categoryRepository.save(new Category("Debt repayment", Type.EXPENSES, 1l));
//        categoryRepository.save(new Category("Debt overpayment", Type.EXPENSES, 2l));
//        categoryRepository.save(new Category("Savings", Type.EXPENSES, 1l));
//        categoryRepository.save(new Category("Food", Type.EXPENSES, 2l));
//        categoryRepository.save(new Category("Apartment / house", Type.EXPENSES, 1l));
//        categoryRepository.save(new Category("Insurance", Type.EXPENSES, 2l));
//        categoryRepository.save(new Category("Transportation", Type.EXPENSES, 2l));
//        categoryRepository.save(new Category("Telecommunications", Type.EXPENSES, 1l));
//        categoryRepository.save(new Category("Healthcare", Type.EXPENSES, 2l));
//        categoryRepository.save(new Category("Clothing", Type.EXPENSES, 2l));
//        categoryRepository.save(new Category("Hygiene", Type.EXPENSES, 1l));
//        categoryRepository.save(new Category("Children", Type.EXPENSES, 2l));
//        categoryRepository.save(new Category("Education", Type.EXPENSES, 1l));
//        categoryRepository.save(new Category("Tourism", Type.EXPENSES, 2l));
//        categoryRepository.save(new Category("Entertainment", Type.EXPENSES, 1l));
//        categoryRepository.save(new Category("Gifts", Type.EXPENSES, 2l));
//        categoryRepository.save(new Category("Other expenses", Type.EXPENSES, 1l));
//        categoryRepository.save(new Category("Other 1", Type.EXPENSES, 1l));
//        categoryRepository.save(new Category("Other 2", Type.EXPENSES, 2l));
//        categoryRepository.save(new Category("Other 3", Type.EXPENSES, 1l));
//        categoryRepository.save(new Category("Other 4", Type.EXPENSES, 2l));
//        categoryRepository.save(new Category("Other 5", Type.EXPENSES, 1l));
//        categoryRepository.save(new Category("Other 6", Type.EXPENSES, 2l));
//
//        // INCOME CATEGORIES
//        categoryRepository.save(new Category("Salary", Type.INCOME, 1l));
//        categoryRepository.save(new Category("Partner's salary", Type.INCOME, 2l));
//        categoryRepository.save(new Category("Bonus", Type.INCOME, 1l));
//        categoryRepository.save(new Category("Interest", Type.INCOME, 2l));
//        categoryRepository.save(new Category("Dividends", Type.INCOME, 1l));
//        categoryRepository.save(new Category("Sales", Type.INCOME, 2l));
//        categoryRepository.save(new Category("Tax refund", Type.INCOME, 1l));
//        categoryRepository.save(new Category("Bank bonuses", Type.INCOME, 2l));
//        categoryRepository.save(new Category("Other 1", Type.INCOME, 1l));
//        categoryRepository.save(new Category("Other 2", Type.INCOME, 2l));
//        categoryRepository.save(new Category("Other 3", Type.INCOME, 1l));
    }
}