package com.codegym.rin.service.impl;

import com.codegym.rin.model.Province;
import com.codegym.rin.repository.ProvinceRepository;
import com.codegym.rin.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findOne(id);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.delete(id);
    }
}