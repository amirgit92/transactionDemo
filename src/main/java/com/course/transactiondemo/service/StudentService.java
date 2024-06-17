package com.course.transactiondemo.service;

import com.course.transactiondemo.dto.StudentDto;
import com.course.transactiondemo.entity.Student;
import com.course.transactiondemo.repository.IStudentRepository;
import com.course.transactiondemo.util.Convert;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    //todo add exception handling
    //todo use MapStruct library for converting instead of BeanUtils(performance issues)
    //todo read about optionals and use it
    private final IStudentRepository repository;

    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    public StudentDto insert(StudentDto studentDto) {
        return Convert.convertObject(repository.save(Convert.convertObject(studentDto, Student.class)), StudentDto.class);
    }

    public StudentDto update(StudentDto studentDto) {
        return Convert.convertObject(repository.save(Convert.convertObject(studentDto, Student.class)), StudentDto.class);
    }

    public void remove(StudentDto studentDto) {
        repository.delete(Convert.convertObject(studentDto, Student.class));
    }

    public StudentDto getById(int id) {
        return Convert.convertObject(repository.findById(id).get(), StudentDto.class);
    }

//    private StudentDto entityToDto(Student student) {
//        JMapper<StudentDto, Student> jMapper = new JMapper<>(StudentDto.class, Student.class);
//        return jMapper.getDestination(student);
//    }
//
//    private Student dtoToEntity(StudentDto studentDto) {
//        JMapper<Student, StudentDto> jMapper = new JMapper<>(Student.class, StudentDto.class);
//        return jMapper.getDestination(studentDto);
//    }

}
