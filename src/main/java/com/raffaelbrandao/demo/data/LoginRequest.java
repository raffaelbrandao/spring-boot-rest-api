package com.raffaelbrandao.demo.data;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
