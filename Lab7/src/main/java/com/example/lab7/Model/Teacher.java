package com.example.lab7.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    @NotEmpty(message = " id must not be empty")
    private String id;

    @NotEmpty(message = "Name must not be empty")
    @Size(min = 2, message = "Name must be at least 2 characters")
    private String name;

    @NotEmpty(message = "Subject must not be empty")
    @Size(min = 2,message = "Subject must be at least 2 characters")
    private String subject;

}
