package com.codegym.repositorys;

import com.codegym.models.ClassStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassStudentRepository extends JpaRepository<ClassStudent, Integer> {
}
