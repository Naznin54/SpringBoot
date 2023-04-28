package com.example.StudentJpaStreamer.service;

import com.example.StudentJpaStreamer.entity.Student;
import com.example.StudentJpaStreamer.entity.Student$;
import com.example.StudentJpaStreamer.repository.StudentRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private JPAStreamer jpaStreamer;
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public long getCountOfCourses(String courses) {
        Predicate<Student> courseFilter = student -> student.getCourses().contains(courses);
        return jpaStreamer.stream(Student.class)
                .filter(courseFilter)
                .count();
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public List<Student> getListByLocation(String address) {
        return jpaStreamer.stream(Student.class)
                .filter(Student$.address.contains(address))
                .collect(Collectors.toList());
    }
}
