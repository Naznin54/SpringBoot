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
@Table(name="institute_tbl")
public class Institute {
    @Id
    @GeneratedValue
    private String instituteName;
    private String instituteLocation;
    @ElementCollection
    private List<String> price;

}
