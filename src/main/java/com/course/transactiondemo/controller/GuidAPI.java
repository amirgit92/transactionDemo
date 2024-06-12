package com.course.transactiondemo.controller;

import com.course.transactiondemo.dto.GuidDto;
import com.course.transactiondemo.service.GuidService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/guids")
@RestController
public class GuidAPI {

    private final GuidService service;

    public GuidAPI(GuidService service) {
        this.service = service;
    }

    @PostMapping("insert")
    public GuidDto insert(@RequestBody GuidDto guidDto){
        return service.insert(guidDto);
    }
}
