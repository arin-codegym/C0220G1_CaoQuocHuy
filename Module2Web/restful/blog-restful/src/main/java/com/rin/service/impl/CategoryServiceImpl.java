package com.rin.service.impl;



import com.rin.model.Category;
import com.rin.repository.CategoryRepository;
import com.rin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
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