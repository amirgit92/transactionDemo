package com.course.transactiondemo.service;

import com.course.transactiondemo.entity.Student;
import com.course.transactiondemo.repository.student.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    private final IStudentRepository repository;

    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Student insert(Student student) {
         Student newStudent = repository.save(student);
         throw new RuntimeException("");
    }

}
