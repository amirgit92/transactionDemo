package com.course.transactiondemo.service;

import com.course.transactiondemo.dto.StudentDto;
import com.course.transactiondemo.entity.Student;
import com.course.transactiondemo.repository.IStudentRepository;
import it.avutils.jmapper.JMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        return entityToDto(repository.save(dtoToEntity(studentDto)));
    }

    public StudentDto update(StudentDto studentDto) {
        return entityToDto(repository.save(dtoToEntity(studentDto)));
    }

    public void remove(StudentDto studentDto){
        repository.delete(dtoToEntity(studentDto));
    }

    public StudentDto getById(int id){
        Optional<Student> student =  repository.findById(id);
        if (student.isPresent()){
            return entityToDto(student.get());
        }
        return new StudentDto();
    }

    private StudentDto entityToDto(Student student) {
        JMapper<StudentDto, Student> jMapper = new JMapper<>(StudentDto.class, Student.class);
        return jMapper.getDestination(student);
    }

    private Student dtoToEntity(StudentDto studentDto) {
        JMapper<Student, StudentDto> jMapper = new JMapper<>(Student.class, StudentDto.class);
        return jMapper.getDestination(studentDto);
    }

}
