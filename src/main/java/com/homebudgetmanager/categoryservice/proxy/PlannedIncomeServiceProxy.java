package com.homebudgetmanager.categoryservice.proxy;

import com.homebudgetmanager.categoryservice.dto.PlannedIncomeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("planned-income-service")
public interface PlannedIncomeServiceProxy {
    @PostMapping("/planned-income/add")
    @ResponseStatus(HttpStatus.CREATED)
    void addPlannedIncome(@RequestBody PlannedIncomeDTO plannedIncome);
}
