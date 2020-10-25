package com.thoughtworks.capability.gtb.restfulapidesign;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GroupingService {
    private final Map<Integer, Group> groupMap = new HashMap<>();
    private StudentService studentService = new StudentService();

    public GroupingService(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<Group> grouping() {
        for (int i = 1; i <= 6; i++) {
            groupMap.put(i, new Group(i, "Group " + i, "", new ArrayList<>()));
        }
        List<Student> students = studentService.getAllStudents(null);
        Collections.shuffle(students);
            for (int i = 0; i < students.size(); i++) {
                groupMap.get(i % 6 + 1).getGroupList().add(students.get(i));
            }
        return new ArrayList<>(groupMap.values());
    }

    public void updateGroupName(int id, String name) {
        groupMap.get(id).setName(name);
    }

    public List<Group> getGroupLists() {
        return new ArrayList<>(groupMap.values());
    }
}
