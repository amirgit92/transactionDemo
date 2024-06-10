package com.course.transactiondemo.repository.student;

import com.course.transactiondemo.entity.Guid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuidRepository extends JpaRepository<Guid,Integer> {
}
