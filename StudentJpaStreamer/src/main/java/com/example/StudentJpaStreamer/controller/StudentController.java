package com.example.StudentJpaStreamer.controller;

import com.example.StudentJpaStreamer.entity.Student;
import com.example.StudentJpaStreamer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.createStudent(student);

    }
    @GetMapping("/details")
    public List<Student> getAll(){

        return studentService.getAll();
    }

    @GetMapping("/count/{courses}")
    public long getCountOfCourses(@PathVariable String courses){
        return studentService.getCountOfCourses(courses);
    }

    @GetMapping("/location/{address}")
    public List<Student> getListByLocation(@PathVariable String address){
        return studentService.getListByLocation(address);
    }

}
