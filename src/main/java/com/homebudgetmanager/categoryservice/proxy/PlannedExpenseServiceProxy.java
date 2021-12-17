package com.homebudgetmanager.categoryservice.proxy;

import com.homebudgetmanager.categoryservice.dto.PlannedExpenseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("planned-expenses-service")
public interface PlannedExpenseServiceProxy {
    @PostMapping("/planned-expense/add")
    @ResponseStatus(HttpStatus.CREATED)
    void addPlannedExpense(@RequestBody PlannedExpenseDTO plannedExpense);
}