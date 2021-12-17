package com.homebudgetmanager.categoryservice.proxy;

import com.homebudgetmanager.categoryservice.dto.ExpenseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient("expenses-service")
public interface ExpensesServiceProxy {
    @PostMapping("/expense/add")
    @ResponseStatus(HttpStatus.CREATED)
    void addExpense(@RequestBody ExpenseDTO expense);
}
