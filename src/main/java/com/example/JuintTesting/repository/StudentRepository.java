package com.example.JuintTesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JuintTesting.calculator.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
}
