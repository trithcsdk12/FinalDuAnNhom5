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
    private int MaGSP;
    private String Size;

    public SanPham() {
    }

    public SanPham(int maSP, String tenSP, boolean trangthai, int MaNV, String MoTa, String Hinh, String LoaiSP, float Gia, int MaGSP, String Size) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.trangthai = trangthai;
        this.MaNV = MaNV;
        this.MoTa = MoTa;
        this.Hinh = Hinh;
        this.LoaiSP = LoaiSP;
        this.Gia = Gia;
        this.MaGSP = MaGSP;
        this.Size = Size;
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

    public int getMaGSP() {
        return MaGSP;
    }

    public void setMaGSP(int MaGSP) {
        this.MaGSP = MaGSP;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }


    
}
