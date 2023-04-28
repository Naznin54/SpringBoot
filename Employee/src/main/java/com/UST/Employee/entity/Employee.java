package com.UST.Employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="employee_details")
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String empId;
    private String empname;
    private String empdesignation;
    private String emphr;
}
