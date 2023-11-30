package com.example.JuintTesting.calculator;

public class StudentResponseDto {
    private String name;
    private String schoolName;
	public StudentResponseDto() {
		super();
	}
	public StudentResponseDto(String name, String schoolName) {
		super();
		this.name = name;
		this.schoolName = schoolName;
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
}
