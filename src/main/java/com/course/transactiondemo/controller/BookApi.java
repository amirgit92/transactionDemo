package com.course.transactiondemo.controller;

import com.course.transactiondemo.dto.BookDto;
import com.course.transactiondemo.dto.Result;
import com.course.transactiondemo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/books")
@RestController
public class BookApi {

    private final BookService service;

    public BookApi(BookService service) {
        this.service = service;
    }

    @PostMapping("insert")
    public ResponseEntity<Result> insert(@RequestBody BookDto bookDto) {

        return ResponseEntity.ok(new Result(200, service.insert(bookDto)));
    }

    @PostMapping("update")
    public ResponseEntity<Result> update(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(new Result(200, service.update(bookDto)));
    }

    @PostMapping("delete")
    public ResponseEntity<Result> delete(@RequestBody BookDto bookDto) {
        service.remove(bookDto);
        return ResponseEntity.ok(new Result(200, "successfully removed"));
    }

    @GetMapping ("get-by-id/{id}")
    public ResponseEntity<Result> getById(@PathVariable int id) {
        return ResponseEntity.ok(new Result(200, service.getById(id)));
    }
}
