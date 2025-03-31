package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class Studentservice  {

    @Autowired
    private StudentRepository studentRepository;

    

    public ResponseEntity<?> cree(Student student) {
        Optional<Student> optionalStudent = studentRepository.findByEmail(student.getEmail());
    
        return optionalStudent.isPresent()
            ? ResponseEntity.status(HttpStatus.CONFLICT).body("L'étudiant existe déjà !")
            : ResponseEntity.status(HttpStatus.CREATED).body(
                new StudentDto(studentRepository.save(student).getId(), student.getEmail(),student.getMdp())
        );
    }
    // public Student saveStudent(Student student) {
    //     student.setMdp(passwordEncoder.encode(student.getMdp()));
    //     return studentRepository.save(student);
    // }

    public List<Student> listStudent() {
        return studentRepository.findAll();
    }

  
}
