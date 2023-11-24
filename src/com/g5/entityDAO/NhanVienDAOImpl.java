/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g5.entityDAO;

import com.g5.entity.NhanVien;
import com.g5.util.JDBCHelper;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.g5.DAO.NhanVienDAOinterface;

/**
 *
 * @author Asus
 */
public class NhanVienDAOImpl implements NhanVienDAOinterface {

    String selectByID = "select * from NhanVien where MaNV = ?";
    String selectAll = "select * from NhanVien";
    String insert = "insert into NhanVien (HoTen,MatKhau,SDT,Email,GioiTinh,VaiTro,NgaySinh,DiaChi,TrangThai,Hinh) "
            + "values (?,?,?,?,?,?,?,?,?,?)";
    String update = "Update NhanVien set HoTen=?, MatKhau=?, SDT=?, Email=?, GioiTinh=?, VaiTro=?, NgaySinh=?, DiaChi =?, TrangThai =?, Hinh = ? where MaNV =?";
    String delete = "Delete from NhanVien where MaNV = ?";
    String selectLast = "select * from NhanVien order by MaNV desc";

    @Override
    public NhanVien getByID(Integer maNV) {
        List<NhanVien> list = select(selectByID, maNV);
        return list.size() > 0 ? list.get(0) : null;
    }

    public NhanVien getByIDLast() {
        List<NhanVien> list = select(selectLast);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhanVien> getAll() {
        return select(selectAll);
    }

    @Override
    public Integer create(NhanVien nhanVien) {
    
        try {
            JDBCHelper.executeUpdate(insert,
                    nhanVien.getHoTen(),
                    nhanVien.getMatkhau(),
                    nhanVien.getSDT(),
                    nhanVien.getEmail(),
                    nhanVien.isGioitinh(),
                    nhanVien.getVaitro(),
                    nhanVien.getNgaysinh(),
                    nhanVien.getDiachi(),
                    nhanVien.getTrangthai(),
                    nhanVien.getHinh()
            );

            return nhanVien.getMaNV();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(NhanVien nhanVien) {
        JDBCHelper.executeUpdate(update,
                    nhanVien.getHoTen(),
                    nhanVien.getMatkhau(),
                    nhanVien.getSDT(),
                    nhanVien.getEmail(),
                    nhanVien.isGioitinh(),
                    nhanVien.getVaitro(),
                    nhanVien.getNgaysinh(),
                    nhanVien.getDiachi(),
                    nhanVien.getTrangthai(),
                    nhanVien.getHinh()
        );
    }

    @Override
    public void deteleByID(Integer id) {
        JDBCHelper.executeUpdate(delete, id);
    }

    private List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
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

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getInt("MaNV"));
        model.setEmail(rs.getString("Email"));
        model.setSDT(rs.getString("SDT"));
        model.setHinh(rs.getString("Hinh"));
        model.setGioitinh(rs.getBoolean("GioiTinh"));
        model.setMatkhau(rs.getString("MatKhau"));
        model.setHoTen(rs.getString("HoTen"));
        model.setVaitro(rs.getInt("VaiTro"));
        model.setNgaysinh(rs.getDate("NgaySinh"));
        model.setDiachi(rs.getString("DiaChi"));
        model.setTrangthai(rs.getBoolean("TrangThai"));
        return model;
    }

    public void forgotpass(int rdpass, String manv) {
        String sql = "UPDATE NhanVien SET MatKhau=? WHERE MaNV=?";
        JDBCHelper.executeUpdate(sql,
                rdpass,
                manv
        );

    }

}
