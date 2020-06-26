package com.codegym.services.impl;

import com.codegym.entity.FuramaLoaiKhachHang;
import com.codegym.repository.LoaiKhachHangRepository;
import com.codegym.services.LoaiKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.print.Pageable;
import java.util.List;

@Service
public class LoaiKhachHangServiceImpl implements LoaiKhachHangService {
    @Autowired
    private LoaiKhachHangRepository loaiKhachHangRepository;

    @Override
    public List<FuramaLoaiKhachHang> getAllLoaiKhachHang() {
        return loaiKhachHangRepository.findAll();
    }

    @Override
    public FuramaLoaiKhachHang getLoaiKhachHang(Long idLoaiKhach) {
        return loaiKhachHangRepository.findById(idLoaiKhach).orElse(null);
    }

    @Override
    public void saveLoaiKhachHang(FuramaLoaiKhachHang loaiKhachHang) {
        loaiKhachHangRepository.save(loaiKhachHang);
    }

    @Override
    public void deleteLoaiKhachHang(Long idLoaiKhach) {
        loaiKhachHangRepository.deleteById(idLoaiKhach);
    }
}
