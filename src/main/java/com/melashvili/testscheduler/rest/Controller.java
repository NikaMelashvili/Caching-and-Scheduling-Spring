package com.melashvili.testscheduler.rest;

import com.melashvili.testscheduler.model.MoreStudents;
import com.melashvili.testscheduler.model.Student;
import com.melashvili.testscheduler.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students = service.getAll();
        return students;
    }

    @GetMapping("/more/students")
    public List<MoreStudents> getMoreAllStudents(){
        List<MoreStudents> students = service.getMoreAll();
        return students;
    }
}
