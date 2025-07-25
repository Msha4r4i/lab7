package com.example.lab7.Controller;

import com.example.lab7.Api.Api;
import com.example.lab7.Model.Course;
import com.example.lab7.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getCourse(){
        ArrayList<Course> courses = courseService.getCourses();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCoures(@Valid @RequestBody Course course , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        courseService.addCourses(course);
        return ResponseEntity.status(200).body(new Api("success"));
    }
    @PutMapping("/up/{id}")
    public ResponseEntity<?> upCoures(@PathVariable String id , @Valid @RequestBody Course course , Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api("fail"));
        }
        boolean isUpdet = courseService.upCouress(id , course);
        if (isUpdet){
            return ResponseEntity.status(200).body(new Api("success"));
        }
        return ResponseEntity.status(400).body(new Api("not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCoures(@PathVariable String id){
        boolean isDelete = courseService.deleteCouress(id);
        if (isDelete){
            return ResponseEntity.status(200).body(new Api(" deleted"));
        }
        return ResponseEntity.status(400).body(new Api("not found"));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getId(@PathVariable String id) {
        Course course = courseService.getById(id);
        if (course != null) {
            return ResponseEntity.status(200).body(course);
        }
        return ResponseEntity.status(404).body(new Api("Course not found"));
    }

    @GetMapping("/count")
    public ResponseEntity<?> count() {
        int total = courseService.count();
        return ResponseEntity.status(200).body("Total courses:" + total);
    }
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<?> getCoursesByTeacherId(@PathVariable String teacherId) {
        ArrayList<Course> courses = courseService.getByTeacher(teacherId);
        return ResponseEntity.status(200).body(courses);
    }
    @GetMapping("/capacity/{capacity}")
    public ResponseEntity<?> getCoursesByCapacity(@PathVariable int capacity) {
        ArrayList<Course> courses = courseService.getByCapacity(capacity);
        return ResponseEntity.status(200).body(courses);
    }

}
