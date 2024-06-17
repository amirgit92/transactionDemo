package com.course.transactiondemo.service;

import com.course.transactiondemo.dto.BookDto;
import com.course.transactiondemo.entity.Book;
import com.course.transactiondemo.repository.IBookRepository;
import org.springframework.beans.BeanUtils;
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

    public Optional<BookDto> insert(BookDto bookDto) {
        throw new IllegalAccessError();
//        Book book = new Book();
//        BeanUtils.copyProperties(bookDto, book);
//        BeanUtils.copyProperties(repository.save(book), bookDto);
//        return Optional.ofNullable(bookDto);
    }

    public BookDto update(BookDto bookDto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        BeanUtils.copyProperties(repository.save(book), bookDto);
        return bookDto;
    }

    public BookDto getById(int id) {
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(repository.findById(id), bookDto);
        return bookDto;
    }

    public void remove(BookDto bookDto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        repository.delete(book);
    }
}
