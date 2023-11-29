/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g5.entityDAO;

import com.g5.util.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThongKeDAO {

    public List<Object[]> getHoaDon(Date ngay) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_ThongKeTheoNgay (?)}";
                rs = JDBCHelper.executeQuery(sql, ngay);
                while (rs.next()) {
                    Object[] model = {
                        rs.getDate("ngaytao"),
                        rs.getString("MaHD"),
                        rs.getInt("Gia")
                    };
                    list.add(model);
                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Object[]> getTheoThang(Date thang) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_ThongKeTheoThang (?)}";
                rs = JDBCHelper.executeQuery(sql, thang);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("ngaytao"),
                        rs.getDate("MaHD"),
                        rs.getInt("Gia")
                    };
                }
            } finally {
                //     rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Object[]> getTheoSP(int tu, int den) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_ThongKeSP (?, ?)}";
                rs = JDBCHelper.executeQuery(sql, tu, den);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuongBanRa"),
                        rs.getInt("Tong")
                    };
                }
            } finally {
                //    rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return list;
    }

    public List<Object[]> getTheoTG(int tu, int den) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_ThongKeTheoTG (? ,?)}";
                rs = JDBCHelper.executeQuery(sql, tu, den);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaHD"),
                        rs.getDate("Ngay"),
                        rs.getInt("Gia")
                    };
                }
            } finally {
                //   rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return list;
    }

}
