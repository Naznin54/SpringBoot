package com.ust.SpringBootTestDemo.controller;

import com.ust.SpringBootTestDemo.entity.Student;
import com.ust.SpringBootTestDemo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/student/")
public class StudentController {

    private final Logger LOGGER= LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentservice;
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student){
        LOGGER.info("inside StudentController addStudent method RequestBody :{}", student);
        return studentservice.addStudent(student);
    }
    @GetMapping
    public List<Student> getAllStudent(){
        return studentservice.getAllStudent();
    }
    @GetMapping("/{student-id}")
    public Student getStudentById(@PathVariable("student-id")Integer id){
        return studentservice.getStudentById(id);
    }
    @DeleteMapping("{student-id}")
    public Student deleteStudentById(@PathVariable("student-id")Integer id){
        return studentservice.deleteStudentById(id);
    }
    @GetMapping("/name/{student-name}")
    public List<Student> getStudentByName(@PathVariable("student-name")String name){
        return studentservice.getStudentByName(name);
    }
}

