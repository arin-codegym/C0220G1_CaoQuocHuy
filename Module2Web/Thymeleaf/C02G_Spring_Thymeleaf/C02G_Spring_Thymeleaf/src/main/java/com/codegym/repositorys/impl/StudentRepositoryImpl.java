package com.codegym.repositorys.impl;

import com.codegym.models.Student;
import com.codegym.repositorys.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static Map<Integer, Student> mapStudents = new HashMap<>();

    static {
        mapStudents.put(1, new Student(1, "Tien", "2k"));
        mapStudents.put(2, new Student(2, "Toan", "3k"));
    }

    @Override
    public void save(Student student) {
        mapStudents.put(student.getId(), student);
    }

    @Override
    public Student findById(Integer id) {
        return mapStudents.get(id);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(mapStudents.values());
    }
}
