package com.codegym.services;

import com.codegym.models.Student;

import java.util.List;

public interface StudentService {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();
}
