package com.course.transactiondemo.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(CustomException.class)
    public static String errorMessage(String ex) {
        return ex;
    }
}
