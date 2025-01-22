package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("error", ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());

//        ex.getBindingResult().getAllErrors().forEach(error -> {
//            String fieldName;
//            if (error instanceof FieldError) {
//                fieldName = ((FieldError) error).getField();
//            } else {
//                // In case it's a global error or object-level validation
//                fieldName = error.getObjectName();
//            }
//            errorMap.put("error", error.getDefaultMessage());
//        });

        return errorMap;
    }
}
