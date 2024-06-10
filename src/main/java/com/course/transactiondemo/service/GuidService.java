package com.course.transactiondemo.service;

import com.course.transactiondemo.entity.Guid;
import com.course.transactiondemo.repository.student.IGuidRepository;
import org.springframework.stereotype.Service;

@Service
public class GuidService {

    private final IGuidRepository repository;

    public GuidService(IGuidRepository repository) {
        this.repository = repository;
    }

    public Guid insert(Guid guid) {
        return repository.save(guid);
    }
}
