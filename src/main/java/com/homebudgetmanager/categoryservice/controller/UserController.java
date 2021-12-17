package com.homebudgetmanager.categoryservice.controller;

import com.homebudgetmanager.categoryservice.dao.User;
import com.homebudgetmanager.categoryservice.interfaces.IUserService;
import com.homebudgetmanager.categoryservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IUserService userService;

    // GET Methods
    //  http://localhost:8100/user/all
    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //  http://localhost:8100/user/id/1
    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    //  http://localhost:8100/user/username/User 1
    @GetMapping("username/{username}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    //  http://localhost:8100/user/username/user1/password/password1
    @GetMapping("username/{username}/password/{password}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUserByUsernameAndByPassword(@PathVariable String username, @PathVariable String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    //  DELETE Methods
    //  http://localhost:8100/user/delete/id/1
    @DeleteMapping("delete/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    //  POST Method
    //  http://localhost:8100/user/add
    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) throws Exception {
        userService.addUser(user);
    }
}
