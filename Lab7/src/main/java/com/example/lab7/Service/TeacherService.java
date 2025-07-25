package com.example.lab7.Service;

import com.example.lab7.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getTeachers(){
        return teachers;
    }
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public boolean updateTeacher(String id, Teacher newTeacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                teachers.set(i, newTeacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(String id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public Teacher getTeacherById(String id) {
        for (Teacher t : teachers) {
            if (t.getId().equals(id)) return t;
        }
        return null;
    }

    public int getCount() {
        return teachers.size();
    }

    public ArrayList<Teacher> getBySubject(String subject) {
        ArrayList<Teacher> result = new ArrayList<>();
        for (Teacher t : teachers) {
            if (t.getSubject().equalsIgnoreCase(subject)) {
                result.add(t);
            }
        }
        return result;
    }
}
