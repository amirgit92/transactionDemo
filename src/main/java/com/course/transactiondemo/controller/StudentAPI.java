package com.course.transactiondemo.controller;

import com.course.transactiondemo.dto.StudentDto;
import com.course.transactiondemo.entity.Student;
import com.course.transactiondemo.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentAPI {
    private final StudentService service;

    public StudentAPI(StudentService service) {
        this.service = service;
    }

    //todo change return type
    @PostMapping("insert")
    public StudentDto insert(@RequestBody StudentDto studentDto) {
        return service.insert(studentDto);
    }
}
