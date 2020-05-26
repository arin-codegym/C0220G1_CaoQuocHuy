package com.codegym.rin.repository;

import com.codegym.rin.model.Customer;
import com.codegym.rin.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
