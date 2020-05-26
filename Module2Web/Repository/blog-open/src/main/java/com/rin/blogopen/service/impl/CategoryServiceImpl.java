package com.rin.blogopen.service.impl;


import com.rin.blogopen.model.Category;
import com.rin.blogopen.repository.CategoryRepository;
import com.rin.blogopen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category province) {
        categoryRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}