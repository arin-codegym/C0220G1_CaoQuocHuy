package com.codegym.repository;

import com.codegym.entity.FuramaKhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<FuramaKhachHang,Long> {
Page<FuramaKhachHang> findAllByHoTenContaining(String firstname, Pageable pageable);
}
