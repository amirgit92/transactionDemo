package com.course.transactiondemo.controller;

import com.course.transactiondemo.entity.Student;
import com.course.transactiondemo.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentAPI {
    private final StudentService service;

    public StudentAPI(StudentService service) {
        this.service = service;
    }

    @PostMapping("insert")
    public Student insert(@RequestBody Student student) {
        return service.insert(student);
//        return service.semiInsert(student);
    }
}
