/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g5.entityDAO;

import com.g5.util.XDate;
import com.g5.entity.HoaDon;
import com.g5.entity.KhuyenMai;
import com.g5.entity.NhanVien;
import com.g5.entity.SanPham;

/**
 *
 * @author Asus
 */
public class test {
    public static void main(String[] args) {
        KhuyenMaiDAOImpl kmDAO = new KhuyenMaiDAOImpl();
        KhuyenMai km = new KhuyenMai(XDate.toDate("1/1/2023", "dd/mm/yyyy"), XDate.toDate("1/2/2023", "dd/mm/yyyy"), "TetDuongLich", 20, 1);
        kmDAO.create(km);
    }
}
