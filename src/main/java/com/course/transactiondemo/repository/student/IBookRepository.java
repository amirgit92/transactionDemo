package com.course.transactiondemo.repository.student;

import com.course.transactiondemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
