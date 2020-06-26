package com.codegym.services;

import com.codegym.entity.FuramaKhachHang;
import com.codegym.entity.FuramaLoaiKhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhachHangService {
    public Page<FuramaKhachHang> getAllKhachHang(Pageable pageable);

    public FuramaKhachHang getKhachHang(Long idKhachhang);

    public void saveKhachHang(FuramaKhachHang khachHang);

    public void deleteKhachHang(Long idKhachHang);
    Page<FuramaKhachHang> findAllByHoTenContaining(String firstname, Pageable pageable);
}
