package com.raffaelbrandao.demo.handler;

import com.raffaelbrandao.demo.data.ErrorResponse;
import com.raffaelbrandao.demo.exceptions.BusinessException;
import jakarta.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.UndeclaredThrowableException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Resource private MessageSource messageSource;
    private HttpHeaders httpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    };
    private ErrorResponse errorResponse(String message, HttpStatus httpStatus){
        ErrorResponse error = new ErrorResponse();
        error.setStatus("error");
        error.setStatusCode(httpStatus.value());
        error.setMessageError(message);

        return error;
    }
    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleGeneral(Exception e, WebRequest request){
        if(e.getClass().isAssignableFrom(UndeclaredThrowableException.class)){
            UndeclaredThrowableException exception = (UndeclaredThrowableException) e;

            return handleBusinessException((BusinessException) exception.getUndeclaredThrowable(), request);
        } else {
            String message = messageSource.getMessage("error.server", new Object[]{e.getMessage()}, null);
            ErrorResponse error = errorResponse(message, HttpStatus.INTERNAL_SERVER_ERROR);

            return handleExceptionInternal(e, error, httpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }

    private ResponseEntity<Object> handleBusinessException(BusinessException e, WebRequest request) {
        ErrorResponse error = errorResponse(e.getMessage(), HttpStatus.CONFLICT);
        return handleExceptionInternal(e, error, httpHeaders(), HttpStatus.CONFLICT, request);
    }
}
