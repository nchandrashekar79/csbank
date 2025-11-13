package com.cs.bank.ExceptionHandler;

import java.net.ResponseCache;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.expression.MapAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GloballExceptionHandler {

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String,String>> handleException(MethodArgumentNotValidException ex ,HttpServletRequest request) {
    
    Map<String,String> errors = new LinkedHashMap<>();
    
    for(var error : ex.getBindingResult().getFieldErrors()) {
        errors.put(error.getField(), error.getDefaultMessage());
    }   

    return new ResponseEntity<>(errors ,org.springframework.http.HttpStatus.BAD_REQUEST);
}
}
