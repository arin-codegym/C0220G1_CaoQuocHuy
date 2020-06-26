package com.codegym.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Date;
@Entity
@Table(name = "khachhang")
public class FuramaKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idloaikhach")
    private FuramaLoaiKhachHang loaiKhachHang;

    @NotEmpty(message = "Khong được để trống")
    @Column(name = "hoten")
    private String hoTen;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "ngaysinh")
    private Date ngaySinh;

    @NotEmpty(message = "vui lòng điền thông tin cmnd")
    @Column(name = "socmtnd")
    private String CMND;

    @NotEmpty(message = "vui lòng điền thông tin sdt")
    @Column(name = "sdt")
    private String sdt;

    @NotEmpty(message = "vui lòng điền thông tin email")
    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "Email chưa đúng định dạng")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "vui lòng điền thông tin địa chỉ")
    @Column(name = "diachi")
    private String diaChi;

    public FuramaKhachHang() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FuramaLoaiKhachHang getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(FuramaLoaiKhachHang loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
