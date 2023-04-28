package com.UST.Employee.controller;

import com.UST.Employee.entity.Employee;
import com.UST.Employee.service.Employeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping
public class Empcontroller {
    @Autowired
    private Employeeservice empservice;
    @PostMapping("/emps")
    public Employee address(@RequestBody Employee employee) {
        return empservice.createEmployee(employee);
    }
    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return empservice.getEmployees();
    }
    @GetMapping("/employees/{empId}")
    public Employee getEmployeeById(@PathVariable String empId){
        return empservice.findByempId(empId);
    }

    @DeleteMapping("/emps/{empId}")
    public String deleteEmployeeById(@PathVariable String empId){
        return empservice.deleteEmployeeByempId(empId);
    }
}

