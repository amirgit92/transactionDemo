package com.course.transactiondemo.service;

import com.course.transactiondemo.dto.BookDto;
import com.course.transactiondemo.entity.Book;
import com.course.transactiondemo.repository.IBookRepository;
import com.course.transactiondemo.util.Convert;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    //todo add exception handling
    //todo use MapStruct library for converting instead of BeanUtils(performance issues)
    private final IBookRepository repository;

    public BookService(IBookRepository repository) {
        this.repository = repository;
    }

    public BookDto insert(BookDto bookDto) {

        return Convert.convertObject(repository.save(Convert.convertObject(bookDto,Book.class)),BookDto.class);
    }

    public BookDto update(BookDto bookDto) {
        return Convert.convertObject(
                repository.save(
                        Convert.convertObject(bookDto, Book.class)), BookDto.class);

    }

    public BookDto getById(int id) {
        return Convert.convertObject(repository.findById(id).get(), BookDto.class);
    }

    public void remove(BookDto bookDto) {
        repository.delete(Convert.convertObject(bookDto, Book.class));
    }
}
