package com.thoughtworks.capability.gtb.restfulapidesign;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping(value = "/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @GetMapping
    public List<Student> getAllStudents (@RequestParam(name = "gender", required = false) Gender gender) {
        return studentService.getAllStudents(gender);
    }

    @PatchMapping(value = "/{id}")
    public void updateStudent(@RequestParam(name = "gender", required = false) Gender gender,
                              @RequestParam(name = "name", required = false) String name,
                              @RequestParam(name = "note", required = false) String note,
                              @PathVariable int id) {
        studentService.updateStudent(id, gender, name, note);
    }
}
