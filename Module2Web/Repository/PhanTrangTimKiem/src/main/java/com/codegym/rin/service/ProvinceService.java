package com.codegym.rin.service;

import com.codegym.rin.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);

}
