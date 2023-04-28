package com.UST.Employee.repository;

import com.UST.Employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepo extends JpaRepository<Employee,Integer> {
    Employee findByempId(String empId);

    void deleteByempId(String empId);
}
