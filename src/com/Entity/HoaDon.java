/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Entity;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class HoaDon {
    private int maHD;
    private Date NgayTao;
    private int maNV;
    private float TienKhachTra;
    private float TongTien;
    private String DiaChi;
    private boolean trangthai;

    public HoaDon() {
    }

    public HoaDon(Date NgayTao, int maNV, float TienKhachTra, float TongTien, String DiaChi, boolean trangthai) {
        this.NgayTao = NgayTao;
        this.maNV = maNV;
        this.TienKhachTra = TienKhachTra;
        this.TongTien = TongTien;
        this.DiaChi = DiaChi;
        this.trangthai = trangthai;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public float getTienKhachTra() {
        return TienKhachTra;
    }

    public void setTienKhachTra(float TienKhachTra) {
        this.TienKhachTra = TienKhachTra;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    
    
}
