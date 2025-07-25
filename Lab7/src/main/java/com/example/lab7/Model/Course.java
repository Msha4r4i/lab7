package com.example.lab7.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {

    @NotEmpty(message = "Course ID must not be empty")
    private String id;

    @NotEmpty(message = "Course name must not be empty")
    private String name;

    @NotEmpty(message = "Teacher ID must not be empty")
    private String teacherId;

    @Min(value = 1, message = "Capacity must be at least 1")
    private int capacity;
}
