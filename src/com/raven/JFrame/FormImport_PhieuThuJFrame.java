/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.JFrame;

import com.qlcnnh.DAO.PhieuThuImportDao;
import com.qlcnnh.Validate.labelValidate;
import com.qlcnnh.entity.PhieuThuImport;
import com.qlcnnh.utils.MsgBox;
import com.qlcnnh.utils.XDate;
import com.raven.form.Form_Phieu_Thu;
import com.raven.form.MainForm;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author T14
 */
public class FormImport_PhieuThuJFrame extends javax.swing.JFrame {

    /**
     * Creates new form FormImport_PhieuThuJFrame
     */
    PhieuThuImportDao daoE = new PhieuThuImportDao() {};
  
       public FormImport_PhieuThuJFrame() {
        initComponents();
//        setLocationRelativeTo(null);
//        setResizable(false);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnUpdate.setEnabled(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\com\\raven\\icon\\shop (6).png");
        this.setIconImage(icon);

    }

    public FormImport_PhieuThuJFrame(int idphieu, String fullname, String address, String date, String lydo, String price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public FormImport_PhieuThuJFrame(int sophieu, String fullname, String date, String lydo, String diachi, String sotien) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public void addEvenUpdate(ActionListener evt) {
        btnUpdate.addActionListener(evt);
    }
              //  formUpdate = new FormImport_PhieuThuJFrame(idphieu, fullname, address, date, lydo, price);

    public FormImport_PhieuThuJFrame(int idphieu,String fullname,  String address, String date,String lydo, double price) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnThem.setEnabled(false);
        btnThem.setVisible(false);

        txtTien.setText(Double.toString(price));
        txtName.setText(fullname);
        txtDate.setText(date);
        txtDiaChi.setText(address);
        txtLyDo.setText(lydo);
        txtSoPhieu.setEditable(false);
        txtTien.setEditable(false);
        dateChooser1.setVisible(false);

        txtDiaChi.setEditable(false);
        txtName.setEditable(false);
        txtLyDo.setEditable(false);
        txtDate.setEditable(false);
        //lblID.setText(idphieu + "");
        txtSoPhieu.setText(Integer.toString(idphieu));

    }

