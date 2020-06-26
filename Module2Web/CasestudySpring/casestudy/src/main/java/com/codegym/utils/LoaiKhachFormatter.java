package com.codegym.utils;

import com.codegym.entity.FuramaLoaiKhachHang;
import com.codegym.repository.KhachHangRepository;
import com.codegym.repository.LoaiKhachHangRepository;
import com.codegym.services.LoaiKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class LoaiKhachFormatter implements Formatter<FuramaLoaiKhachHang> {

    private LoaiKhachHangService loaiKhachHangService;
    @Autowired
    public LoaiKhachFormatter(LoaiKhachHangService loaiKhachHangService){
        this.loaiKhachHangService=loaiKhachHangService;
    }
    @Override
    public FuramaLoaiKhachHang parse(String text, Locale locale) throws ParseException {
        return loaiKhachHangService.getLoaiKhachHang(Long.parseLong(text));
    }

    @Override
    public String print(FuramaLoaiKhachHang object, Locale locale) {
        return null;
    }
}
