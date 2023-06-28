package com.example.JuintTesting.Entity;

import java.util.Objects;

public class StudentEntity {
    private Long studentId;
    private String fullName;
    private String schoolName;
    private Integer age;
    private Integer std;

    public StudentEntity() {
    }

    public StudentEntity(Long studentId, String fullName, String schoolName, Integer age, Integer std) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.schoolName = schoolName;
        this.age = age;
        this.std = std;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(fullName, that.fullName) && Objects.equals(schoolName, that.schoolName) && Objects.equals(age, that.age) && Objects.equals(std, that.std);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, fullName, schoolName, age, std);
    }
}
