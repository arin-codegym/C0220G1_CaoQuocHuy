package com.codegym.repository;

import com.codegym.entity.FuramaDichVu;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

@Repository
public interface DichVuRepositoty extends PagingAndSortingRepository<FuramaDichVu,Long> {
    Iterable<FuramaDichVu> findAllByChiPhiThueBetween(Double fromPrice, Double toPrice);
}
