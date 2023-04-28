package com.UST.Employee.service;

import com.UST.Employee.entity.Employee;
import com.UST.Employee.repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class Employeeservice {
    @Autowired
    private Employeerepo repo;
    public Employee createEmployee(Employee employee) {
        return repo.save(employee);
    }

    public List<Employee> getEmployees() {
        return repo.findAll();
    }





    public Employee findByempId(String empId) {
        return repo.findByempId(empId);
    }

    @Transactional
    public String deleteEmployeeByempId(String empId) {
        repo.deleteByempId(empId);
        return "Employee Deleted...";
    }

}
