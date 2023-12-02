/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g5.entityDAO;

import com.g5.entityDAO.SanPhamDao;
import com.g5.entity.SanPham;
import com.g5.util.JDBCHelper;
import com.g5.DAO.SanPhamDAOinterface;
import com.g5.entity.NhanVien;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class SanPhamDao implements SanPhamDAOinterface {

    String selectByID = "select * from SanPham where MaSP = ?";
    String selectAll = "select * from SanPham";
    String insert = "insert into SanPham (TenSP,SoLuong,MaNV,MoTa,Hinh,LoaiSP,GiaNguyenLieu) "
            + "values (?,?,?,?,?,?,?)";
    String update = "Update SanPham set TenSP=?, SoLuong=?, MaNV=?, MoTa=?, Hinh=?, LoaiSP=?, GiaNguyenLieu = ? where MaSP =?";
    String delete = "Delete from SanPham where MaSP = ?";
    String TenSP = "Select TenSP from SanPham where LoaiSP = ?";
    String MaSP = "Select MaSP from SanPham where TenSP = ?";
    String LoaiSP = "Select distinct LoaiSP from SanPham";
    String Size = "select size from GiaSanPham where MaSP = ?";
    String resetIdentity = "DBCC CHECKIDENT (SanPham,RESEED,?)";
    String tensp = "Select tensp from sanpham where masp = ?";

    public float getGiaByMaSPAndSize(int maSP, String size) {
        float gia = -1.0f;
        try {
            ResultSet rs = JDBCHelper.executeQuery("SELECT Gia FROM GiaSanPham WHERE MaSP = ? AND Size = ?", maSP, size);
            if (rs.next()) {
                gia = rs.getFloat("Gia");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gia;
    }

    @Override
    public SanPham getByID(Integer maSP) {
        List<SanPham> list = select(selectByID, maSP);
        return list.size() > 0 ? list.get(0) : null;
    }

    public SanPham getTenSP(Integer maSP) {
        List<SanPham> list = select(tensp, maSP);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<String> getSize(int MaSP) {
        List<String> sizeList = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(Size, MaSP);
            while (rs.next()) {
                String SizeSP = rs.getString("Size");
                sizeList.add(SizeSP);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sizeList;
    }

    public int getMaNVByTenSP(String tenSP) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(MaSP, tenSP);
            if (rs.next()) {
                return rs.getInt("MaSP");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<SanPham> getAll() {
        return select(selectAll);
    }

    @Override
    public Integer create(SanPham sp) {
        try {
            JDBCHelper.executeUpdate(insert,
                    sp.getTenSP(),
                    sp.getSoLuong(),
                    sp.getMaNV(),
                    sp.getMoTa(),
                    sp.getHinh(),
                    sp.getLoaiSP(),
                    sp.getGiaNguyenLieu()
            );
            return sp.getMaSP();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(SanPham sp) {
        JDBCHelper.executeUpdate(update,
                sp.getTenSP(),
                sp.getSoLuong(),
                sp.getMaNV(),
                sp.getMoTa(),
                sp.getHinh(),
                sp.getLoaiSP(),
                sp.getGiaNguyenLieu(),
                sp.getMaSP());
    }

    @Override
    public void deteleByID(Integer id) {
        JDBCHelper.executeUpdate(delete, id);
    }

    private List<SanPham> select(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    SanPham model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                // rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public void resetIdentity(int colum) {
        JDBCHelper.executeUpdate(resetIdentity, colum);
    }

    private SanPham readFromResultSet(ResultSet rs) throws SQLException {
        SanPham model = new SanPham();
        model.setMaSP(rs.getInt("MaSP"));
        model.setTenSP(rs.getString("TenSP"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setMaNV(rs.getInt("MaNV"));
        model.setMoTa(rs.getString("MoTa"));
        model.setHinh(rs.getString("Hinh"));
        model.setLoaiSP(rs.getString("LoaiSP"));
        model.setGiaNguyenLieu(rs.getFloat("GiaNguyenLieu"));
        return model;
    }

}
