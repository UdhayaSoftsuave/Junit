package com.example.JuintTesting.entity;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public record Student(@Id String id, String name, int age, int std) { }
