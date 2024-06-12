package com.course.transactiondemo.dto;

import com.course.transactiondemo.entity.Book;
import com.course.transactiondemo.entity.Guid;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GuidDto {
    private int id;
    private String name;
    private String nationalCode;
    private String phoneNumber;
    private String guidNumber;
    private List<Book> books;
    private Guid professor;
    private List<Guid> teacherAssistants;
}
