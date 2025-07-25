package com.example.lab7.Service;

import com.example.lab7.Model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {
    ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void addCourses(Course course){
        courses.add(course);
    }
    public boolean upCouress(String id , Course course){
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(id)){
                courses.set(i , course);
                    return true;
            }
        }return false;
    }
    public boolean deleteCouress(String id ){
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(id)){
                courses.remove(i);
                return true;
            }
        } return false;
    }
    public Course getById(String id) {
        for (Course c : courses) {
            if (c.getId().equals(id)) {
                return c;
            }
        }return null;
    }
    public int count() {
        return courses.size();
    }

    public ArrayList<Course> getByTeacher(String teacherId) {
        ArrayList<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getTeacherId().equalsIgnoreCase(teacherId)) {
                result.add(c);
            }
        }
        return result;
    }

    public ArrayList<Course> getByCapacity(int capacity) {
        ArrayList<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getCapacity() > capacity) {
                result.add(c);
            }
        }
        return result;
    }
}

