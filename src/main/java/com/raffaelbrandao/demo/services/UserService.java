package com.raffaelbrandao.demo.services;

import com.raffaelbrandao.demo.models.User;
import com.raffaelbrandao.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;

    public List<User> findAll(){
        return null;
    }

    public User findByUsername(String username) {
        return null;
    }

    public void save(User user) {
    }

    public User update(User user) {
        return null;
    }

    public void delete(Long id) {
    }
}
