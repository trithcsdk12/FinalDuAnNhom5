/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EntityDAOImpl;

import com.DAO.SanPhamDAO;
import com.Entity.NhanVien;
import com.Entity.SanPham;
import com.g5.util.JDBCHelper;
import java.sql.ResultSet;
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

    @Override
    public SanPham getByID(Integer maSP) {
        List<SanPham> list = select(selectByID, maSP);
        return list.size() > 0 ? list.get(0) : null;
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
                    sp.getLoaiSP(),
                    sp.getGia(),
                    sp.getGiaSizeLon()
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
                sp.getGia(),
                sp.getGiaSizeLon(),
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
        model.setMaNV(rs.getInt("MaNV"));
        model.setTenSP(rs.getString("TenSP"));
        model.setTrangthai(rs.getBoolean("trangthai"));
        model.setMaNV(rs.getInt("MaNV"));
        model.setMoTa(rs.getString("MoTa"));
        model.setHinh(rs.getString("Hinh"));
        model.setLoaiSP(rs.getString("LoaiSP"));
        model.setGia(rs.getFloat("Gia"));
        model.setGiaSizeLon(rs.getFloat("GiaSizeLon"));
        return model;
    }

}
