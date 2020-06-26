package com.codegym.repositorys;

import com.codegym.models.Student;

import java.util.List;

public interface StudentRepository {

    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
}
