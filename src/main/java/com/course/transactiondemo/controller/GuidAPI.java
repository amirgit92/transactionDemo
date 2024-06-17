package com.course.transactiondemo.controller;

import com.course.transactiondemo.dto.GuidDto;
import com.course.transactiondemo.dto.Result;
import com.course.transactiondemo.service.GuidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/guids")
@RestController
public class GuidAPI {

    private final GuidService service;

    public GuidAPI(GuidService service) {
        this.service = service;
    }

    @PostMapping("insert")
    public ResponseEntity<Result> insert(@RequestBody GuidDto guidDto) {
        return ResponseEntity.ok(new Result(200, service.insert(guidDto)));
    }

    @PutMapping("update")
    public ResponseEntity<Result> update(@RequestBody GuidDto guidDto) {
        return ResponseEntity.ok(new Result(200, service.update(guidDto)));
    }

    @DeleteMapping("remove")
    public ResponseEntity<Result> remover(@RequestBody GuidDto guidDto) {
        service.remove(guidDto);
        return ResponseEntity.ok(new Result(200, "removed successfully"));
    }

    @GetMapping("get-by-id/{id}")
    public ResponseEntity<Result> getById(@PathVariable int id) {
        return ResponseEntity.ok(new Result(200, service.getById(id)));
    }
}
