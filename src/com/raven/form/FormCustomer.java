/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.qlcnnh.DAO.CustomerDAO;
import com.qlcnnh.Validate.labelValidate;
import com.qlcnnh.entity.Customer;
import com.qlcnnh.utils.MsgBox;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author T14
 */
//public class FormCustomer extends javax.swing.JPanel {
//
//    /**
//     * Creates new form FormCustomer
//     */
//      public FormCustomer() {
//        initComponents();
//        rdioMale.setSelected(true);
//        btnXoa.setEnabled(false);
//        btnCapNhap.setEnabled(false);
//        fillTable();
//        setOpaque(false);
//    }
//
//    CustomerDAO cDao = new CustomerDAO();
//
//    public void fillTable() {
//        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
//        model.setRowCount(0);
//        List<Customer> list = cDao.selectAll();
//        for (Customer c : list) {
//            Object[] row = {c.getId(), c.getName(), c.getAddress(), c.getPhoneNumber(), c.getGender() ? "Nam" : "Nữ"};
//            model.addRow(row);
//        }
//    }
//
//    public void fillTableWhenFind() {
//        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
//        model.setRowCount(0);
//        String keyString = txtTimkiem.getText();
//        List<Customer> list = cDao.selectByKeyWord(keyString);
//        if (list.isEmpty()) {
//            lblTimKiem.setText("Không có khách hàng " + keyString);
//            return;
//        }
//        for (Customer c : list) {
//            model.addRow(new Object[]{
//                c.getId(), c.getName(), c.getAddress(), c.getPhoneNumber(), c.getGender() ? "Nam" : "Nữ"
//            });
//        }
//        lblTimKiem.setText("");
//    }
//
//    public void setForm(Customer c) {
//        txtName.setText(c.getName());
//        txtAddress.setText(c.getAddress());
//        txtPhoneNumber.setText(c.getPhoneNumber());
//        if (c.getGender()) {
//            rdioMale.setSelected(true);
//            rdioFemale.setSelected(false);
//        } else {
//            rdioFemale.setSelected(true);
//            rdioMale.setSelected(false);
//        }
//    }
//
//    public Customer getForm() {
//        Customer c = new Customer();
//        c.setName(txtName.getText());
//        c.setAddress(txtAddress.getText());
//        c.setPhoneNumber(txtPhoneNumber.getText());
//        c.setGender(rdioMale.isSelected());
//        return c;
//    }
//
//    public void clearForm() {
//        tableCustomer.clearSelection();
//        txtName.setText("");
//        txtAddress.setText("");
//        txtPhoneNumber.setText("");
//        rdioMale.setSelected(false);
//        rdioFemale.setSelected(false);
//        btnThem.setEnabled(true);
//        lblName.setText("");
//        lblAdress.setText("");
//        lblPhoneNumber.setText("");
//        btnCapNhap.setEnabled(false);
//        btnXoa.setEnabled(false);
//    }
//
//    public void insert() {
//        Customer c = getForm();
//        try {
//            cDao.insert(c);
//            fillTable();
//            clearForm();
//            MsgBox.alert(this, "Thêm thành công");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void update() {
//        Customer c = getForm();
//        int row = tableCustomer.getSelectedRow();
//        c.setId((int) tableCustomer.getValueAt(row, 0));
//        try {
//            cDao.update(c);
//            fillTable();
//            clearForm();
//            MsgBox.alert(this, "Update thành công");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void delete() {
//        int row = tableCustomer.getSelectedRow();
//        int ma = (int) tableCustomer.getValueAt(row, 0);
//        if (MsgBox.confirm(this, "Bạn có muốn xóa không?")) {
//            try {
//                cDao.delete(ma);
//                fillTable();
//                clearForm();
//                MsgBox.alert(this, "Xoá Thành công");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void edit() {
//        int row = tableCustomer.getSelectedRow();
//        btnThem.setEnabled(false);
//        btnXoa.setEnabled(true);
//        btnCapNhap.setEnabled(true);
//        int ma = (int) tableCustomer.getValueAt(row, 0);
//        Customer c = cDao.selectById(ma);
//        setForm(c);
//    }
//
//    public void addEvenFillTable(ActionListener evt) {
//        fillTable();
//    }
public class FormCustomer extends javax.swing.JPanel {

