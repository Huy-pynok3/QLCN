package com.qlcnnh.DAO;

import com.qlcnnh.entity.Customer;
import com.qlcnnh.entity.SoTietKiemImport;
import com.qlcnnh.helper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author T14
 */
public abstract class SoTietKiemImportDao extends Dao<SoTietKiemImport, String> {
    //câu lệnh sql thêm sổ tiết kiệm
    String INSERT_SQL = "INSERT INTO SoTietKiem ( chiNhanh,  kyHan,  maKh,  tenKh,  cccd,  soTk,  soTien,  laiSuat,  ngayMoSo,address) VALUES (?, ?, ?, ?,?,?,?,?,?,?)";
    String SELECT_ALL_SQL = "SELECT * FROM SoTietKiem ORDER BY id Desc";
    String SELECT_BY_ID_SQL = "SELECT * FROM SoTietKiem WHERE id=?";
    String DELETE_SQL = "DELETE FROM SoTietKiem WHERE id=?";
    private String SELECT_BY_ID = "";
    // câu lệnh sql sửa thông tin sổ tiết kiệm
    String UPDATE_SQL = "UPDATE SoTietKiem SET chiNhanh=?, kyHan=?, maKh=?, tenKh=?, cccd=? ,soTk=?, soTien=?, laiSuat=?, ngayMoSo=?, address=? WHERE id=?";

    @Override
    public void insert(SoTietKiemImport e) {
        //Thực hiện câu lệnh sql thêm thông tin sổ tiết kiệm
        jdbcHelper.update(INSERT_SQL, e.getChiNhanh(), e.getKyHan(), e.getMaKh(), e.getTenKh(), e.getCccd(), e.getSoTk(), e.getSoTien(), e.getLaiSuat(), e.getNgayMoSo(),  e.getAddress());
    }

    @Override
    public void update(SoTietKiemImport e) {
        jdbcHelper.update(UPDATE_SQL,e.getChiNhanh(), e.getKyHan(), e.getMaKh(), e.getTenKh(), e.getCccd(), e.getSoTk(), e.getSoTien(), e.getLaiSuat(), e.getNgayMoSo(),  e.getAddress(),e.getId());

    }

    public void delete(Integer k) {
        jdbcHelper.update(DELETE_SQL, k);
        
        List<SoTietKiemImport> list = selectAll();
        Collections.sort(list, (o1, o2) -> o1.getId() - o2.getId()); // Sắp xếp lại danh sách theo ID
    }

    @Override
    public List<SoTietKiemImport> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    public SoTietKiemImport selectById(Integer k) {
        List<SoTietKiemImport> list = selectBySql(SELECT_BY_ID_SQL, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public SoTietKiemImport selectById(String k) {
        String sql = "select * from SoTietKiem where id = ?";
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public SoTietKiemImport selectById(int k) {
        String sql = "SELECT * FROM dbo.[SoTietKiem] WHERE id = ?";
        List<SoTietKiemImport> list = selectBySql(sql, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<SoTietKiemImport> selectBySql(String sql, Object... args) {
        List<SoTietKiemImport> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                SoTietKiemImport c = new SoTietKiemImport();
                c.setId(rs.getInt("id"));
                c.setChiNhanh(rs.getString("chiNhanh"));
                c.setKyHan(rs.getString("kyHan"));
                c.setMaKh(rs.getString("maKh"));
                c.setTenKh(rs.getString("tenKh"));
                c.setCccd(rs.getString("cccd"));
                c.setSoTk(rs.getString("soTk"));
                c.setSoTien(rs.getDouble("soTien"));
                c.setLaiSuat(rs.getInt("laiSuat"));
                c.setNgayMoSo(rs.getDate("ngayMoSo"));
                c.setAddress(rs.getString("address"));

                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void delete(String k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<SoTietKiemImport> selectByKeyWord(String keyword) {
        String sql = "SELECT * from SoTietKiem where tenKh LIKE ? ORDER BY id Desc";
        return selectBySql(sql, "%" + keyword + "%");
    }

}
