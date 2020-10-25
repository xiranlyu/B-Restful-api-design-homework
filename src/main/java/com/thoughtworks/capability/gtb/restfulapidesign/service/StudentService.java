package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<Integer, Student> studentMap = new HashMap<>();

    public StudentService() {
        studentMap.put(17517, new Student(17517, "Test1", Gender.Female, "test1"));
        studentMap.put(17518, new Student(17518, "Test2", Gender.Male, "test2"));
        studentMap.put(17519, new Student(17519, "Test3", Gender.Male, "test3"));
        studentMap.put(17520, new Student(17520, "Test4", Gender.Female, "test4"));
        studentMap.put(17521, new Student(17521, "Test5", Gender.Male, "test5"));
        studentMap.put(17522, new Student(17522, "Test6", Gender.Male, "test6"));
        studentMap.put(17523, new Student(17523, "Test7", Gender.Female, "test7"));
        studentMap.put(17524, new Student(17524, "Test8", Gender.Male, "test8"));
        studentMap.put(17525, new Student(17525, "Test9", Gender.Male, "test9"));
    }

    public void createStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    public void deleteStudentById(int id) {
        studentMap.remove(id);
    }

    public List<Student> getAllStudents(Gender gender) {
        if (gender == null) {
            return new ArrayList<>(studentMap.values());
        } else {
            return studentMap.values().stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
        }
    }

    public Student getStudent(int id) {
        return studentMap.get(id);
    }

    public void updateStudent(int id, Gender gender, String name, String note) {
        if (gender != null) {
            studentMap.get(id).setGender(gender);
        }
        if (name != null) {
            studentMap.get(id).setName(name);
        }
        if (note != null) {
            studentMap.get(id).setNote(note);
        }
    }
}
