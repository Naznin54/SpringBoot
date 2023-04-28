package com.ust.SpringBootTestDemo.StudentControllerTest;

import com.ust.SpringBootTestDemo.controller.StudentController;
import com.ust.SpringBootTestDemo.entity.Student;
import com.ust.SpringBootTestDemo.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StudentController.class)
public class StudentTestController {
    @Autowired
    private MockMvc  mockMvc;
    @MockBean
    private StudentService studentservice;

    private Student student;
    @BeforeEach
    void setup(){
        student= new Student(1,"naz","TVM","123456");

    }
    @Test
    void testSaveStudent() throws Exception {
        Student student = new Student(1,"naz","TVM","123456");
        Mockito.when(studentservice.addStudent(student)).thenReturn(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/student/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\r\n" +
                                " \"id\" : 1, \r\n" +
                                " \"name\" : \"naz\", \r\n" +
                                " \"address\" :\"TVM\", \r\n" +
                                " \"rollNo\" : \"123456\" \r\n" + "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

