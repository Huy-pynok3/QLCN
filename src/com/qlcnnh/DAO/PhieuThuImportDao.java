
package com.qlcnnh.DAO;

import com.qlcnnh.helper.jdbcHelper;
import com.qlcnnh.entity.PhieuThuImport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author T14
 */

public abstract class PhieuThuImportDao extends Dao<PhieuThuImport, String> {

    String INSERT_SQL = "INSERT INTO PhieuThu ( nameKh, address, dateCreate, lyDo, price) VALUES (?, ?, ?, ?,?)";
    String SELECT_ALL_SQL = "SELECT * FROM PhieuThu ORDER BY id Desc";
    String SELECT_BY_ID_SQL = "SELECT * FROM PhieuThu WHERE id=?";
    String DELETE_SQL = "DELETE FROM PhieuThu WHERE id=?";
    private String SELECT_BY_ID = "";
    String UPDATE_SQL = "UPDATE PhieuThu SET nameKh=?, address=?, dateCreate=?, lyDo=?, price=? WHERE id=?";


    @Override
    public void insert(PhieuThuImport e) {
        jdbcHelper.update(INSERT_SQL,e.getNameKh(), e.getAddress(), e.getDateCreate(),  e.getLyDo(), e.getPrice());
    }

    @Override
    public void update(PhieuThuImport e) {
        jdbcHelper.update(INSERT_SQL,e.getNameKh(), e.getAddress(), e.getDateCreate(),  e.getLyDo(), e.getPrice());

    }
    public void delete(Integer k) {
        jdbcHelper.update(DELETE_SQL, k);
    }

    @Override
    public List<PhieuThuImport> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    public PhieuThuImport selectById(Integer k) {
        List<PhieuThuImport> list = selectBySql(SELECT_BY_ID_SQL, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    @Override
    public PhieuThuImport selectById(String k) {
        String sql = "select * from PhieuThu where id = ?";
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public PhieuThuImport selectById(int k) {
        String sql = "SELECT * FROM dbo.[PhieuThu] WHERE id = ?";
        List<PhieuThuImport> list = selectBySql(sql, k);
        if (list.isEmpty()) {
            return null;
        }
            return list.get(0);
    }
      

    @Override
    protected List<PhieuThuImport> selectBySql(String sql, Object... args) {
        List<PhieuThuImport> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                PhieuThuImport c = new PhieuThuImport();
                c.setId(rs.getInt("id"));
                c.setNameKh(rs.getString("nameKh"));
                c.setAddress(rs.getString("address"));
                c.setDateCreate(rs.getDate("dateCreate"));
                c.setLyDo(rs.getString("lyDo"));
                c.setPrice(rs.getDouble("price"));

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

    

}

