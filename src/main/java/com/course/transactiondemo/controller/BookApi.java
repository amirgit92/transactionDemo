package com.course.transactiondemo.controller;

import com.course.transactiondemo.dto.BookDto;
import com.course.transactiondemo.dto.Result;
import com.course.transactiondemo.service.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequestMapping("/books")
@RestController
public class BookApi {

    private final BookService service;

    public BookApi(BookService service) {
        this.service = service;
    }

    @PostMapping("insert")
    public ResponseEntity<Result> insert(@RequestBody BookDto bookDto){

            return ResponseEntity.ok(service.insert(bookDto).map(result -> new Result(200,result))
                    .orElseThrow(IllegalAccessError::new));
    }

    @PostMapping("update")
    public ResponseEntity<Result> update(@RequestBody BookDto bookDto){
         return ResponseEntity.ok(new Result(200,service.update(bookDto)));
    }

    public ResponseEntity<Result> delete(@RequestBody BookDto bookDto){
        service.remove(bookDto);
        return ResponseEntity.ok(new Result(200,"successfully removed"));
    }

    public ResponseEntity<Result> getById(@PathVariable int id){
        service.getById(id);
        return null;
    }
}
