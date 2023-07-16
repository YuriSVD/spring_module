package com.example.spring_module.controllers;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> blankNameException(ConstraintViolationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.valueOf(500));
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> notValidId(RuntimeException e) {
        return new ResponseEntity<>("id cannot be a negative value or zero", HttpStatus.BAD_REQUEST);
    }
}