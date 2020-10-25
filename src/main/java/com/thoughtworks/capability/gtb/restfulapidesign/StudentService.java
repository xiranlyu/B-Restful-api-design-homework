package com.thoughtworks.capability.gtb.restfulapidesign;

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
