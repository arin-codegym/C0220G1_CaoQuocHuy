package com.codegym.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dichvu")
public class FuramaDichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "tendichvu")
    private String tenDichVu;

    @Column(name = "dientich")
    private double dienTich;

    @Column(name = "sotang")
    private int soTang;

    @Column(name = "songuoitoida")
    private int soNguoiToiDa;

    @Column(name = "chiphithue")
    private double chiPhiThue;

    @Column(name = "trangthai")
    private String trangThai;

    @Column(name = "kieuthue_id")
    private int kieuThueId;

    @Column(name = "img")
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @ManyToOne
    @JoinColumn(name = "loaidichvu_id")
    private FuramaLoaiDichVu furamaLoaiDichVu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public List<FuramaDichVu> getFuramaDichVus() {
        return furamaDichVus;
    }

    public void setFuramaDichVus(List<FuramaDichVu> furamaDichVus) {
        this.furamaDichVus = furamaDichVus;
    }

    @OneToMany(targetEntity = FuramaHopDong.class)

    private List<FuramaDichVu> furamaDichVus;

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public double getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(double chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getKieuThueId() {
        return kieuThueId;
    }

    public void setKieuThueId(int kieuThueId) {
        this.kieuThueId = kieuThueId;
    }

    public FuramaLoaiDichVu getFuramaLoaiDichVu() {
        return furamaLoaiDichVu;
    }

    public void setFuramaLoaiDichVu(FuramaLoaiDichVu furamaLoaiDichVu) {
        this.furamaLoaiDichVu = furamaLoaiDichVu;
    }

    public FuramaDichVu() {
    }
}
