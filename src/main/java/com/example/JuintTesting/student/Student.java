package com.example.JuintTesting.student;

public class Student {

    StudentService studentService;

    public Student(StudentService studentService) {
        this.studentService = studentService;
    }

    public int getaverage(){
        return studentService.getMarks() / studentService.getTotalMembers();
    }
}
