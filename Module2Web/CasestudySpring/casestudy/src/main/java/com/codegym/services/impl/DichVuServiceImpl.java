package com.codegym.services.impl;

import com.codegym.entity.FuramaDichVu;
import com.codegym.repository.DichVuRepositoty;
import com.codegym.services.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DichVuServiceImpl implements DichVuService {
    @Autowired
    private DichVuRepositoty dichVuRepositoty;

    @Override
    public Iterable<FuramaDichVu> getAllDichVu() {
        return dichVuRepositoty.findAll();
    }

    @Override
    public FuramaDichVu getDichVu(Long idDichVu) {
        return dichVuRepositoty.findById(idDichVu).orElse(null);
    }

    @Override
    public void saveDichVu(FuramaDichVu dichVu) {
        dichVuRepositoty.save(dichVu);
    }

    @Override
    public void deleteDichVu(Long idDichVu) {
        dichVuRepositoty.deleteById(idDichVu);
    }
    @Override
    public Iterable<FuramaDichVu> findAllByChiPhiThueBetween(Double fromPrice, Double toPrice) {
        return dichVuRepositoty.findAllByChiPhiThueBetween(fromPrice,toPrice);
    }
}
