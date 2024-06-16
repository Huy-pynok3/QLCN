/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.JFrame;

import com.qlcnnh.DAO.AccountDao;
import com.qlcnnh.DAO.PhieuThuImportDao;
import com.qlcnnh.DAO.UserDAO;
import com.qlcnnh.Validate.labelValidate;
import com.qlcnnh.entity.PhieuThuImport;
import com.qlcnnh.utils.MsgBox;
import com.raven.form.Form_Phieu_Chi;
import com.raven.form.MainForm;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author T14
 */
public class FormImport_PhieuChiJFrame extends javax.swing.JFrame {

    /**
     * Creates new form FormImport_PhieuChiJFrame
     */
   // PhieuChiImportDao pcDao = new PhieuChiImportDao();
    
    public FormImport_PhieuChiJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnUpdate.setEnabled(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\com\\raven\\icon\\shop (6).png");
        this.setIconImage(icon);;
    }
    public void addEvenUpdate(ActionListener evt) {
        btnUpdate.addActionListener(evt);
    }
    public FormImport_PhieuChiJFrame(String nameKh, String lydo, String date, String address, int id, float price) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnAddPhieuChi.setEnabled(false);
        btnAddPhieuChi.setVisible(false);
        

        txtNameKh.setText(nameKh);
        txtLydo.setText(lydo);
        txtArea2.setText(address);
        txtDate.setText(date);
        
        txtPrice.setText(Float.toString(price));

        txtArea2.setEditable(false);
        txtNameKh.setEditable(false);
        dateChooser1.setVisible(false);
      
        txtLydo.setEditable(false);
        txtDate.setEditable(false);

     
    }