    /**
     * Creates new form FormCustomer
     */
    // Phương thức khởi tạo của FormCustomer
    public FormCustomer() {
        initComponents();  // Khởi tạo các thành phần giao diện
        rdioMale.setSelected(true);  // Chọn giới tính nam mặc định
        btnXoa.setEnabled(false);  // Vô hiệu hóa nút Xóa
        btnCapNhap.setEnabled(false);  // Vô hiệu hóa nút Cập nhật
        fillTable();  // Điền dữ liệu vào bảng từ cơ sở dữ liệu
        setOpaque(false);  // Đặt độ mờ của panel
    }

    // Tạo một đối tượng CustomerDAO để tương tác với cơ sở dữ liệu
    CustomerDAO cDao = new CustomerDAO();

    // Phương thức để điền dữ liệu vào bảng
    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        model.setRowCount(0);  // Xóa tất cả các hàng hiện tại trong bảng
        List<Customer> list = cDao.selectAll();  // Lấy tất cả khách hàng từ cơ sở dữ liệu
        for (Customer c : list) {
            Object[] row = {c.getId(), c.getName(), c.getAddress(), c.getPhoneNumber(), c.getGender() ? "Nam" : "Nữ"};
            model.addRow(row);  // Thêm từng hàng vào mô hình bảng
        }
    }

    // Phương thức để điền dữ liệu vào bảng khi tìm kiếm
    public void fillTableWhenFind() {
        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        model.setRowCount(0);  // Xóa tất cả các hàng hiện tại trong bảng
        String keyString = txtTimkiem.getText();  // Lấy từ khóa tìm kiếm từ trường văn bản
        List<Customer> list = cDao.selectByKeyWord(keyString);  // Tìm kiếm tên khách hàng 
        if (list.isEmpty()) {
            lblTimKiem.setText("Không có khách hàng " + keyString);  // Hiển thị thông báo nếu không tìm thấy khách hàng
            return;
        }
        for (Customer c : list) {
            model.addRow(new Object[]{
                c.getId(), c.getName(), c.getAddress(), c.getPhoneNumber(), c.getGender() ? "Nam" : "Nữ"
            });  // Thêm từng hàng vào mô hình bảng
        }
        lblTimKiem.setText("");  // Xóa thông báo tìm kiếm
    }

    // Phương thức để đặt thông tin khách hàng lên form
    public void setForm(Customer c) {
        txtName.setText(c.getName());
        txtAddress.setText(c.getAddress());
        txtPhoneNumber.setText(c.getPhoneNumber());
        if (c.getGender()) {
            rdioMale.setSelected(true);
            rdioFemale.setSelected(false);
        } else {
            rdioFemale.setSelected(true);
            rdioMale.setSelected(false);
        }
    }

    // Phương thức để lấy thông tin khách hàng từ form
    public Customer getForm() {
        Customer c = new Customer();
        c.setName(txtName.getText());
        c.setAddress(txtAddress.getText());
        c.setPhoneNumber(txtPhoneNumber.getText());
        c.setGender(rdioMale.isSelected());
        return c;
    }

    // Phương thức để xóa sạch thông tin trên form
    public void clearForm() {
        tableCustomer.clearSelection();  // Xóa chọn trong bảng
        txtName.setText("");  // Xóa nội dung trường tên
        txtAddress.setText("");  
        txtPhoneNumber.setText("");  
        rdioMale.setSelected(false);  // Bỏ chọn giới tính nam
        rdioFemale.setSelected(false);  
        btnThem.setEnabled(true);  // Kích hoạt nút Thêm
        lblName.setText("");  // Xóa nội dung nhãn tên
        lblAdress.setText("");  
        lblPhoneNumber.setText(""); 
        btnCapNhap.setEnabled(false);  // Vô hiệu hóa nút Cập nhật
        btnXoa.setEnabled(false);  // Vô hiệu hóa nút Xóa
    }

    // Phương thức để thêm mới một khách hàng
    public void insert() {
        Customer c = getForm();  // Lấy thông tin khách hàng từ form
        try {
            cDao.insert(c);  // Thêm khách hàng vào cơ sở dữ liệu
            fillTable();  // Cập nhật lại bảng
            clearForm();  // Xóa form
            MsgBox.alert(this, "Thêm thành công");  // Hiển thị thông báo thành công
        } catch (Exception e) {
            e.printStackTrace();  // In ra lỗi nếu có
        }
    }

    // Phương thức để cập nhật thông tin khách hàng
    public void update() {
        Customer c = getForm();  // Lấy thông tin khách hàng từ form
        int row = tableCustomer.getSelectedRow();  // Lấy hàng được chọn trong bảng
        c.setId((int) tableCustomer.getValueAt(row, 0));  // Đặt ID khách hàng
        try {
            cDao.update(c);  // Cập nhật khách hàng trong cơ sở dữ liệu
            fillTable();  // Cập nhật lại bảng
            clearForm();  // Xóa form
            MsgBox.alert(this, "Update thành công");  // Hiển thị thông báo thành công
        } catch (Exception e) {
            e.printStackTrace();  // In ra lỗi nếu có
        }
    }

    // Phương thức để xóa một khách hàng
    public void delete() {
        int row = tableCustomer.getSelectedRow();  // Lấy hàng được chọn trong bảng
        int ma = (int) tableCustomer.getValueAt(row, 0);  // Lấy ID khách hàng
        if (MsgBox.confirm(this, "Bạn có muốn xóa không?")) {
            try {
                cDao.delete(ma);  // Xóa khách hàng trong cơ sở dữ liệu
                fillTable();  // Cập nhật lại bảng
                clearForm();  // Xóa form
                MsgBox.alert(this, "Xoá Thành công");  // Hiển thị thông báo thành công
            } catch (Exception e) {
                e.printStackTrace();  // In ra lỗi nếu có
            }
        }
    }

    // Phương thức để chỉnh sửa thông tin khách hàng
    public void edit() {
        int row = tableCustomer.getSelectedRow();  // Lấy hàng được chọn trong bảng
        btnThem.setEnabled(false);  // Vô hiệu hóa nút Thêm
        btnXoa.setEnabled(true);  // Kích hoạt nút Xóa
        btnCapNhap.setEnabled(true);  // Kích hoạt nút Cập nhật
        int ma = (int) tableCustomer.getValueAt(row, 0);  // Lấy ID khách hàng
        Customer c = cDao.selectById(ma);  // Lấy thông tin khách hàng từ cơ sở dữ liệu
        setForm(c);  // Đặt thông tin khách hàng lên form
    }

    // Phương thức để thêm sự kiện và điền dữ liệu vào bảng
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new com.raven.suportSwing.TableColumn();
        jPanel3 = new javax.swing.JPanel();
        txtName = new com.raven.suportSwing.TextField();
        btnClear = new com.raven.suportSwing.MyButton();
        btnThem = new com.raven.suportSwing.MyButton();
        btnCapNhap = new com.raven.suportSwing.MyButton();
        txtAddress = new com.raven.suportSwing.TextField();
        txtPhoneNumber = new com.raven.suportSwing.TextField();
        btnXoa = new com.raven.suportSwing.MyButton();
        jLabel3 = new javax.swing.JLabel();
        rdioMale = new com.raven.suportSwing.RadioButtonCustom();
        rdioFemale = new com.raven.suportSwing.RadioButtonCustom();
        lblName = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTimkiem = new com.raven.suportSwing.TextField();
        btnTim = new com.raven.suportSwing.MyButton();
        lblTimKiem = new javax.swing.JLabel();

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Tên KH", "Địa Chỉ", "SĐT", "Giới tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomer);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Chi tiết khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txtName.setLabelText("Họ tên");
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        btnClear.setLabel("Xóa form");
        btnClear.setRadius(20);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.setRadius(20);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhap.setText("Cập Nhật");
        btnCapNhap.setRadius(20);
        btnCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapActionPerformed(evt);
            }
        });

        txtAddress.setLabelText("Địa chỉ");
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        txtPhoneNumber.setLabelText("SĐT");
        txtPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.setRadius(20);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel3.setText("Giới tính");

        rdioMale.setText("Nam");
        rdioMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdioMaleActionPerformed(evt);
            }
        });

        rdioFemale.setText("Nữ");
        rdioFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdioFemaleActionPerformed(evt);
            }
        });

        lblName.setForeground(new java.awt.Color(255, 0, 0));

        lblAdress.setForeground(new java.awt.Color(225, 0, 0));

        lblPhoneNumber.setForeground(new java.awt.Color(225, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rdioMale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdioFemale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lblAdress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdioMale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdioFemale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Khách hàng");

        txtTimkiem.setLabelText("Tìm theo tên khách hàng");
        txtTimkiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimkiemFocusGained(evt);
            }
        });
        txtTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemActionPerformed(evt);
            }
        });
        txtTimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimkiemKeyReleased(evt);
            }
        });

        btnTim.setText("Tìm");
        btnTim.setRadius(20);
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        lblTimKiem.setForeground(new java.awt.Color(225, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(109, 109, 109)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(396, 396, 396))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_tableCustomerMouseClicked

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (!labelValidate.checkEmpty(lblName, txtName, "Không được để trống họ và tên")) {
            return;
        } else if (!labelValidate.checkEmpty(lblAdress, txtAddress, "Không được để trống địa chỉ")) {
            return;
        } else if (!labelValidate.checkEmpty(lblPhoneNumber, txtPhoneNumber, "Không được để trống SDT")) {
            return;
        } else {
            insert();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        if (!labelValidate.checkEmpty(lblName, txtName, "Không được để trống họ và tên")) {
            return;
        } else if (!labelValidate.checkEmpty(lblAdress, txtAddress, "Không được để trống địa chỉ")) {
            return;
        } else if (!labelValidate.checkEmpty(lblPhoneNumber, txtPhoneNumber, "Không được để trống SDT")) {
            return;
        } else {
            update();
        }
    }//GEN-LAST:event_btnCapNhapActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumberActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void rdioMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdioMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdioMaleActionPerformed

    private void rdioFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdioFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdioFemaleActionPerformed

    private void txtTimkiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimkiemFocusGained
        // TODO add your handling code here:
        fillTableWhenFind();
    }//GEN-LAST:event_txtTimkiemFocusGained

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
        fillTableWhenFind();
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void txtTimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiemKeyReleased
        // TODO add your handling code here:
        fillTableWhenFind();
    }//GEN-LAST:event_txtTimkiemKeyReleased

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        fillTableWhenFind();
    }//GEN-LAST:event_btnTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.suportSwing.MyButton btnCapNhap;
    private com.raven.suportSwing.MyButton btnClear;
    private com.raven.suportSwing.MyButton btnThem;
    private com.raven.suportSwing.MyButton btnTim;
    private com.raven.suportSwing.MyButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblTimKiem;
    private com.raven.suportSwing.RadioButtonCustom rdioFemale;
    private com.raven.suportSwing.RadioButtonCustom rdioMale;
    private com.raven.suportSwing.TableColumn tableCustomer;
    private com.raven.suportSwing.TextField txtAddress;
    private com.raven.suportSwing.TextField txtName;
    private com.raven.suportSwing.TextField txtPhoneNumber;
    private com.raven.suportSwing.TextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
