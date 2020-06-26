package com.codegym.services.impl;

import com.codegym.entity.FuramaKhachHang;
import com.codegym.entity.FuramaLoaiKhachHang;
import com.codegym.repository.KhachHangRepository;
import com.codegym.services.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangRepository khachHangRepository;

    @Override
    public Page<FuramaKhachHang> getAllKhachHang(Pageable pageable) {
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public Page<FuramaKhachHang> findAllByHoTenContaining(String firstname, Pageable pageable) {
        return khachHangRepository.findAllByHoTenContaining(firstname, pageable);
    }

    @Override
    public FuramaKhachHang getKhachHang(Long idKhachhang) {
        return khachHangRepository.findById(idKhachhang).orElse(null
        );
    }

    @Override
    public void saveKhachHang(FuramaKhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void deleteKhachHang(Long idKhachHang) {
        khachHangRepository.deleteById(idKhachHang);
    }
}
