package com.example.JuintTesting.Mapping;


import com.example.JuintTesting.Entity.Student;
import com.example.JuintTesting.Entity.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel="spring",  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapping {

    Student toEntity(StudentDto studentDto);

    StudentDto toDto(Student student);
}
