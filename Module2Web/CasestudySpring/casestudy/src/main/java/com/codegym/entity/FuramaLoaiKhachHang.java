package com.codegym.entity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loaikhachhang")
public class FuramaLoaiKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idloaikhach")
    private Long id;
    @Column(name = "tenloaikhach")
    private String name;
    @OneToMany(targetEntity = FuramaKhachHang.class)
    private List<FuramaKhachHang> khachHangs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FuramaKhachHang> getKhachHangs() {
        return khachHangs;
    }

    public void setKhachHangs(List<FuramaKhachHang> khachHangs) {
        this.khachHangs = khachHangs;
    }

    public FuramaLoaiKhachHang() {
    }
}
