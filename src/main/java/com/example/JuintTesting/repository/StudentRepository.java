package com.example.JuintTesting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.JuintTesting.calculator.Student;
import com.example.JuintTesting.calculator.StudentResponseDto;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
    @Query(nativeQuery = true)
	List<StudentResponseDto> findStudent();

}
