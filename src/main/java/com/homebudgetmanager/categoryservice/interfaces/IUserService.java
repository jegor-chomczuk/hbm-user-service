package com.homebudgetmanager.categoryservice.interfaces;

import com.homebudgetmanager.categoryservice.dao.User;

public interface IUserService {
    void createDefaultCategories(Long userId);
    void addUser(User user) throws Exception;
}
