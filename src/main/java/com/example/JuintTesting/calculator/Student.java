package com.example.JuintTesting.calculator;


public class Student {

    private Long id ;
    private String name;
    private String schoolName;

    public Student() {
    }

    public Student(Long id, String name, String schoolName) {
        this.id = id;
        this.name = name;
        this.schoolName = schoolName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
