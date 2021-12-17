package com.homebudgetmanager.categoryservice.proxy;

import com.homebudgetmanager.categoryservice.dto.IncomeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("income-service")
public interface IncomeServiceProxy {
    @PostMapping("/income/add")
    @ResponseStatus(HttpStatus.CREATED)
    void addIncome(@RequestBody IncomeDTO income);
}
