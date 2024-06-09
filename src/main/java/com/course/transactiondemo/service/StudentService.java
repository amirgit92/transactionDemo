package com.course.transactiondemo.service;

import com.course.transactiondemo.entity.Student;
import com.course.transactiondemo.repository.student.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    private final IStudentRepository repository;

    private final AddressService addressService;

    public StudentService(IStudentRepository repository,
                          AddressService addressService) {
        this.repository = repository;
        this.addressService = addressService;
    }

    @Transactional
    public Student insert(Student student) {
         Student newStudent = repository.save(student);
         throw new RuntimeException("");
    }

    public Student semiInsert(Student student){
        addressService.insert(student.getAddress());
        return repository.save(student);
    }

}
