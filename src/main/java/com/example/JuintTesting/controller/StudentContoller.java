package com.example.JuintTesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JuintTesting.calculator.Student;
import com.example.JuintTesting.calculator.StudentResponseDto;
import com.example.JuintTesting.repository.StudentRepository;

@RestController
public class StudentContoller {
	
	@Autowired
	private StudentRepository repository;
	
	@PostMapping(value = "/save")
	public Student postMethodName(@RequestBody Student entity) {
		return repository.save(entity);
	}
	
	@GetMapping(value = "/getStudent")
	public List<Student> getStudents() {
		return repository.findAll();
	}
	
	@GetMapping(value = "/get")
	public List<StudentResponseDto> getStudent() {
		return repository.findStudent();
	}
	
}
