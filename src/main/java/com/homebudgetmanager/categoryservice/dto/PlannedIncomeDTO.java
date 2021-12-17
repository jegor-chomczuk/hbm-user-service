package com.homebudgetmanager.categoryservice.dto;

import com.homebudgetmanager.categoryservice.enums.Month;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlannedIncomeDTO {
    private String category;
    private Double amount;
    private Month month;
    private int year;
    private Long userId;
}
