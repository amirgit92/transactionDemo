package com.course.transactiondemo.dto;

import com.course.transactiondemo.entity.Guid;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BookDto {
    private int id;
    private String name;
    private String serialNumber;
    private List<Guid> authors;
}
