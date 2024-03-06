package com.raffaelbrandao.demo.controllers;

import com.raffaelbrandao.demo.models.UserEntity;
import com.raffaelbrandao.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{username}")
    public UserEntity findUserByUsername(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }

    @PostMapping
    public void saveUser(@RequestBody UserEntity user) {
        userService.save(user);
    }

    @PutMapping
    public UserEntity updateUser(@RequestBody UserEntity user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
