package com.example.lab7.Controller;

import com.example.lab7.Api.Api;
import com.example.lab7.Model.Teacher;
import com.example.lab7.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity<?> getTeachers(){
        ArrayList<Teacher>teachers=teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@Valid @RequestBody Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new Api("success"));
    }
    @PutMapping("/up/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable String id, @Valid @RequestBody Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api("fail"));
        }

        boolean isUpdated = teacherService.updateTeacher(id, teacher);
        if(isUpdated){
            return ResponseEntity.status(200).body(new Api("success"));
        }
        return ResponseEntity.status(400).body(new Api("fail"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable String id){
        boolean isDeleted = teacherService.deleteTeacher(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new Api("deleted"));
        }
        return ResponseEntity.status(400).body(new Api("not found"));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable String id){
        Teacher teacher = teacherService.getTeacherById(id);
        if(teacher != null){
            return ResponseEntity.status(200).body(teacher);
        }
        return ResponseEntity.status(404).body(new Api("not found"));
    }
    @GetMapping("/count")
    public ResponseEntity<?> getTeacherCount(){
        int count = teacherService.getCount();
        return ResponseEntity.status(200).body("Total teachers: " + count);
    }
    @GetMapping("/subject/{subject}")
    public ResponseEntity<?> getTeachersBySubject(@PathVariable String subject){
        ArrayList<Teacher> teachers = teacherService.getBySubject(subject);
        return ResponseEntity.status(200).body(teachers);
    }

//    @PostMapping("/test")
//    public String test(){     تيست بوست مان
//        return "POST to teacher working!";
//    }
}