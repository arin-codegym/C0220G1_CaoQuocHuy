package com.codegym.services;

import com.codegym.entity.FuramaLoaiKhachHang;

import java.awt.*;
import java.util.List;


public interface LoaiKhachHangService {
    List<FuramaLoaiKhachHang> getAllLoaiKhachHang();

    FuramaLoaiKhachHang getLoaiKhachHang(Long idLoaiKhach);

    void saveLoaiKhachHang(FuramaLoaiKhachHang loaiKhachHang);

    void deleteLoaiKhachHang(Long idLoaiKhach);

}
