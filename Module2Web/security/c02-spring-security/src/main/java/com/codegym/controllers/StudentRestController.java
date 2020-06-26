package com.codegym.controllers;

import com.codegym.models.Student;
import com.codegym.models.User;
import com.codegym.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getAllListStudents")
//    @RequestMapping(value = "/getAllListStudents", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllListStudents() {
        List<Student> studentList = studentService.findAll();

        return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUsername(@SessionAttribute("userInfo") User user) {
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
        Student student = studentService.findById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> createStudent(@RequestBody Student student, UriComponentsBuilder ucBuilder) {
        studentService.save(student);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/student/{id}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
