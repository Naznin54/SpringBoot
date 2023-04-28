package com.UST.Employee.controller;

import com.UST.Employee.entity.Employee;
import com.UST.Employee.service.Employeeservice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(Empcontroller.class)
class EmpcontrollerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Employeeservice mockEmpservice;

    @Test
    void testAddress() throws Exception {
        // Setup
        // Configure Employeeservice.createEmployee(...).
        final Employee employee = new Employee(0, "empId", "empname", "empdesignation", "emphr");
        when(mockEmpservice.createEmployee(new Employee(0, "empId", "empname", "empdesignation", "emphr")))
                .thenReturn(employee);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/emps")
                        .content(asJsonString(employee)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

    private String asJsonString(Employee employee) {
        try{
            return new ObjectMapper().writeValueAsString(employee);
        }
        catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }


    @Test
    void testGetAllEmployee() throws Exception {
        // Setup
        // Configure Employeeservice.getEmployees(...).
        final List<Employee> employees = List.of(new Employee(0, "empId", "empname", "empdesignation", "emphr"));
        when(mockEmpservice.getEmployees()).thenReturn(employees);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/employee")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

    @Test
    void testGetAllEmployee_EmployeeserviceReturnsNoItems() throws Exception {
        // Setup
        when(mockEmpservice.getEmployees()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/employee")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

    @Test
    void testGetEmployeeById() throws Exception {
        // Setup
        // Configure Employeeservice.findByempId(...).
        final Employee employee = new Employee(0, "empId", "empname", "empdesignation", "emphr");
        when(mockEmpservice.findByempId("empId")).thenReturn(employee);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/employees/{empId}", "empId")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

    @Test
    void testDeleteEmployeeById() throws Exception {
        // Setup
        when(mockEmpservice.deleteEmployeeByempId("empId")).thenReturn("result");

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(delete("/emps/{empId}", "empId")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }
}
