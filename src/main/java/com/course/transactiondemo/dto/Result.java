package com.course.transactiondemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.net.http.HttpHeaders;

@Setter
@Getter
@AllArgsConstructor
public class Result {

    private int statusCode;
    private Object body;
    private HttpHeaders httpHeaders;

    public Result(int statusCode, Object body){
        this.body = body;
        this.statusCode = statusCode;
    }
}
