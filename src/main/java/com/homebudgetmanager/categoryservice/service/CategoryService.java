package com.homebudgetmanager.categoryservice.service;

import com.homebudgetmanager.categoryservice.dao.Category;
import com.homebudgetmanager.categoryservice.dto.ExpenseDTO;
import com.homebudgetmanager.categoryservice.dto.IncomeDTO;
import com.homebudgetmanager.categoryservice.dto.PlannedExpenseDTO;
import com.homebudgetmanager.categoryservice.dto.PlannedIncomeDTO;
import com.homebudgetmanager.categoryservice.enums.Month;
import com.homebudgetmanager.categoryservice.enums.Type;
import com.homebudgetmanager.categoryservice.interfaces.ICategoryService;
import com.homebudgetmanager.categoryservice.proxy.ExpensesServiceProxy;
import com.homebudgetmanager.categoryservice.proxy.IncomeServiceProxy;
import com.homebudgetmanager.categoryservice.proxy.PlannedExpenseServiceProxy;
import com.homebudgetmanager.categoryservice.proxy.PlannedIncomeServiceProxy;
import com.homebudgetmanager.categoryservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ExpensesServiceProxy expensesServiceProxy;
    @Autowired
    private IncomeServiceProxy incomeServiceProxy;
    @Autowired
    private PlannedIncomeServiceProxy plannedIncomeServiceProxy;
    @Autowired
    private PlannedExpenseServiceProxy plannedExpenseServiceProxy;

    public void deleteByType(String type){
        List<Category> categoryByTypeList = categoryRepository.findByType(Type.valueOf(type.toUpperCase()));
        for(int i = 0; i < categoryByTypeList.size(); i++){
            categoryRepository.deleteByType(Type.valueOf(type.toUpperCase()));
        }
    }

    public void updateCategory(Long id, Category category) {
        Optional<Category> storedCategory = categoryRepository.findById(id);
        if (storedCategory.isPresent()) {
            storedCategory.get().setName(category.getName());
            categoryRepository.save(storedCategory.get());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no category with provided id.");
        }
    }
    public void addCategory(Category category){
        categoryRepository.save(category);
//        if(category.getType() == Type.valueOf("EXPENSES")) {
//            // Add default expenses
//            expensesServiceProxy.addExpense(new ExpenseDTO(category.getName(), 10.0, "JANUARY", 2021, category.getUserId()));
//            expensesServiceProxy.addExpense(new ExpenseDTO(category.getName(), 20.0, "FEBRUARY", 2021, category.getUserId()));
//            expensesServiceProxy.addExpense(new ExpenseDTO(category.getName(), 30.0, "MARCH", 2021, category.getUserId()));
//            expensesServiceProxy.addExpense(new ExpenseDTO(category.getName(), 40.0, "APRIL", 2021, category.getUserId()));
//            expensesServiceProxy.addExpense(new ExpenseDTO(category.getName(), 50.0, "MAY", 2021, category.getUserId()));
//            expensesServiceProxy.addExpense(new ExpenseDTO(category.getName(), 60.0, "JUNE", 2021, category.getUserId()));
//            expensesServiceProxy.addExpense(new ExpenseDTO(category.getName(), 70.0, "JULY", 2021, category.getUserId()));
//            expensesServiceProxy.addExpense(new ExpenseDTO(category.getName(), 80.0, "AUGUST", 2021, category.getUserId()));
//            expensesServiceProxy.addExpense(new ExpenseDTO(category.getName(), 90.0, "SEPTEMBER", 2021, category.getUserId()));
//            expensesServiceProxy.addExpense(new ExpenseDTO(category.getName(), 100.0, "OCTOBER", 2021, category.getUserId()));
//            expensesServiceProxy.addExpense(new ExpenseDTO(category.getName(), 110.0, "NOVEMBER", 2021, category.getUserId()));
//            expensesServiceProxy.addExpense(new ExpenseDTO(category.getName(), 120.0, "DECEMBER", 2021, category.getUserId()));
//            // Add default planned expenses
//            plannedExpenseServiceProxy.addPlannedExpense(new PlannedExpenseDTO(category.getName(), 20.0, Month.JANUARY, 2021, category.getUserId()));
//            plannedExpenseServiceProxy.addPlannedExpense(new PlannedExpenseDTO(category.getName(), 30.0, Month.FEBRUARY, 2021, category.getUserId()));
//            plannedExpenseServiceProxy.addPlannedExpense(new PlannedExpenseDTO(category.getName(), 40.0, Month.MARCH, 2021, category.getUserId()));
//            plannedExpenseServiceProxy.addPlannedExpense(new PlannedExpenseDTO(category.getName(), 50.0, Month.APRIL, 2021, category.getUserId()));
//            plannedExpenseServiceProxy.addPlannedExpense(new PlannedExpenseDTO(category.getName(), 60.0, Month.MAY, 2021, category.getUserId()));
//            plannedExpenseServiceProxy.addPlannedExpense(new PlannedExpenseDTO(category.getName(), 70.0, Month.JUNE, 2021, category.getUserId()));
//            plannedExpenseServiceProxy.addPlannedExpense(new PlannedExpenseDTO(category.getName(), 80.0, Month.JULY, 2021, category.getUserId()));
//            plannedExpenseServiceProxy.addPlannedExpense(new PlannedExpenseDTO(category.getName(), 90.0, Month.AUGUST, 2021, category.getUserId()));
//            plannedExpenseServiceProxy.addPlannedExpense(new PlannedExpenseDTO(category.getName(), 100.0, Month.SEPTEMBER, 2021, category.getUserId()));
//            plannedExpenseServiceProxy.addPlannedExpense(new PlannedExpenseDTO(category.getName(), 110.0, Month.OCTOBER, 2021, category.getUserId()));
//            plannedExpenseServiceProxy.addPlannedExpense(new PlannedExpenseDTO(category.getName(), 120.0, Month.NOVEMBER, 2021, category.getUserId()));
//            plannedExpenseServiceProxy.addPlannedExpense(new PlannedExpenseDTO(category.getName(), 130.0, Month.DECEMBER, 2021, category.getUserId()));
//        } else {
//            // Add default incomes
//            incomeServiceProxy.addIncome(new IncomeDTO(category.getName(), 0.0, "JANUARY", 2021, category.getUserId()));
//            incomeServiceProxy.addIncome(new IncomeDTO(category.getName(), 0.0, "FEBRUARY", 2021, category.getUserId()));
//            incomeServiceProxy.addIncome(new IncomeDTO(category.getName(), 0.0, "MARCH", 2021, category.getUserId()));
//            incomeServiceProxy.addIncome(new IncomeDTO(category.getName(), 0.0, "APRIL", 2021, category.getUserId()));
//            incomeServiceProxy.addIncome(new IncomeDTO(category.getName(), 0.0, "MAY", 2021, category.getUserId()));
//            incomeServiceProxy.addIncome(new IncomeDTO(category.getName(), 0.0, "JUNE", 2021, category.getUserId()));
//            incomeServiceProxy.addIncome(new IncomeDTO(category.getName(), 0.0, "JULY", 2021, category.getUserId()));
//            incomeServiceProxy.addIncome(new IncomeDTO(category.getName(), 0.0, "AUGUST", 2021, category.getUserId()));
//            incomeServiceProxy.addIncome(new IncomeDTO(category.getName(), 0.0, "SEPTEMBER", 2021, category.getUserId()));
//            incomeServiceProxy.addIncome(new IncomeDTO(category.getName(), 0.0, "OCTOBER", 2021, category.getUserId()));
//            incomeServiceProxy.addIncome(new IncomeDTO(category.getName(), 0.0, "NOVEMBER", 2021, category.getUserId()));
//            incomeServiceProxy.addIncome(new IncomeDTO(category.getName(), 0.0, "DECEMBER", 2021, category.getUserId()));
//            // Add default planned incomes
//            plannedIncomeServiceProxy.addPlannedIncome(new PlannedIncomeDTO(category.getName(), 0.0, Month.JANUARY, 2021, category.getUserId()));
//            plannedIncomeServiceProxy.addPlannedIncome(new PlannedIncomeDTO(category.getName(), 0.0, Month.FEBRUARY, 2021, category.getUserId()));
//            plannedIncomeServiceProxy.addPlannedIncome(new PlannedIncomeDTO(category.getName(), 0.0, Month.MARCH, 2021, category.getUserId()));
//            plannedIncomeServiceProxy.addPlannedIncome(new PlannedIncomeDTO(category.getName(), 0.0, Month.APRIL, 2021, category.getUserId()));
//            plannedIncomeServiceProxy.addPlannedIncome(new PlannedIncomeDTO(category.getName(), 0.0, Month.MAY, 2021, category.getUserId()));
//            plannedIncomeServiceProxy.addPlannedIncome(new PlannedIncomeDTO(category.getName(), 0.0, Month.JUNE, 2021, category.getUserId()));
//            plannedIncomeServiceProxy.addPlannedIncome(new PlannedIncomeDTO(category.getName(), 0.0, Month.JULY, 2021, category.getUserId()));
//            plannedIncomeServiceProxy.addPlannedIncome(new PlannedIncomeDTO(category.getName(), 0.0, Month.AUGUST, 2021, category.getUserId()));
//            plannedIncomeServiceProxy.addPlannedIncome(new PlannedIncomeDTO(category.getName(), 0.0, Month.SEPTEMBER, 2021, category.getUserId()));
//            plannedIncomeServiceProxy.addPlannedIncome(new PlannedIncomeDTO(category.getName(), 0.0, Month.OCTOBER, 2021, category.getUserId()));
//            plannedIncomeServiceProxy.addPlannedIncome(new PlannedIncomeDTO(category.getName(), 0.0, Month.NOVEMBER, 2021, category.getUserId()));
//            plannedIncomeServiceProxy.addPlannedIncome(new PlannedIncomeDTO(category.getName(), 0.0, Month.DECEMBER, 2021, category.getUserId()));
//        }
    }
}
