
package com.qlcnnh.DAO;

/**
 *
 * @author T14
 */
import com.qlcnnh.entity.User;
import com.qlcnnh.helper.jdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class UserDAO extends Dao<User, String> {
    // Câu lệnh sql để thêm mới một người dùng
    private String INSERT_SQL_USER = "INSERT dbo.[User](name, birthday, gender, phoneNumber, address, salary, email, role, status) VALUES(?,?,?,?,?,?,?,?, ?)";
     // Câu lệnh SQL để cập nhật thông tin người dùng
    private String UPDATE_SQL = "UPDATE dbo.[User] SET name = ?, role = ?, gender = ?, birthday = ?, address = ?, phoneNumber = ?, email = ?, salary = ?, status = ? WHERE idUser = ?";
   // Câu lệnh sql xóa
    private String DELETE_SQL = "UPDATE dbo.[User] SET status = 0 WHERE idUser = ?";
    private String SELECT_ALL_SQL = "SELECT * FROM dbo.[User] where status = 1";
    private String SELECT_ALL_OFF = "SELECT * FROM dbo.[User] where status = 0";

//    private String SELECT_BY_ID = "";
     // Câu lệnh sql để tìm người dùng theo từ khóa trong tên
    private String SELECT_BY_KEY = "SELECT * FROM dbo.[USER] WHERE name LIKE ? ";

    @Override
    public void insert(User e) {
         // Thực hiện câu lệnh SQL để thêm mới người dùng
        jdbcHelper.update(INSERT_SQL_USER, e.getFullname(), e.getDateOfBirth(), e.isGender(), e.getPhoneNumber(), e.getAdress(),
                e.getSalary(), e.getEmail(), e.isRole(), e.isStatus());
    }

    @Override
    public void update(User e) {
        jdbcHelper.update(UPDATE_SQL, e.getFullname(), e.isRole(), e.isGender(), e.getDateOfBirth(), e.getAdress(), e.getPhoneNumber(),
                e.getEmail(), e.getSalary(), e.isStatus(), e.getIdUser());
    }

    @Override
    public void delete(String k) {
        jdbcHelper.update(DELETE_SQL, k);
    }

    public void delete(int k) {
        jdbcHelper.update(DELETE_SQL, k);
    }

    @Override
    public List<User> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    public List<User> selectAllOFF() {
        return this.selectBySql(SELECT_ALL_OFF);
    }

    @Override
    public User selectById(String k) {
        String sql = "select * from User where idUser = ?";
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public User selectById(int k) {
        String sql = "SELECT * FROM dbo.[User] WHERE idUser = ?";
        List<User> list = selectBySql(sql, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<User> selectBySql(String sql, Object... args) {
        List<User> listE = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                User e = new User();
                e.setIdUser(rs.getInt("idUser"));
                e.setFullname(rs.getString("name"));
                e.setDateOfBirth(rs.getDate("birthday"));
                e.setGender(rs.getBoolean("gender"));
                e.setPhoneNumber(rs.getString("phoneNumber"));
                e.setAdress(rs.getString("address"));
                e.setSalary(rs.getDouble("salary"));
                e.setEmail(rs.getString("email"));
                e.setRole(rs.getBoolean("role"));
                e.setStatus(rs.getBoolean("status"));
                listE.add(e);
            }
            rs.getStatement().getConnection().close();
            return listE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> selectByKey(String k) {
        return selectBySql(SELECT_BY_KEY, "%" + k + "%");
    }
}
