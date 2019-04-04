package com.example.redistest.endpoint;

import com.example.redistest.model.Student;
import com.example.redistest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Rest {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/save")
    public String createStudent(@PathParam("id") String id) {
        Student student = new Student("Eng2015001" + "_" + id, "John Doe", Student.Gender.MALE, 1);
        studentRepository.save(student);
        return "saved! " + student.getId();
    }

    @GetMapping("/get")
    private Student getStudent(@PathParam("id") String id) {
        return studentRepository.findOne(id);
    }

    @GetMapping("/all")
    private List<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }
}
