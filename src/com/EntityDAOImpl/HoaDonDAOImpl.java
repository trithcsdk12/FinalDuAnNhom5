/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EntityDAOImpl;

import com.DAO.HoaDonDAO;
import com.Entity.HoaDon;
import com.Entity.NhanVien;
import com.Utils.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class HoaDonDAOImpl implements HoaDonDAO {

    String selectByID = "select * from HoaDon where maHD = ?";
    String selectAll = "select * from HoaDon";
    String insert = "insert into HoaDon (NgayTao,MaNV,TienKhach,TongTien,DiaChi,TrangThai) "
            + "values (?,?,?,?,?,?)";
    String update = "Update HoaDon set NgayTao=?,MaNV=?, TienKhach=?, TongTien=?, DiaChi=?, TrangThai=? where MaSP =?";
    String delete = "Delete from HoaDon where MaHD = ?";

    @Override
    public HoaDon getByID(Integer id) {
        List<HoaDon> list = select(selectByID, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<HoaDon> getAll() {
        return select(selectAll);
    }

    @Override
    public Integer create(HoaDon hd) {
        try {
            JDBCHelper.executeUpdate(insert,
                    hd.getNgayTao(),
                    hd.getMaNV(),
                    hd.getTienKhachTra(),
                    hd.getTongTien(),
                    hd.getDiaChi(),
                    hd.isTrangthai()
            );

            return hd.getMaHD();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(HoaDon hd) {
        JDBCHelper.executeUpdate(update,
                hd.getNgayTao(),
                hd.getMaNV(),
                hd.getTienKhachTra(),
                hd.getTongTien(),
                hd.getDiaChi(),
                hd.isTrangthai(),
                hd.getMaHD());
    }

    @Override
    public void deteleByID(Integer id) {
        JDBCHelper.executeUpdate(delete, id);
    }

    private List<HoaDon> select(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDon model = readFromResultSet(rs);
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

    private HoaDon readFromResultSet(ResultSet rs) throws SQLException {
        HoaDon model = new HoaDon();
        model.setMaHD(rs.getInt("MaNV"));
        model.setNgayTao(rs.getDate("NgayTao"));
        model.setMaNV(rs.getInt("MaNV"));
        model.setTienKhachTra(rs.getFloat("TienKhach"));
        model.setTongTien(rs.getFloat("TongTien"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setTrangthai(rs.getBoolean("TrangThai"));
        return model;
    }

}
