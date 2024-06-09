package com.course.transactiondemo.service;

import com.course.transactiondemo.entity.Address;
import com.course.transactiondemo.repository.address.IAddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressService {
    private final IAddressRepository repository;

    public AddressService(IAddressRepository repository) {
        this.repository = repository;
    }

    public Address insert(Address address){
        return repository.save(address);
    }
}
