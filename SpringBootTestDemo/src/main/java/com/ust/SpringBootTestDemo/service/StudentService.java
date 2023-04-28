package com.ust.SpringBootTestDemo.service;

import com.ust.SpringBootTestDemo.entity.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentById(Integer id);

    Student deleteStudentById(Integer id);

    List<Student> getStudentByName(String name);
}
