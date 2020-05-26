package com.codegym.repository;

import com.codegym.model.Blog;

import java.util.List;

public interface BlogRepository extends Repository<Blog> {
    List<Blog> findAll();
    Blog findById(Long id);
    void save(Blog model);
    void remove(Long id);


}
