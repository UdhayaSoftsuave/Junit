package com.example.gradleTest.gradleTest.repository;

import com.example.gradleTest.gradleTest.entity.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface StudentRepository extends ReactiveMongoRepository<Student , String> {
    Mono<Student> findByName(String name);
}

