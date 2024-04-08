package com.raffaelbrandao.demo.controllers;

import com.raffaelbrandao.demo.models.UserEntity;
import com.raffaelbrandao.demo.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;

    @Test
    public void whenFindAllUsers_thenReturnAllUsers() {
        //given
        List<UserEntity> allUsersExpected = new ArrayList<>();
        allUsersExpected.add(new UserEntity(null, "joaosilva", "João Silva", null, null));
        allUsersExpected.add(new UserEntity(null, "mariasantos", "Maria Santos", null, null));
        Mockito.when(userService.findAll()).thenReturn(allUsersExpected);
        //when
        List<UserEntity> allUsers = userController.findAllUsers();
        //then
        Assertions.assertEquals(allUsersExpected, allUsers);
    }
}
