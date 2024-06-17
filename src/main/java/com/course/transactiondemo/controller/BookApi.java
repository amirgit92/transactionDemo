package com.course.transactiondemo.controller;

import com.course.transactiondemo.dto.BookDto;
import com.course.transactiondemo.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/books")
@RestController
public class BookApi {

    private final BookService service;

    public BookApi(BookService service) {
        this.service = service;
    }

    @PostMapping("insert")
    public BookDto insert(@RequestBody BookDto bookDto){
        return service.insert(bookDto);
    }

    @PostMapping("update")
    public BookDto update(@RequestBody BookDto bookDto){
        return service.update(bookDto);
    }
}
