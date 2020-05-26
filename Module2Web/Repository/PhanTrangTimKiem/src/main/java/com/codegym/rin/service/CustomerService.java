package com.codegym.rin.service;

import com.codegym.rin.model.Customer;
import com.codegym.rin.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class CustomerService {

    public abstract Page<Customer> findAll(Pageable pageable);

    public abstract Customer findById(Long id);

    public abstract void save(Customer customer);

    public abstract void remove(Long id);

    public abstract Iterable<Customer> findAllByProvince(Province province);
    public abstract Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}