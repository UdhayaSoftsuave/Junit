package com.example.JuintTesting.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StudentTest {

    StudentService studentService = Mockito.mock(StudentService.class);

    Student student = new Student(studentService);
    @Test
    @DisplayName("testAverage")
    void testAverage(){
        Mockito.when(studentService.getMarks()).thenReturn(500);
        Mockito.when(studentService.getTotalMembers()).thenReturn(10);
        Assertions.assertEquals(50 , student.getaverage());
    }
}
