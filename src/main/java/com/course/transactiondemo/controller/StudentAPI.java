package com.course.transactiondemo.controller;

import com.course.transactiondemo.dto.Result;
import com.course.transactiondemo.dto.StudentDto;
import com.course.transactiondemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentAPI {
    private final StudentService service;

    public StudentAPI(StudentService service) {
        this.service = service;
    }

    @PostMapping("insert")
    public ResponseEntity<Result> insert(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(new Result(200, service.insert(studentDto)));
    }

    @PutMapping("update")
    public ResponseEntity<Result> update(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(new Result(200, service.update(studentDto)));
    }

    @DeleteMapping("delete")
    public ResponseEntity<Result> delete(@RequestBody StudentDto studentDto) {
        service.remove(studentDto);
        return ResponseEntity.ok(new Result(200, "removed successfully"));
    }

    @GetMapping("find-by-id/{id}")
    public ResponseEntity<Result> getById(@PathVariable int id) {
        return ResponseEntity.ok(new Result(200, service.getById(id)));
    }
}
