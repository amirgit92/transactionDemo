package com.course.transactiondemo.service;

import com.course.transactiondemo.dto.GuidDto;
import com.course.transactiondemo.entity.Guid;
import com.course.transactiondemo.repository.IGuidRepository;
import org.springframework.beans.BeanUtils;
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
        Guid guid = new Guid();
        BeanUtils.copyProperties(guidDto, guid);
        BeanUtils.copyProperties(repository.save(guid), guidDto);
        return guidDto;
    }

    public GuidDto update(GuidDto guidDto) {
        Guid guid = new Guid();
        BeanUtils.copyProperties(guidDto, guid);
        BeanUtils.copyProperties(repository.save(guid), guidDto);
        return guidDto;
    }

    public GuidDto getById(int id) {
        GuidDto guidDto = new GuidDto();
        BeanUtils.copyProperties(repository.findById(id), guidDto);
        return guidDto;
    }

    public void remove(GuidDto guidDto) {
        Guid guid = new Guid();
        BeanUtils.copyProperties(guidDto, guid);
        repository.delete(guid);
    }
}
