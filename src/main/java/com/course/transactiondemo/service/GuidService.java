package com.course.transactiondemo.service;

import com.course.transactiondemo.dto.GuidDto;
import com.course.transactiondemo.entity.Guid;
import com.course.transactiondemo.repository.IGuidRepository;
import com.course.transactiondemo.util.Convert;
import org.springframework.stereotype.Service;

@Service
public class GuidService {
    //todo add exception handling
    //todo use MapStruct library for converting instead of BeanUtils(performance issues)
    private final IGuidRepository repository;

    public GuidService(IGuidRepository repository) {
        this.repository = repository;
    }

    public GuidDto insert(GuidDto guidDto) {
        return Convert.convertObject(
                repository.save(Convert.convertObject(guidDto, Guid.class)), GuidDto.class);
    }

    public GuidDto update(GuidDto guidDto) {
        return Convert.convertObject(
                repository.save(Convert.convertObject(guidDto, Guid.class)), GuidDto.class);
    }

    public GuidDto getById(int id) {
        return Convert.convertObject(
                repository.findById(id), GuidDto.class);
    }

    public void remove(GuidDto guidDto) {
        repository.delete(Convert.convertObject(guidDto, Guid.class));
    }
}
