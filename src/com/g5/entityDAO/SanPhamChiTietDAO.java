/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g5.entityDAO;

import com.g5.entity.SanPham;
import com.g5.util.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trith
 */
public class SanPhamChiTietDAO {

    String selectAll = "select * from GiaSanPham";
    String selectByID = "select * from GiaSanPham where MaSP = ?";
    String insert = "insert into GiaSanPham (MaSP,Size,Gia)"
            + "values (?,?,?)";
    String update = "Update GiaSanPham set Gia = ? where Ten SP = ? and Size = ?";
    String delete = "Delete from SanPham where Size = ? and TenSP = ?";

    public SanPham getByID(Integer maSP) {
        List<SanPham> list = select(selectByID, maSP);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<SanPham> selectByID(Integer maSP) {
        return this.select(selectByID, maSP);
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
                   //rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private SanPham readFromResultSet(ResultSet rs) throws SQLException {
        SanPham model = new SanPham();
        model.setMaSP(rs.getInt("MaSP"));
        model.setSize(rs.getString("Size"));
        model.setGia(rs.getFloat("Gia"));
        return model;
    }

    public List<SanPham> getAll() {
        return select(selectAll);
    }

    public Integer create(SanPham sp) {
        try {
            JDBCHelper.executeUpdate(insert,
                    sp.getMaGSP(),
                    sp.getMaSP(),
                    sp.getSize(),
                    sp.getGia()
            );
            return sp.getMaSP();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(SanPham sp) {
        JDBCHelper.executeUpdate(update,
                sp.getMaSP(),
                sp.getSize(),
                sp.getGia()
        );
    }

    public void deteleByID(String size, String tenSP ) {
        JDBCHelper.executeUpdate(delete, size, tenSP);
    }
}
