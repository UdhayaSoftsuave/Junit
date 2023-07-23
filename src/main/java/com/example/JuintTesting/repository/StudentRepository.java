package com.example.JuintTesting.repository;

import com.example.JuintTesting.dto.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends ReactiveMongoRepository<Student,String> {
}