//    PhieuThuImport emDao = new PhieuThuImport();
//
//    public boolean checkUser(String acc) {
//        for (int i = 0; i < emDao.selectAll().size(); i++) {
//            if (emDao.selectAll().get(i).getUsername().equals(acc.trim())) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean checkEmail(String acc) {
//        for (int i = 0; i < emDao.selectAll().size(); i++) {
//            if (emDao.selectAll().get(i).getEmail().trim().equals(acc.trim())) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean checkPhoneNumber(String acc) {
//        for (int i = 0; i < emDao.selectAll().size(); i++) {
//            if (emDao.selectAll().get(i).getPhoneNumber().trim().equals(acc.trim())) {
//                return true;
//            }
//        }
//        return false;
//    }
    public void insert() {
        try {
            if (labelValidate.checkEmpty(lblName, txtNameKh, "Tên chưa nhập!!!") == false) {
                return;
       //   }
//else if (labelValidate.checkPhoneNumber(lblPhone, txtPhone, "") == false) {
//                return;
//            } else if (checkPhoneNumber(txtPhone.getText()) == true) {
//                MsgBox.labelAlert(lblPhone, txtPhone, "Trùng số điện thoại");
//                return;
            } else if (labelValidate.checkEmpty(lblDate, txtDate, "Ngày chưa nhập!!!") == false) {
                return;
            } //else if (checkDate() == false) {
               // return;
           // } 
//        else if (labelValidate.checkEmpty(lblPrice, txtPrice, "Số tiền chưa nhập!!!") == false) {
//                return;
//            } else if (labelValidate.checkNumber(lblSalary, txtSalary, "Lương không hợp lệ!!!") == false) {
//                return;
//            } else if (labelValidate.checkEmail(lblEmail, txtEmail, "") == false) {
//                return;
//            } else if (checkEmail(txtEmail.getText()) == true) {
//                MsgBox.labelAlert(lblEmail, txtEmail, "Trùng email");
//                return;
//            } else if (labelValidate.checkEmpty(lblUser, txtUsername, "Tài khoản chưa nhập!!!") == false) {
//                return;
//            } else if (checkUser(txtUsername.getText()) == true) {
//                MsgBox.labelAlert(lblUser, txtUsername, "Trùng user");
//                return;
//            } else if (labelValidate.checkEmpty(lblPass, txtPassWord, "Mật khẩu chưa nhập!!!") == false) {
//                return;
//            }
        else {
//                User e = getFormE();
//                daoE.insert(e);
//                Account a = getFormA();
//                daoA.insert(a);
                new MainForm().showForm(new Form_Phieu_Chi());
                MsgBox.alert(this, "Thêm mới thành công..^^..");
                this.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.warring(this, "Thêm mới thất bại!!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSoPhieu = new com.raven.textfield.TextField();
        txtNameKh = new com.raven.textfield.TextField();
        textAreaScroll1 = new com.raven.textarea.TextAreaScroll();
        txtArea2 = new com.raven.textarea.TextArea();
        textArea3 = new com.raven.textarea.TextArea();
        txtDate = new com.raven.textfield.TextField();
        txtLydo = new com.raven.textfield.TextField();
        txtPrice = new com.raven.textfield.TextField();
        btnAddPhieuChi = new com.raven.suportSwing.MyButton();
        btnUpdate = new com.raven.suportSwing.MyButton();
        btnClear = new com.raven.suportSwing.MyButton();
        btnClear1 = new com.raven.suportSwing.MyButton();
        lblName = new javax.swing.JLabel();
        lblSoPhieu = new javax.swing.JLabel();
        lblLydo = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();

        dateChooser1.setForeground(new java.awt.Color(93, 106, 204));
        dateChooser1.setTextRefernce(txtDate);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Phiếu Chi");

        txtSoPhieu.setLabelText("Số Phiếu Thu");

        txtNameKh.setLabelText("Họ và tên người chi tiền");
        txtNameKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameKhActionPerformed(evt);
            }
        });

        txtArea2.setColumns(20);
        txtArea2.setRows(5);
        textAreaScroll1.setViewportView(txtArea2);

        textArea3.setColumns(20);
        textArea3.setRows(5);

        txtDate.setLabelText("Ngày Phát Sinh");
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        txtLydo.setLabelText("Lý do chi tiền");
        txtLydo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLydoActionPerformed(evt);
            }
        });

        txtPrice.setLabelText("Số Tiền");
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        btnAddPhieuChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Create.png"))); // NOI18N
        btnAddPhieuChi.setText("Thêm ");
        btnAddPhieuChi.setRadius(10);
        btnAddPhieuChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPhieuChiActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/edit_1.png"))); // NOI18N
        btnUpdate.setText("  Sửa");
        btnUpdate.setRadius(10);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Refresh.png"))); // NOI18N
        btnClear.setText("Làm mới");
        btnClear.setRadius(10);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnClear1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/x.png"))); // NOI18N
        btnClear1.setText("Huỷ");
        btnClear1.setRadius(10);
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 51, 51));

        lblSoPhieu.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblSoPhieu.setForeground(new java.awt.Color(255, 51, 51));

        lblLydo.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblLydo.setForeground(new java.awt.Color(255, 51, 51));

        lblDate.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 51, 51));

        lblPrice.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtNameKh, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(textArea3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblSoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtSoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(12, 12, 12)))
                                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtLydo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnAddPhieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblLydo, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47)
                .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(822, Short.MAX_VALUE)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(324, 324, 324)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNameKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLydo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLydo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(textArea3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddPhieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(232, 232, 232))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(186, 186, 186)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(634, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameKhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameKhActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void txtLydoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLydoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLydoActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void btnAddPhieuChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPhieuChiActionPerformed

        //        this.insert();
    }//GEN-LAST:event_btnAddPhieuChiActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        //        this.update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
      //  this.clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnClear1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormImport_PhieuChiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormImport_PhieuChiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormImport_PhieuChiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormImport_PhieuChiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormImport_PhieuChiJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.suportSwing.MyButton btnAddPhieuChi;
    private com.raven.suportSwing.MyButton btnClear;
    private com.raven.suportSwing.MyButton btnClear1;
    private com.raven.suportSwing.MyButton btnUpdate;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblLydo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSoPhieu;
    private com.raven.textarea.TextArea textArea3;
    private com.raven.textarea.TextAreaScroll textAreaScroll1;
    private com.raven.textarea.TextArea txtArea2;
    private com.raven.textfield.TextField txtDate;
    private com.raven.textfield.TextField txtLydo;
    private com.raven.textfield.TextField txtNameKh;
    private com.raven.textfield.TextField txtPrice;
    private com.raven.textfield.TextField txtSoPhieu;
    // End of variables declaration//GEN-END:variables
}
