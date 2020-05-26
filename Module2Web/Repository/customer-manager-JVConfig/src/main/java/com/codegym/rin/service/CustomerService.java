package com.codegym.rin.service;

import com.codegym.rin.model.Customer;
import com.codegym.rin.model.Province;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}