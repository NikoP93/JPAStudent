package com.example.jpastudent.controller;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students() {
        var obj = studentRepository.findAll();
        return obj;
    }

    @GetMapping("/")
    public String detteErRoden(){
        return "Du er i roden af JPA STUDENT";
    }

    @GetMapping("students/{name}")
    public List<Student> getAllStudentsByName(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }

    @GetMapping("/hellox")
    public String hello() {
        return "Hello World From Student";
    }

    @GetMapping("/hello/{sleep}")
    public String helloSleep(@PathVariable int sleep) throws InterruptedException {

        Thread.sleep(sleep);
        return "Hello World From Student sleep";
    }
}
