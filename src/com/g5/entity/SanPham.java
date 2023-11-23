/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g5.entity;

/**
 *
 * @author Asus
 */
public class SanPham {
    private int maSP;
    private String tenSP;
    private boolean trangthai;
    private int MaNV;
    private String MoTa;
    private String Hinh;
    private String LoaiSP;
    private float Gia;
    private float GiaSizeLon;

    public SanPham() {
    }

    public SanPham(String tenSP, boolean trangthai, int MaNV, String MoTa, String Hinh, String LoaiSP, float Gia, float GiaSizeLon) {
        this.tenSP = tenSP;
        this.trangthai = trangthai;
        this.MaNV = MaNV;
        this.MoTa = MoTa;
        this.Hinh = Hinh;
        this.LoaiSP = LoaiSP;
        this.Gia = Gia;
        this.GiaSizeLon = GiaSizeLon;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(String LoaiSP) {
        this.LoaiSP = LoaiSP;
    }

    public float getGia() {
        return Gia;
    }

    public void setGia(float Gia) {
        this.Gia = Gia;
    }

    public float getGiaSizeLon() {
        return GiaSizeLon;
    }

    public void setGiaSizeLon(float GiaSizeLon) {
        this.GiaSizeLon = GiaSizeLon;
    }

   
    
}
