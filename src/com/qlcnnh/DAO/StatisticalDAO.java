package com.qlcnnh.DAO;

import com.qlcnnh.helper.jdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T14
 */
public class StatisticalDAO {

    List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Object[]> getQuantityBuy() {

        String sql = "SELECT name, "
                + "CASE WHEN gender = 1 THEN 'Nam' ELSE 'Nữ' END AS gender, "
                + "phoneNumber, address "
                + "FROM dbo.Customer";
        String[] cols = {"name", "gender", "phoneNumber", "address"};
        return getListOfArray(sql, cols);
    }

    public int getSumCustomer() {
        ResultSet rs;
        String sql = "SELECT COUNT(idCustomer) SumCustomer FROM dbo.Customer ";
        try {
            rs = jdbcHelper.query(sql);
            while (rs.next()) {
                return rs.getInt("SumCustomer");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getSumSaving() {
        ResultSet rs;
        String sql = "SELECT COUNT(id) SumSaving FROM dbo.SoTietKiem ";
        try {
            rs = jdbcHelper.query(sql);
            while (rs.next()) {
                return rs.getInt("SumSaving");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
