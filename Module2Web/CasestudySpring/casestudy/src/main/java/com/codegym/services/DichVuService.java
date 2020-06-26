package com.codegym.services;

import com.codegym.entity.FuramaDichVu;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface DichVuService {
    public Iterable<FuramaDichVu> getAllDichVu();
    public FuramaDichVu getDichVu(Long idDichVu);
    public void saveDichVu(FuramaDichVu dichVu);
    void deleteDichVu(Long idDichVu);
    public Iterable<FuramaDichVu> findAllByChiPhiThueBetween(Double fromPrice, Double toPrice);
}
