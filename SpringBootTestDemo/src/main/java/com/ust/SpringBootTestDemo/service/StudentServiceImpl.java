package com.ust.SpringBootTestDemo.service;

import com.ust.SpringBootTestDemo.entity.Student;
import com.ust.SpringBootTestDemo.exception.StudentNotFoundException;
import com.ust.SpringBootTestDemo.repository.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private Studentrepo studentrepo;
    @Override
    public Student addStudent(Student student) {
        return studentrepo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentrepo.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> s=studentrepo.findById(id);
        if(!s.isPresent()){
            throw new StudentNotFoundException("student with id :" +id +"doesn't exist");
        }
        return s.get();
    }



    @Override
    public Student deleteStudentById(Integer id) {
        Optional<Student> s = studentrepo.findById(id);
        if (!s.isPresent()) {
            throw new StudentNotFoundException("student with id :" + id + "doesn't exist");
        }
        studentrepo.delete(s.get());
        return s.get();
    }
    @Override
    public List<Student> getStudentByName(String name) {
        return studentrepo.findByName(name);
    }


}
