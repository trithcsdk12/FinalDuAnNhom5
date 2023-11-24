/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g5.entityDAO;


import com.g5.util.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author Asus
 */
public class Procedure {
    public List<Object[]> HoaDon() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call GetHoaDonInfo}";
                rs = JDBCHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getInt("MaHD"),
                        rs.getDate("NgayTao"),
                        rs.getInt("MaNV"),
                        rs.getInt("MaSP"),
                        rs.getInt("SoLuong"),
                        rs.getString("Size"),
                        rs.getFloat("PTKhuyenMai"),
                        rs.getFloat("GiaSauKhuyenMai"),
                        rs.getString("GhiChu")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
}

