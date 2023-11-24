/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g5.entityDAO;

import com.g5.DAO.SanPhamDAO;
import com.g5.entity.SanPham;
import com.g5.util.JDBCHelper;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class SanPhamDaoImpl implements SanPhamDAO {

    String selectByID = "select * from SanPham where MaSP = ?";
    String selectAll = "select * from SanPham";
    String insert = "insert into SanPham (TenSP,TrangThai,MaNV,MoTa,Hinh,LoaiSP,Gia,GiaSizeLon) "
            + "values (?,?,?,?,?,?,?,?)";
    String update = "Update SanPham set TenSP=?, TrangThai=?, MaNV=?, MoTa=?, Hinh=?, LoaiSP=?, Gia=?,GiaSizeLon=? where MaSP =?";
    String delete = "Delete from SanPham where MaSP = ?";
    String TenSP = "Select TenSP from SanPham where LoaiSP = ?";
    String MaSP = "Select MaSP from SanPham where TenSP = ?";
    String LoaiSP = "Select distinct LoaiSP from SanPham";
    String Size = "select size from GiaSanPham where MaSP = ?";

    public float getGiaByMaSPAndSize(int maSP, String size) {
        float gia = -1.0f;
        String query = "SELECT Gia FROM GiaSanPham WHERE MaSP = ? AND Size = ?";
        String dburl = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;database=a";
        String username = "sa";
        String password = "123";
        try (Connection connection = DriverManager.getConnection(dburl, username, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, maSP);
            preparedStatement.setString(2, size);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    gia = rs.getFloat("Gia");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Thay bằng xử lý lỗi phù hợp trong ứng dụng thực tế
        }

        return gia;
    }

    @Override
    public SanPham getByID(Integer maSP) {
        List<SanPham> list = select(selectByID, maSP);
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

    
    public List<String> getTenSPByLoaiSP(String loaiSP) {
        List<String> tenSPList = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(TenSP, loaiSP);
            while (rs.next()) {
                String tenSP = rs.getString("TenSP");
                tenSPList.add(tenSP);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tenSPList;
    }

    public List<SanPham> getLoaiSPcbo() {
        return select(LoaiSP);
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

    public List<SanPham> getLoaiSP(String loaiSP) {
        return select(TenSP, loaiSP);
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
                    sp.isTrangthai(),
                    sp.getMaNV(),
                    sp.getMoTa(),
                    sp.getHinh(),
                    sp.getLoaiSP()
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
                sp.isTrangthai(),
                sp.getMaNV(),
                sp.getMoTa(),
                sp.getHinh(),
                sp.getMaNV());
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
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private SanPham readFromResultSet(ResultSet rs) throws SQLException {
        SanPham model = new SanPham();
        model.setMaNV(rs.getInt("MaSP"));
        model.setTenSP(rs.getString("TenSP"));
        model.setTrangthai(rs.getBoolean("trangthai"));
        model.setMaNV(rs.getInt("MaNV"));
        model.setMoTa(rs.getString("MoTa"));
        model.setHinh(rs.getString("Hinh"));
        model.setLoaiSP(rs.getString("LoaiSP"));
        return model;
    }

}
