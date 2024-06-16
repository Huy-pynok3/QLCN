
package com.qlcnnh.DAO;

import com.qlcnnh.entity.KyHanSTK;
import com.qlcnnh.helper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T14
 */
 
public class KyHanSTKDao extends Dao<KyHanSTK, Integer>{

    @Override
    public void insert(KyHanSTK e) {
        String sql = "INSERT dbo.KyHan(valueKyHan) values(?)";
        jdbcHelper.update(sql, e.getValueKyHan());
    }

    @Override
    public void update(KyHanSTK e) {
        String sql = "update dbo.KyHan set valueKyHan = ? where idKyHan = ?";
        jdbcHelper.update(sql, e.getIdKyHan(),e.getValueKyHan());
    }

    @Override
    public void delete(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<KyHanSTK> selectAll() {
        String sql = "SELECT * FROM dbo.KyHan";
        return selectBySql(sql);
    }

    @Override
    public KyHanSTK selectById(Integer k) {
        String sql = "SELECT * FROM dbo.KyHan where idKyHan = ?";
        List<KyHanSTK> list = selectBySql(sql, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KyHanSTK> selectBySql(String sql, Object... args) {
        List<KyHanSTK> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                KyHanSTK c = new KyHanSTK();
                c.setIdKyHan(rs.getInt("idKyHan"));
                c.setValueKyHan(rs.getString("valueKyHan"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public KyHanSTK selectByName(String name) {
        String sql = "select * FROM dbo.KyHan where valueKyHan = ?";
        List<KyHanSTK> list = selectBySql(sql, name);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
}
