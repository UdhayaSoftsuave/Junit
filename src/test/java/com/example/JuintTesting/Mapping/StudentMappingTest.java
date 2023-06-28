package com.example.JuintTesting.Mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.JuintTesting.Entity.Student;
import com.example.JuintTesting.Entity.StudentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentMappingTest {

    @Autowired
    private StudentMapping studentMapping;

    @Test
    public void toDtoTest(){
        Student student = new Student(12l,"udhaya","AMD",21,12 );

        StudentDto studentDto = studentMapping.toDto(student);

        assertEquals(new StudentDto(12l,"udhaya","AMD",21,12 ), studentDto);
    }

    @Test
    public void toEntityTest(){
        StudentDto studentDto = new StudentDto(12l,"udhaya","AMD",21,12 );

        Student student = studentMapping.toEntity(studentDto);

        assertEquals(new Student(12l,"udhaya","AMD",21,12 ), student);
    }

}