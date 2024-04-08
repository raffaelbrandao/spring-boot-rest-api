package com.raffaelbrandao.demo.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WelcomeControllerTest {
    @Test
    public void givenCall_whenWelcome_thenTitle(){
        //given
        WelcomeController welcomeController = new WelcomeController();
        //when
        String result = welcomeController.welcome();
        //then
        Assertions.assertEquals(result, "Welcome Spring Boot REST API demo");
    }
}
