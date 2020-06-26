package com.codegym.repositorys;

import com.codegym.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Page<Student> findByNameContaining(String name, Pageable pageable);

    Page<Student> findByClassStudent_Id(String id, Pageable pageable);
}
