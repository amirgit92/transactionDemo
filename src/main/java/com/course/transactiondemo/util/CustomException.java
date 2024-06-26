package com.course.transactiondemo.util;


import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomException extends RuntimeException {

    public CustomException() {

    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }
}
