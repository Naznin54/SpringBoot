package com.ust.SpringBootTestDemo.repository;

import com.ust.SpringBootTestDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Studentrepo extends JpaRepository<Student,Integer> {

    List<Student> findByName(String name);
}
