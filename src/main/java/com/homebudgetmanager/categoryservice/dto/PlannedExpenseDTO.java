package com.homebudgetmanager.categoryservice.dto;

import com.homebudgetmanager.categoryservice.enums.Month;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlannedExpenseDTO {
    private String category;
    private Double amount;
    private Month month;
    private int year;
    private Long userId;
}
