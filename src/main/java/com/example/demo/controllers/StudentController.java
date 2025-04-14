package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.services.Studentservice;

@RestController
public class StudentController {

    @Autowired
    private Studentservice studentservice;

    @PostMapping("/student")
    public Student cree (@RequestBody Student student){

        return studentservice.saveStudent(student);   
    }
    @GetMapping("/student")
    public List<Student> liste(){
        return studentservice.listStudent();
    }
    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello, ";
    }
    // @PostMapping("/login")
    // public String login(@RequestParam String email, @RequestParam String mdp) {
    //     return studentService.authenticateStudent(email, mdp); // Renvoyer le token JWT
    // }
}
