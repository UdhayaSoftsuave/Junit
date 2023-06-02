package com.example.gradleTest.gradleTest.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {
    private String id;
    private String name;
    private int age;
    private int std;

    public Student() {
    }

    public Student(String id, String name, int age, int std) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.std = std;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStd() {
        return std;
    }

    public void setStd(int std) {
        this.std = std;
    }
}
