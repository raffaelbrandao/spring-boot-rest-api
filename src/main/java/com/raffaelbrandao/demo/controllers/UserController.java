package com.raffaelbrandao.demo.controllers;

import com.raffaelbrandao.demo.models.User;
import com.raffaelbrandao.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired private UserService userService;
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }
    @GetMapping("/{username}")
    public User findByUsername(@PathVariable("username") String username){
        return userService.findByUsername(username);
    }
    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
