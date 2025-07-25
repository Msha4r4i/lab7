package com.example.lab7.Service;

import com.example.lab7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents(){
        return students;
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public boolean upsStudent(String id , Student student){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)){
                students.set(i , student);
                return true;
            }
        } return false;
    }
    public boolean deleteStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    public Student getStudentById(String id){
        for(Student student : students){
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }
    public ArrayList<Student> getTopStudents(){
        ArrayList<Student> top = new ArrayList<>();
        for(Student s : students){
            if(s.getGrade() >= 90){
                top.add(s);
            }
        }
        return top;
    }

}
