package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    @NotEmpty(message = " id must be not Empty")
    @Size(min = 2, message = "id must be at least 2 characters long")
    private String id;

    @NotEmpty(message = "name must be not Empty")
    private String name;

    @NotNull(message = " age must be not null")
    @Min(value = 15, message = "Age must be at least 15")
    private int age ;

    @Email(message = "Email must be valid")
    private String email;

    @Min(value = 0, message = "Grade must be at least 0")
    @Max(value = 100,message = "Grade must not exceed 100")
    private int grade;
}
