package com.example.jpastudent.repositories;

import com.example.jpastudent.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @BeforeEach
    void setup(){
        Student std = new Student();
        std.setName("Bruce");
        studentRepository.save(std);
    }

    @Test
    void testOneBruce(){
        List<Student> students = studentRepository.findAllByName("Bruce");
        assertTrue( students.size()> 0);
    }

}