package com.example.StudentJpaStreamer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="student_tbl")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String studentId;
    private String name;
    private String email;
    private Long phoneNo;
    private String qualification;
    private int workingExperience;
    @ElementCollection
    private List<String> courses;
    private String address;
    private String comments;
}
