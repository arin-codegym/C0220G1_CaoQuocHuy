package com.codegym.rin.service.impl;

import com.codegym.rin.model.Customer;
import com.codegym.rin.model.Province;
import com.codegym.rin.repository.CustomerRepository;
import com.codegym.rin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiecImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }
}