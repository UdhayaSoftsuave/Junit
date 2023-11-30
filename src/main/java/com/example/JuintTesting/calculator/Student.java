package com.example.JuintTesting.calculator;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;

@NamedNativeQuery(name = "Student.findStudent",
	query = "SELECT s.name as name, s.school_name as schoolName FROM studentdemo.student as s",
	resultSetMapping = "Map.findStudent")
@SqlResultSetMapping(name = "Map.findStudent",
	classes = @ConstructorResult(targetClass = StudentResponseDto.class,
	columns = {
			@ColumnResult(name = "name"),
			@ColumnResult(name = "schoolName")
}))

@Entity
public class Student {

	@Id
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
