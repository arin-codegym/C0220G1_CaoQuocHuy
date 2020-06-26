package com.codegym.services;

import com.codegym.entity.FuramaDichVu;
import com.codegym.entity.FuramaHopDong;

public interface HopDongService {
    public Iterable<FuramaHopDong> getAllHopDong();
    public FuramaHopDong getHopDong(Long idHopDong);
    public void saveHopDong(FuramaHopDong hopDong);
    void deleteHopDong(Long idHopDong);
    Iterable<FuramaHopDong> findAllByIdKhachHang(Long id);
}
