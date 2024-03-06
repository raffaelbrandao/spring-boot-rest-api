package com.raffaelbrandao.demo.data;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorResponse {
    private Date date = new Date();
    private String status = "error";
    private int statusCode = 400;
    private String messageError;
}
