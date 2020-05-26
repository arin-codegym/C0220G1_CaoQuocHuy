package com.rin.blogopen.repository;


import com.rin.blogopen.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

}
