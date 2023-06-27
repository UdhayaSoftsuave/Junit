package com.example.JuintTesting.Entity;

public class Student {

    private Long id;
    private String name;
    private String schoolName;
    private Integer age;
    private Integer std;

    public Student() {
    }


    public Student(Long id, String name, String schoolName, Integer age, Integer std) {
        this.id = id;
        this.name = name;
        this.schoolName = schoolName;
        this.age = age;
        this.std = std;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStd() {
        return std;
    }

    public void setStd(Integer std) {
        this.std = std;
    }
}
