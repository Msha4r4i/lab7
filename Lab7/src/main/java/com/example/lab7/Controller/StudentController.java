package com.example.lab7.Controller;


import com.example.lab7.Api.Api;
import com.example.lab7.Model.Student;
import com.example.lab7.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> getStudent(){
        ArrayList<Student> students = studentService.getStudents();
        return ResponseEntity.status(200).body(students);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudents(@Valid @RequestBody Student student , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            System.out.println("Validation Error:" + message);  // اختبر بوست مان
            return ResponseEntity.status(400).body(message);
        }
        System.out.println("Syudent added:"+ student); // اختبر بوست مان
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new Api("success"));
    }

    @PutMapping("/up/{id}")
    public ResponseEntity<?> upStudent(@PathVariable String id , @Valid @RequestBody Student student , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api("fail"));
        }
        boolean isUpdate= studentService.upsStudent(id , student);
        if (isUpdate){
            return ResponseEntity.status(200).body(new Api("success"));
        }return ResponseEntity.status(400).body(new Api("fail"));
    }

    // اختبر بوست مان
    @PostMapping("/test")
    public String testPost() {
        return "POST success";
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id){
        boolean isDeleted = studentService.deleteStudent(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new Api("deleted"));
        }
        return ResponseEntity.status(400).body(new Api("not found"));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudentId(@PathVariable String id){
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.status(200).body(student);
        }
        return ResponseEntity.status(404).body(new Api("student not found"));
    }
    @GetMapping("/count")
    public ResponseEntity<?> getStudentCount(){
        int count = studentService.getStudents().size();
        return ResponseEntity.status(200).body("Total students: " + count);
    }

    @GetMapping("/top")
    public ResponseEntity<?> getTopStudents(){
        ArrayList<Student> top = studentService.getTopStudents();
        return ResponseEntity.status(200).body(top);
    }
}
