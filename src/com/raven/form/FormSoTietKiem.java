/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.qlcnnh.DAO.CustomerDAO;
import com.qlcnnh.DAO.SoTietKiemImportDao;
import com.qlcnnh.Validate.Validate;
import com.qlcnnh.entity.Customer;
import com.qlcnnh.entity.SoTietKiemImport;
import com.qlcnnh.utils.MsgBox;
import com.qlcnnh.utils.XDate;
import com.raven.JFrame.FormImportSoTietKiemJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author T14
 */
public class FormSoTietKiem extends javax.swing.JPanel {

    /**
     * Creates new form FormSoTietKiem
     */
    SoTietKiemImportDao soTietKiemImport = new SoTietKiemImportDao() {
    };
    FormImportSoTietKiemJFrame formImportSoTietKiemJFrame = new FormImportSoTietKiemJFrame();
    FormImportSoTietKiemJFrame formUpdate;

    public FormSoTietKiem() {
        initComponents();
        setOpaque(false);
        fillTable();
        formImportSoTietKiemJFrame.addEvenFillTable(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formImportSoTietKiemJFrame.insert();
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
        DefaultTableModel model = (DefaultTableModel) tableSoTietKiem.getModel();
        model.setRowCount(0);
        List<SoTietKiemImport> list = soTietKiemImport.selectAll();
        for (SoTietKiemImport u : list) {
            model.addRow(new Object[]{
                u.getId(), u.getChiNhanh(), u.getKyHan(), u.getMaKh(), u.getTenKh(), u.getCccd(), u.getSoTk(),nf.format(u.getSoTien()) + " đ", u.getLaiSuat(),
                XDate.toString(u.getNgayMoSo(), "dd-MM-yyyy"), u.getAddress()
            });
        }
//        System.out.println("Hello");
    }


    
    // Phương thức này được sử dụng để tìm kiếm và điền thông tin của một sổ tiết kiệm
    //vào bảng tableSoTietKiem
    public void fillSearchID() {
        // Lấy mô hình của bảng tableSoTietKiem
        DefaultTableModel model = (DefaultTableModel) tableSoTietKiem.getModel();
        // Xóa toàn bộ dữ liệu hiện có trên bảng để chuẩn bị cho việc điền dữ liệu mới
        model.setRowCount(0);
        // Lấy giá trị của trường văn bản txtSearch và chuyển đổi thành một số nguyên
        int keyString = Integer.valueOf(txtSearch.getText());
        // Truy vấn và lấy thông tin của sổ tiết kiệm dựa trên ID nhập vào
        SoTietKiemImport u = soTietKiemImport.selectById(keyString);
        // Kiểm tra nếu không có sổ tiết kiệm nào được tìm thấy với ID đã nhập
        if (u == null) {
            // Hiển thị thông báo lỗi trên nhãn lblSearch và kết thúc phương thức
            lblSearch.setText("Không có sổ tiết kiệm " + keyString);
            return;
        }
        // Nếu tìm thấy sổ tiết kiệm, thêm thông tin của nó vào bảng tableSoTietKiem
        model.addRow(new Object[]{
            u.getId(), u.getChiNhanh(), u.getKyHan(), u.getMaKh(), u.getTenKh(),
            u.getCccd(), u.getSoTk(), nf.format(u.getSoTien()) + " đ", u.getLaiSuat(),
            XDate.toString(u.getNgayMoSo(), "dd-MM-yyyy"), u.getAddress()
        });
        // Xóa bất kỳ thông báo nào hiển thị trên nhãn lblSearch, nếu có
        lblSearch.setText("");
    }

   // Tạo một đối tượng CustomerDAO để tương tác với cơ sở dữ liệu
    SoTietKiemImportDao cDao = new SoTietKiemImportDao() {};


    // Phương thức để điền dữ liệu vào bảng khi tìm kiếm
    public void fillTableWhenFind() {
        DefaultTableModel model = (DefaultTableModel) tableSoTietKiem.getModel();
        model.setRowCount(0);  // Xóa tất cả các hàng hiện tại trong bảng
        String keyString = txtSearch.getText();  // Lấy từ khóa tìm kiếm từ trường văn bản
        List<SoTietKiemImport> list = cDao.selectByKeyWord(keyString);  // Tìm kiếm tên khách hàng 
        if (list.isEmpty()) {
              lblSearch.setText("Không có khách hàng " + keyString);  // Hiển thị thông báo nếu không tìm thấy khách hàng
            return;
        }
        for (SoTietKiemImport u : list) {
            model.addRow(new Object[]{
               u.getId(), u.getChiNhanh(), u.getKyHan(), u.getMaKh(), u.getTenKh(),
            u.getCccd(), u.getSoTk(), nf.format(u.getSoTien()) + " đ", u.getLaiSuat(),
            XDate.toString(u.getNgayMoSo(), "dd-MM-yyyy"), u.getAddress()
            });  // Thêm từng hàng vào mô hình bảng
        }
         lblSearch.setText("");  // Xóa thông báo tìm kiếm
    }
    public void delete() {
        int row = tableSoTietKiem.getSelectedRow();
        //    // Kiểm tra nếu không có dòng nào được chọn
        if (row == -1) {
            MsgBox.warring(this, "Vui lòng chọn một dòng để xóa.");
            return;
        }
        int id = (int) tableSoTietKiem.getValueAt(row, 0);
        if (MsgBox.confirm(this, "Bạn có muốn xóa không?")) {
            try {
                soTietKiemImport.delete(id);
                fillTable();
                clear();
                MsgBox.alert(this, "Xoá Thành công");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
public void addEvenFillTable(ActionListener evt) {
        fillTable();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new com.raven.suportSwing.TextField();
        myButton5 = new com.raven.suportSwing.MyButton();
        myButton6 = new com.raven.suportSwing.MyButton();
        myButton8 = new com.raven.suportSwing.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSoTietKiem = new com.raven.suportSwing.TableColumn();
        scrollBarCustom1 = new com.raven.suportSwing.ScrollBarCustom();
        lblSearch = new javax.swing.JLabel();
        lblSearch1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(246, 112, 112));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SỔ TIẾT KIỆM");

        txtSearch.setLabelText("Tìm theo id hoặc tên khách hàng");
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
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        myButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Search.png"))); // NOI18N
        myButton5.setText("  Tìm");
        myButton5.setRadius(20);
        myButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton5ActionPerformed(evt);
            }
        });

        myButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Create.png"))); // NOI18N
        myButton6.setText("Thêm Sổ Tiết Kiệm");
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
        myButton8.setText("Xóa Sổ Tiết Kiệm");
        myButton8.setRadius(20);
        myButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton8ActionPerformed(evt);
            }
        });

        tableSoTietKiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Chi Nhánh", "Kỳ Hạn", "Mã Khách Hàng", "Tên Khách Hàng", "CCCD/Hộ Chiếu", "Số Tài Khoản", "Số Tiền Gửi", "Lãi Suất", "Ngày Mở Sổ", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSoTietKiem.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tableSoTietKiemAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tableSoTietKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSoTietKiemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSoTietKiem);
        if (tableSoTietKiem.getColumnModel().getColumnCount() > 0) {
            tableSoTietKiem.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableSoTietKiem.getColumnModel().getColumn(1).setResizable(false);
            tableSoTietKiem.getColumnModel().getColumn(2).setResizable(false);
            tableSoTietKiem.getColumnModel().getColumn(3).setResizable(false);
            tableSoTietKiem.getColumnModel().getColumn(4).setResizable(false);
            tableSoTietKiem.getColumnModel().getColumn(5).setResizable(false);
            tableSoTietKiem.getColumnModel().getColumn(6).setResizable(false);
            tableSoTietKiem.getColumnModel().getColumn(7).setResizable(false);
            tableSoTietKiem.getColumnModel().getColumn(8).setResizable(false);
            tableSoTietKiem.getColumnModel().getColumn(9).setResizable(false);
            tableSoTietKiem.getColumnModel().getColumn(10).setResizable(false);
        }

        lblSearch.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(255, 51, 0));

        lblSearch1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblSearch1.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                        .addGap(192, 192, 192)
                        .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(myButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(myButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(159, 159, 159))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(378, 378, 378))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(481, 481, 481)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(482, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(lblSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(375, 375, 375)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(376, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        // TODO add your handling code here:
       try {
              fillTableWhenFind();
        } catch (Exception e) {
               fillSearchID();
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
       try {
              fillTableWhenFind();
        } catch (Exception e) {
               fillSearchID();
        }

    }//GEN-LAST:event_txtSearchActionPerformed

    private void myButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton5ActionPerformed
        // TODO add your handling code here:
       try {
              fillTableWhenFind();
        } catch (Exception e) {
               fillSearchID();
        }
    }//GEN-LAST:event_myButton5ActionPerformed

    private void myButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton6MouseClicked

    private void myButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton6MouseEntered

    private void myButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton6ActionPerformed
        // TODO add your handling code here:
        formImportSoTietKiemJFrame.setVisible(true);
    }//GEN-LAST:event_myButton6ActionPerformed

    private void myButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton8ActionPerformed
        // TODO add your handling code here:
         delete();
    }//GEN-LAST:event_myButton8ActionPerformed

    private void tableSoTietKiemAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tableSoTietKiemAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tableSoTietKiemAncestorAdded

    private void tableSoTietKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSoTietKiemMouseClicked
        if (evt.getClickCount() == 2) {
            int index = tableSoTietKiem.getSelectedRow();
            int id = (int) tableSoTietKiem.getValueAt(index, 0);
            String chinhanh = tableSoTietKiem.getValueAt(index, 1).toString();
            String kyhan = tableSoTietKiem.getValueAt(index, 2).toString();
            String makh = tableSoTietKiem.getValueAt(index, 3).toString();
            String tenkh = tableSoTietKiem.getValueAt(index, 4).toString();
            String cccd = tableSoTietKiem.getValueAt(index, 5).toString();
            String sotk = tableSoTietKiem.getValueAt(index, 6).toString();
            Double sotien = Double.parseDouble(fomartDouble((String) tableSoTietKiem.getValueAt(tableSoTietKiem.getSelectedRow(), 7)));
            String laisuat = tableSoTietKiem.getValueAt(index, 8).toString();
            String date = tableSoTietKiem.getValueAt(index, 9).toString();
            String address = tableSoTietKiem.getValueAt(index, 10).toString();
            System.out.println(address);
            formUpdate = new FormImportSoTietKiemJFrame(id, chinhanh, kyhan, makh, tenkh, cccd, sotk, sotien, laisuat, date, address);
            formUpdate.setVisible(true);
        }
        if (formUpdate == null) {
            return;
        } else {
            formUpdate.addEvenUpdate(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    formUpdate.update();
                    fillTable();
                }
            });
        }
    }//GEN-LAST:event_tableSoTietKiemMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        try {
              fillTableWhenFind();
        } catch (Exception e) {
               fillSearchID();
        }
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSearch1;
    private com.raven.suportSwing.MyButton myButton5;
    private com.raven.suportSwing.MyButton myButton6;
    private com.raven.suportSwing.MyButton myButton8;
    private com.raven.suportSwing.ScrollBarCustom scrollBarCustom1;
    private com.raven.suportSwing.TableColumn tableSoTietKiem;
    private com.raven.suportSwing.TextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void clear() {
    }
}
