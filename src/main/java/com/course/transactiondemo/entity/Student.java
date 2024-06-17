package com.course.transactiondemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "STUDENTS")
public class Student extends Person{
    private String studentNumber;
}
