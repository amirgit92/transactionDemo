package com.course.transactiondemo.entity;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
public class Guid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String guidNumber;
    @ManyToMany
    @JoinTable(name = "Author_Guid",
            joinColumns = @JoinColumn(name = "AuthorId"),
            inverseJoinColumns = @JoinColumn(name = "BookId"))
    private List<Book> books;

    @ManyToOne()
    @JoinColumn(name = "professorId")
    private Guid professor;

    @OneToMany(mappedBy = "professor")
    private List<Guid> teacherAssistants;
}
