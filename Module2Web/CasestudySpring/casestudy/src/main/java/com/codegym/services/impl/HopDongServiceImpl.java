package com.codegym.services.impl;

import com.codegym.entity.FuramaHopDong;
import com.codegym.repository.HopDongRepository;
import com.codegym.repository.KhachHangRepository;
import com.codegym.services.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HopDongServiceImpl implements HopDongService {
    @Autowired
    private HopDongRepository hopDongRepository;

    @Override
    public Iterable<FuramaHopDong> findAllByIdKhachHang(Long id) {
        return hopDongRepository.findAllByIdKhachHang(id);
    }

    @Override
    public Iterable<FuramaHopDong> getAllHopDong() {

        return hopDongRepository.findAll();
    }

    @Override
    public FuramaHopDong getHopDong(Long idHopDong) {

        return hopDongRepository.findById(idHopDong).orElse(null);
    }

    @Override
    public void saveHopDong(FuramaHopDong hopDong)
    {
        hopDongRepository.save(hopDong);
    }

    @Override
    public void deleteHopDong(Long idHopDong)
    {
        hopDongRepository.deleteById(idHopDong);
    }
}
