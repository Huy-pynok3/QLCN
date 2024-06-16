
package com.raven.form;


import com.qlcnnh.DAO.PhieuThuImportDao;
import com.qlcnnh.entity.PhieuThuImport;
import com.qlcnnh.utils.XDate;
import com.raven.JFrame.FormImport_PhieuThuJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author T14
 */
public class Form_Phieu_Thu extends javax.swing.JPanel {

    /**
     * Creates new form Form_Phieu_Thu
     */
    PhieuThuImportDao phieuThuImport = new PhieuThuImportDao() {} ;
    FormImport_PhieuThuJFrame formImport_PhieuThuJFrame = new FormImport_PhieuThuJFrame();
    FormImport_PhieuThuJFrame formUpdate;

    public Form_Phieu_Thu() {
        initComponents();
        setOpaque(false);
         fillTable();
           formImport_PhieuThuJFrame.addEvenFillTable(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formImport_PhieuThuJFrame.insert();
                fillTable();
            }
        });

    }
    public String deleteLastKey(String str) {
        if (str.charAt(str.length() - 1) == 'đ') {
            str = str.replace(str.substring(str.length() - 1), "");
            return str;
        } else {
            return str;
        }
    }
    public String fomartDouble(String txt) {
        String pattern = deleteLastKey(txt);
        return pattern = pattern.replaceAll(",", "");
    }
    
    Locale lc = new Locale("nv", "VN");
    NumberFormat nf = NumberFormat.getInstance(lc);
    
      public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tablePhieuThu.getModel();
        model.setRowCount(0);
        List<PhieuThuImport> list = phieuThuImport.selectAll();
        for (PhieuThuImport u : list) {
            model.addRow(new Object[]{
                u.getId(), u.getNameKh(), u.getAddress(),
                XDate.toString(u.getDateCreate(), "dd-MM-yyyy"), u.getLyDo(),nf.format(u.getPrice()) + " đ"
            });
        }
        System.out.println("Hello");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        myButton5 = new com.raven.suportSwing.MyButton();
        txtSearch = new com.raven.suportSwing.TextField();
        myButton6 = new com.raven.suportSwing.MyButton();
        myButton8 = new com.raven.suportSwing.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePhieuThu = new com.raven.suportSwing.TableColumn();
        scrollBarCustom1 = new com.raven.suportSwing.ScrollBarCustom();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(246, 112, 112));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PHIẾU THU");

        myButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Search.png"))); // NOI18N
        myButton5.setText("  Tìm");
        myButton5.setRadius(20);
        myButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton5ActionPerformed(evt);
            }
        });

        txtSearch.setLabelText("Tìm theo số phiếu hoặc tên khách hàng");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        myButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Create.png"))); // NOI18N
        myButton6.setText("Thêm Phiếu Thu");
        myButton6.setRadius(20);
        myButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myButton6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                myButton6MouseEntered(evt);
            }
        });
        myButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton6ActionPerformed(evt);
            }
        });

        myButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/delete.png"))); // NOI18N
        myButton8.setText("Xóa Phiếu Thu");
        myButton8.setRadius(20);
        myButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton8ActionPerformed(evt);
            }
        });

        tablePhieuThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số Phiếu Thu", "Tên Khách Hàng", "Địa Chỉ", "Ngày Phát Sinh", "Lý do", "Số Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePhieuThu.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tablePhieuThuAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tablePhieuThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePhieuThuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePhieuThu);
        if (tablePhieuThu.getColumnModel().getColumnCount() > 0) {
            tablePhieuThu.getColumnModel().getColumn(0).setResizable(false);
            tablePhieuThu.getColumnModel().getColumn(1).setResizable(false);
            tablePhieuThu.getColumnModel().getColumn(2).setResizable(false);
            tablePhieuThu.getColumnModel().getColumn(3).setResizable(false);
            tablePhieuThu.getColumnModel().getColumn(4).setResizable(false);
            tablePhieuThu.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addGap(458, 458, 458))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(myButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(myButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(myButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void myButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton5ActionPerformed
        // TODO add your handling code here:
        try {
          //  fillSearchID();
        } catch (Exception e) {
         //   fillSearch();
        }
    }//GEN-LAST:event_myButton5ActionPerformed

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    //    fillSearch();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void myButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton6MouseClicked

    private void myButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton6MouseEntered

    private void myButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton6ActionPerformed
        // TODO add your handling code here:
       formImport_PhieuThuJFrame.setVisible(true);
    }//GEN-LAST:event_myButton6ActionPerformed

    private void myButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton8ActionPerformed
        // TODO add your handling code here:
       // delete();
    }//GEN-LAST:event_myButton8ActionPerformed

    private void tablePhieuThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePhieuThuMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int index = tablePhieuThu.getSelectedRow();
            int idphieu = (int) tablePhieuThu.getValueAt(index, 0);
            String fullname = tablePhieuThu.getValueAt(index, 1).toString();
            String address = tablePhieuThu.getValueAt(index, 2).toString();
            String date = tablePhieuThu.getValueAt(index, 3).toString();
            String lydo = tablePhieuThu.getValueAt(index, 4).toString();
            //    String price = tablePhieuThu.getValueAt(index, 5).toString();
            Double price = Double.parseDouble(fomartDouble((String) tablePhieuThu.getValueAt(tablePhieuThu.getSelectedRow(), 5)));

            formUpdate = new FormImport_PhieuThuJFrame(idphieu, fullname, address, date, lydo, price);
            formUpdate.setVisible(true);
        }
        if (formUpdate == null) {
            return;
        } else {
            formUpdate.addEvenUpdate(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    formUpdate.update();
//                    MsgBox.alert(this, "Update thành công");
                    fillTable();

                }
            });

        }


    }//GEN-LAST:event_tablePhieuThuMouseClicked

    private void tablePhieuThuAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tablePhieuThuAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tablePhieuThuAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.suportSwing.MyButton myButton5;
    private com.raven.suportSwing.MyButton myButton6;
    private com.raven.suportSwing.MyButton myButton8;
    private com.raven.suportSwing.ScrollBarCustom scrollBarCustom1;
    private com.raven.suportSwing.TableColumn tablePhieuThu;
    private com.raven.suportSwing.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
