package com.raven.main;

import com.qlcnnh.DAO.AccountDao;
import com.qlcnnh.DAO.UserDAO;
import com.qlcnnh.Validate.Validate;
import com.qlcnnh.entity.Account;
import com.qlcnnh.entity.User;
import com.qlcnnh.utils.Auth;
import com.qlcnnh.utils.MsgBox;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author T14
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public Login() {
        initComponents();
        lbAlertPassword.setText("");
        lbAlertUsername.setText("");
        setLocationRelativeTo(null);
        setResizable(false);
        new Loading(this, true).setVisible(true);
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\com\\raven\\icon\\bankload.png");
        this.setIconImage(icon);
    }

    AccountDao dao = new AccountDao();
// Phương thức xử lý sự kiện khi nhấn nút đăng nhập
    public void clickLogin() {
        txtUser.setBackground(Color.white);
        txtPassWord.setBackground(Color.white);
        // Kiểm tra tính hợp lệ của tên đăng nhập và mật khẩu
        if (Validate.checkEmpty(lbAlertUsername, txtUser, "Không được để trống Username!") == false &&
            Validate.checkEmpty(lbAlertPassword, txtPassWord, "Không được để trống password!") == false) {
            return;// Nếu cả hai trường đều không hợp lệ, dừng lại
        } else if (Validate.checkEmpty(lbAlertUsername, txtUser, "Không được để trống username!") == false) {
            return;
        } else if (Validate.checkEmpty(lbAlertPassword, txtPassWord, "Không được để trống password!") == false) {
            return;
        } else {
            login();// Nếu cả hai trường đều không hợp lệ, dừng lại
        }
    }
// Phương thức xử lý đăng nhập
    public boolean login() {
        String userName = txtUser.getText();// Lấy tên đăng nhập từ ô nhập liệu
        String passWord = new String(txtPassWord.getPassword());// Lấy mật khẩu từ ô nhập liệu
        UserDAO uDao = new UserDAO();// Khởi tạo đối tượng uDAO để làm việc với UserDao
        try {
            Account account = dao.selectById(userName);// Tìm kiếm tài khoản theo tên đăng nhập
            if (account == null) {    // Nếu không tìm thấy tài khoản hoặc sai
                lbAlertUsername.setText("Sai tên đăng nhập!");// Hiển thị thông báo lỗi tên đăng nhập
                return false;// Đăng nhập thất bại
            } else {
                String passwordSystem = account.getPassWord();// Lấy mật khẩu từ hệ thống
                if (passWord.equals(passwordSystem)) {// So sánh mật khẩu nhập vào với mật khẩu hệ thống
                    MsgBox.alert(this, "Đăng nhập thành công!");
                    User user = uDao.selectById(account.getIdUser()); // Lấy thông tin người dùng theo tài khoản
                    Auth.user = user;// Lưu thông tin người dùng 
                    new Main().setVisible(true);// Hiển thị cửa sổ chính 
                    this.setVisible(false);
                    return true;
                } else {
                    lbAlertPassword.setText("Sai mật khẩu!");
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
        return true;
    }

    public void addEventLogin(ActionListener event) {
        btnLogin.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        disable = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();
        txtUser = new com.raven.suportSwing.TextField();
        lbAlertUsername = new javax.swing.JLabel();
        txtPassWord = new com.raven.suportSwing.PasswordField();
        lbAlertPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/bg-login.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 510, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 440));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 0, 39, 39));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Login");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 57, 410, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Hello! Let's get stared");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 113, 410, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8_user_20px_1.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 40, 37));

        disable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8_invisible_20px_1.png"))); // NOI18N
        disable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disableMouseClicked(evt);
            }
        });
        jPanel2.add(disable, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 40, 37));

        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8_eye_20px_1.png"))); // NOI18N
        show.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel2.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 40, 37));

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(199, 226, 255));
        jCheckBox1.setText("Remember password");
        jCheckBox1.setOpaque(false);
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 318, 168, -1));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(25, 118, 211));
        btnLogin.setText("LOGIN");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 348, 338, -1));

        txtUser.setText("admin");
        txtUser.setLabelText("Usename");
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFocusGained(evt);
            }
        });
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        jPanel2.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 310, 40));

        lbAlertUsername.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lbAlertUsername.setForeground(new java.awt.Color(255, 51, 0));
        lbAlertUsername.setText("jLabel1");
        jPanel2.add(lbAlertUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 320, 20));

        txtPassWord.setText("123456");
        txtPassWord.setLabelText("Password");
        txtPassWord.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassWordFocusGained(evt);
            }
        });
        txtPassWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassWordActionPerformed(evt);
            }
        });
        jPanel2.add(txtPassWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 310, -1));

        lbAlertPassword.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lbAlertPassword.setForeground(new java.awt.Color(255, 51, 0));
        lbAlertPassword.setText("jLabel1");
        jPanel2.add(lbAlertPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 310, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 410, 440));

        setSize(new java.awt.Dimension(920, 435));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        clickLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void disableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disableMouseClicked
        // TODO add your handling code here:
        txtPassWord.setEchoChar((char) 0);
        disable.setVisible(false);
        disable.setEnabled(false);
        show.setEnabled(true);
        show.setEnabled(true);
    }//GEN-LAST:event_disableMouseClicked

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        // TODO add your handling code here:
        txtPassWord.setEchoChar((char) 8226);
        disable.setVisible(true);
        disable.setEnabled(true);
        show.setEnabled(false);
        show.setEnabled(false);
    }//GEN-LAST:event_showMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusGained
        lbAlertUsername.setText("");
    }//GEN-LAST:event_txtUserFocusGained

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPassWordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassWordFocusGained
        lbAlertPassword.setText("");
    }//GEN-LAST:event_txtPassWordFocusGained

    private void txtPassWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassWordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassWordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
//        </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel disable;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbAlertPassword;
    private javax.swing.JLabel lbAlertUsername;
    private javax.swing.JLabel show;
    private com.raven.suportSwing.PasswordField txtPassWord;
    private com.raven.suportSwing.TextField txtUser;
    // End of variables declaration//GEN-END:variables
}