    public void clear() {
        txtSoPhieu.setText("");
        txtName.setText("");
        txtDiaChi.setText("");
        txtLyDo.setText("");
        txtTien.setText("");
        txtDate.setText("");

    }
    public void update() {
        PhieuThuImport e = new PhieuThuImport();
        e.setNameKh(txtName.getText());

        e.setDateCreate(XDate.toDate(txtDate.getText(), "dd-MM-yyyy"));
        e.setAddress(txtDiaChi.getText());
        e.setLyDo(txtLyDo.getText());
        e.setPrice(Double.parseDouble(txtTien.getText()));
       // e.setId(Integer.parseInt(lblID.getText()));
        e.setId(Integer.parseInt(txtSoPhieu.getText()));

        daoE.update(e);
        MsgBox.alert(this, "Cập nhật thành công !!!");
        this.dispose();
    }
     public void insert() {
        try {
            if (labelValidate.checkEmpty(lblName, txtName, "Tên chưa nhập!") == false) {
                return;
            
            } else if (labelValidate.checkEmpty(lblID, txtSoPhieu, "Số phiếu chưa nhập!") == false) {
                return;
            }  
            
            else if (labelValidate.checkNumber(lblPrice, txtTien, "Số tiền chưa nhập!") == false) {
                return;
            
            } else if (labelValidate.checkEmpty(lblLydo, txtLyDo, "Nội dung chưa nhập!") == false) {
                return;
            } else {
                PhieuThuImport e = getFormE();
                daoE.insert(e);
//                Account a = getFormA();
//                daoA.insert(a);
                new MainForm().showForm(new Form_Phieu_Thu());
                MsgBox.alert(this, "Thêm mới thành công..^^..");
                this.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.warring(this, "Thêm mới thất bại!!");
        }
    }
     
      public PhieuThuImport getFormE() {
        PhieuThuImport e = new PhieuThuImport();
        e.setNameKh(txtName.getText());
     
        e.setDateCreate(XDate.toDate(txtDate.getText(), "dd-MM-yyyy"));
        e.setAddress(txtDiaChi.getText());
       
        e.setLyDo(txtLyDo.getText());
        e.setPrice(Double.parseDouble(txtTien.getText()));
//                e.setId(Integer.parseInt(lblID.getText()));
        e.setId(Integer.parseInt(txtSoPhieu.getText()));



        return e;
    }


   public void addEvenFillTable(ActionListener evt) {
        btnUpdate.addActionListener(evt);
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
        jLabel1 = new javax.swing.JLabel();
        btnThem = new com.raven.suportSwing.MyButton();
        btnUpdate = new com.raven.suportSwing.MyButton();
        btnClear = new com.raven.suportSwing.MyButton();
        btnClear1 = new com.raven.suportSwing.MyButton();
        textAreaScroll1 = new com.raven.textarea.TextAreaScroll();
        txtDiaChi = new com.raven.textarea.TextArea();
        txtName = new com.raven.textfield.TextField();
        txtTien = new com.raven.textfield.TextField();
        txtDate = new com.raven.textfield.TextField();
        txtSoPhieu = new com.raven.textfield.TextField();
        txtLyDo = new com.raven.textfield.TextField();
        lblName = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblLydo = new javax.swing.JLabel();

        dateChooser1.setForeground(new java.awt.Color(93, 115, 204));
        dateChooser1.setTextRefernce(txtDate);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Phiếu Thu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Create.png"))); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.setRadius(10);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/edit_1.png"))); // NOI18N
        btnUpdate.setText(" Sửa");
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

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        textAreaScroll1.setViewportView(txtDiaChi);

        txtName.setLabelText("Họ và tên người nộp tiền");
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtTien.setLabelText("Số Tiền");
        txtTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienActionPerformed(evt);
            }
        });

        txtDate.setLabelText("Ngày Phát Sinh");
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        txtSoPhieu.setLabelText("Số Phiếu Thu");
        txtSoPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoPhieuActionPerformed(evt);
            }
        });

        txtLyDo.setLabelText("Lý do thu tiền");
        txtLyDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLyDoActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 51, 51));

        lblID.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 51, 51));

        lblName1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblName1.setForeground(new java.awt.Color(255, 51, 51));

        lblPrice.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(255, 51, 51));

        lblLydo.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblLydo.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(txtSoPhieu, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(460, 460, 460)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLyDo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(431, 431, 431)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(460, 460, 460)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTien, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblLydo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(lblName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(1032, 1032, 1032)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoPhieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(165, 165, 165)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLyDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLydo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(60, 60, 60))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(374, Short.MAX_VALUE)
                    .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(254, 254, 254)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        this.clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        //        this.update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

                this.insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void txtSoPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoPhieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoPhieuActionPerformed

    private void txtLyDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLyDoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLyDoActionPerformed

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
            java.util.logging.Logger.getLogger(FormImport_PhieuThuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormImport_PhieuThuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormImport_PhieuThuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormImport_PhieuThuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormImport_PhieuThuJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.suportSwing.MyButton btnClear;
    private com.raven.suportSwing.MyButton btnClear1;
    private com.raven.suportSwing.MyButton btnThem;
    private com.raven.suportSwing.MyButton btnUpdate;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLydo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblPrice;
    private com.raven.textarea.TextAreaScroll textAreaScroll1;
    private com.raven.textfield.TextField txtDate;
    private com.raven.textarea.TextArea txtDiaChi;
    private com.raven.textfield.TextField txtLyDo;
    private com.raven.textfield.TextField txtName;
    private com.raven.textfield.TextField txtSoPhieu;
    private com.raven.textfield.TextField txtTien;
    // End of variables declaration//GEN-END:variables

    
}
