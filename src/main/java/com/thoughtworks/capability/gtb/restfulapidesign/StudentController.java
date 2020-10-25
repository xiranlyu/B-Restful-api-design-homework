package com.thoughtworks.capability.gtb.restfulapidesign;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getAllStudents (@RequestParam(name = "gender", required = false) Gender gender) {
        return studentService.getAllStudents(gender);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PATCH)
    public void updateStudent(@RequestParam(name = "gender", required = false) Gender gender,
                              @RequestParam(name = "name", required = false) String name,
                              @RequestParam(name = "note", required = false) String note,
                              @PathVariable int id) {
        studentService.updateStudent(id, gender, name, note);
    }
}
