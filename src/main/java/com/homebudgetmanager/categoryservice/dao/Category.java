package com.homebudgetmanager.categoryservice.dao;

import com.homebudgetmanager.categoryservice.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Type type;
    @Column(name="user_id")
    private Long userId;

    public Category(String name, Type type, Long userId) {
        this.name = name;
        this.type = type;
        this.userId = userId;
    }
}
