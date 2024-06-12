package com.course.transactiondemo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDto {
    private int id;
    private String studentNumber;
    private String name;
    private String nationalCode;
    private String phoneNumber;
}
