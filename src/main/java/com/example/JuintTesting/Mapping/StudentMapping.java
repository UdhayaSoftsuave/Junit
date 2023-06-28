package com.example.JuintTesting.Mapping;


import com.example.JuintTesting.Entity.Student;
import com.example.JuintTesting.Entity.StudentDto;
import com.example.JuintTesting.Entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel="spring",  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapping {

    Student toEntity(StudentDto studentDto);

    StudentDto toDto(Student student);

    @Mapping(source = "studentId" , target = "id" )
    @Mapping(source = "fullName" , target = "name")
    Student toEntity(StudentEntity studentEntity);

    @Mapping(source = "studentId" , target = "id" )
    @Mapping(source = "fullName" , target = "name")
    StudentDto toDto(StudentEntity studentEntity);
}
