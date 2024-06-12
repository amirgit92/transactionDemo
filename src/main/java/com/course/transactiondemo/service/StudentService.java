package com.course.transactiondemo.service;

import com.course.transactiondemo.dto.StudentDto;
import com.course.transactiondemo.entity.Student;
import com.course.transactiondemo.repository.IStudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    //todo add exception handling
    //todo use MapStruct library for converting instead of BeanUtils(performance issues)
    private final IStudentRepository repository;

    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public StudentDto insert(StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        BeanUtils.copyProperties(repository.save(student),studentDto);
        return studentDto;
    }

}
