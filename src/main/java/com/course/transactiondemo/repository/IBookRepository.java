package com.course.transactiondemo.repository;

import com.course.transactiondemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
