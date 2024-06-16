
package com.raven.JFrame;

import com.qlcnnh.DAO.KyHanSTKDao;
import com.qlcnnh.DAO.SoTietKiemImportDao;
import com.qlcnnh.Validate.Validate;
import com.qlcnnh.Validate.labelValidate;
import com.qlcnnh.entity.KyHanSTK;
import com.qlcnnh.entity.SoTietKiemImport;
import com.qlcnnh.utils.MsgBox;
import com.qlcnnh.utils.XDate;
import com.raven.form.FormSoTietKiem;
import com.raven.form.MainForm;
import com.raven.suportSwing.MyTextArea;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 *
 * @author T14
 */
public class FormImportSoTietKiemJFrame extends javax.swing.JFrame {

    /**
     * Creates new form FormImportSoTietKiemJFrame
     */
    SoTietKiemImportDao daoE = new SoTietKiemImportDao() {
    };
     private SoTietKiemImport s; // Biến lớp để lưu đối tượng hiện tại
      KyHanSTKDao productDAO = new KyHanSTKDao();
//private JTextField txtDiaChi;
    public FormImportSoTietKiemJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        fillComboboxKyHan();
        btnUpdate.setEnabled(false);
//        btnUpdate.setVisible(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\com\\raven\\icon\\banklogo.png");
        this.setIconImage(icon);
           // Thêm sự kiện RequestFocusListener vào txtChiNhanh
txtChiNhanh.addAncestorListener(new AncestorListener() {
    @Override
    public void ancestorAdded(AncestorEvent event) {
        txtChiNhanh.requestFocusInWindow();
        txtChiNhanh.setCaretPosition(0);
    }

    @Override
    public void ancestorRemoved(AncestorEvent event) {
        // Không cần xử lý
    }

    @Override
    public void ancestorMoved(AncestorEvent event) {
        // Không cần xử lý
    }
});

        // Thiết lập các thành phần tiếp theo khi nhấn Tab
        txtChiNhanh.setNextFocusableComponent(cbbKyHan);
        cbbKyHan.setNextFocusableComponent(txtMaKh);
        txtMaKh.setNextFocusableComponent(txtTenKh);
        txtTenKh.setNextFocusableComponent(txtCccd);
        txtCccd.setNextFocusableComponent(txtSoTk);
        txtSoTk.setNextFocusableComponent(txtSoTien);
        txtSoTien.setNextFocusableComponent(txtLaiSuat);
        txtLaiSuat.setNextFocusableComponent(txtDate);
        txtDate.setNextFocusableComponent(txtDiaChi);
        txtDiaChi.setNextFocusableComponent(btnThem); // Thiết lập cuối cùng là nút btnThem

        // Xử lý sự kiện nhấn Enter để chuyển focus tới thành phần tiếp theo
        txtChiNhanh.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtMaKh.requestFocusInWindow();
                }
            }
        });
     
    }
    public FormImportSoTietKiemJFrame(int id, String chinhanh, String kyhan, String makh, String tenkh, String cccd, String sotk, double sotien, String laisuat, String date, String address) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        fillComboboxKyHan();
        btnThem.setEnabled(false);
        btnThem.setVisible(false);


        // Khởi tạo đối tượng hiện tại và đặt ID
        s = new SoTietKiemImport();
        s.setId(id);
        s.setChiNhanh(chinhanh);
        s.setMaKh(makh);
        s.setTenKh(tenkh);
        s.setCccd(cccd);
        s.setSoTk(sotk);
        s.setSoTien(sotien);
        s.setLaiSuat(Integer.parseInt(laisuat));
        s.setNgayMoSo(XDate.toDate(date, "dd-MM-yyyy"));
        s.setAddress(address);

        // Thiết lập giá trị cho các ô văn bản
        txtChiNhanh.setText(chinhanh);
        
        txtMaKh.setText(makh);
        txtTenKh.setText(tenkh);
        txtCccd.setText(cccd);
        txtSoTk.setText(sotk);
        txtSoTien.setText(Double.toString(sotien));
        txtLaiSuat.setText(laisuat);
        txtDate.setText(date);
        txtDiaChi.setText(address);

        // Đảm bảo các trường có thể chỉnh sửa nếu cần thiết
        txtChiNhanh.setEditable(true);
        txtMaKh.setEditable(true);
        txtTenKh.setEditable(true);
        txtCccd.setEditable(true);
        txtSoTk.setEditable(true);
        txtSoTien.setEditable(true);
        txtLaiSuat.setEditable(true);
        txtDate.setEditable(true);
        txtDiaChi.setEditable(true);

        // Thiết lập combobox 'cbbKyHan'
        KyHanSTK size = kyDao.selectByName(kyhan);
        cbbKyHan.getModel().setSelectedItem(size);
    }

    public void update() {
        try {
            // Cho phép các ô text có thể chỉnh sửa
            txtChiNhanh.setEnabled(true);
            txtChiNhanh.setEditable(true);
            
            txtMaKh.setEnabled(true);
            txtMaKh.setEditable(true);
            
            txtTenKh.setEnabled(true);
            txtTenKh.setEditable(true);
            
            txtCccd.setEnabled(true);
            txtCccd.setEditable(true);
            
            txtSoTk.setEnabled(true);
            txtSoTk.setEditable(true);
            
            txtSoTien.setEnabled(true);
            txtSoTien.setEditable(true);
            
            txtLaiSuat.setEnabled(true);
            txtLaiSuat.setEditable(true);
            
            txtDate.setEnabled(true);
            txtDate.setEditable(true);
            
            txtDiaChi.setEnabled(true);
            txtDiaChi.setEditable(true);

            // Tiếp tục với cập nhật dữ liệu
            KyHanSTK k = (KyHanSTK) cbbKyHan.getSelectedItem();
            // Kiểm tra xem kỳ hạn có được chọn hay không
            if (k == null) {
                MsgBox.alert(this, "Kỳ hạn không được để trống!");
                return;
            }
            // Cập nhật đối tượng hiện tại
            s.setChiNhanh(txtChiNhanh.getText());
            s.setMaKh(txtMaKh.getText());
            s.setKyHan(k.getValueKyHan());
            s.setTenKh(txtTenKh.getText());
            s.setCccd(txtCccd.getText());
            s.setSoTk(txtSoTk.getText());
            s.setSoTien(Double.parseDouble(txtSoTien.getText()));
            s.setLaiSuat(Integer.parseInt(txtLaiSuat.getText()));
            s.setNgayMoSo(XDate.toDate(txtDate.getText(), "dd-MM-yyyy"));
            s.setAddress(txtDiaChi.getText());

            // Gọi update với đối tượng hiện tại
            daoE.update(s);
            MsgBox.alert(this, "Cập nhật thành công!");//Hiển thị thông báo
            this.dispose();//Đóng form
        } catch (NumberFormatException ex) {
            MsgBox.alert(this, "Sai định dạng số: " + ex.getMessage());// Hiển thị thông báo
        } catch (Exception ex) {
            MsgBox.alert(this, "Lỗi: " + ex.getMessage());//Hiển thị thông báo
        }
    }
// Phương thức thêm sự kiện cho nút cập nhật

    public void addEvenUpdate(ActionListener evt) {
        btnUpdate.addActionListener(evt);
    }
    // Khai báo đối tượng kyDAO để làm việc với kỳ hạn sổ tiết kiệm
    KyHanSTKDao kyDao = new KyHanSTKDao();
// Phương thức để điền dữ liệu vào combobox kỳ hạn

    public void fillComboboxKyHan() {

        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbKyHan.getModel();
        cbbKyHan.removeAllItems();
        List<KyHanSTK> listKyHan = kyDao.selectAll();//Lấy danh sách kỳ hạn
        for (KyHanSTK c : listKyHan) {
            model.addElement(c);//Thêm đối tượng vào combobox
        }
    }
//Phương thức hiển thị

    public void showKyHan() {
        KyHanSTK ky = (KyHanSTK) cbbKyHan.getSelectedItem();
        if (ky == null) {
            return;
        } else {
        }
    }

    public void clear() {
        txtChiNhanh.setText("");
        cbbKyHan.setSelectedIndex(-1);
        txtMaKh.setText("");
        txtTenKh.setText("");
        txtCccd.setText("");
        txtSoTk.setText("");
        txtSoTien.setText("");
        txtDiaChi.setText("");
        txtDate.setText("");
        txtLaiSuat.setText("");
    }

    public void insert() {

        try { // Các điều kiện kiểm tra thông tin
            
            if (labelValidate.checkEmpty(lblcn, txtChiNhanh, "Chi nhánh chưa nhập!") == false) {
                return;
            } else if (labelValidate.checkEmpty(lblMaKh, txtMaKh, "Mã khách hàng chưa nhập!") == false) {
                return;
            } else if (labelValidate.checkEmpty(lblName, txtTenKh, "Tên khách hàng chưa nhập!") == false) {
                return;
            } else if (labelValidate.checkCCCD(lblCccd, txtCccd, "CCCD chưa nhập!") == false) {
                return;
            } else if (labelValidate.checkBankAccount(lblStk, txtSoTk, "Số tài khoản chưa nhập!") == false) {
                return;
            } else if (labelValidate.checkNumber(lblSoTien, txtSoTien, "Số tiền chưa nhập!") == false) {
                return;
            } else if (labelValidate.checkEmpty(lblLaiSuat, txtLaiSuat, "Lãi suất chưa nhập!") == false) {
                return;
            } else if (labelValidate.checkEmpty(lblDate, txtDate, "Ngày chưa nhập!") == false) {
                return;
            } else {
                SoTietKiemImport e = getFormE();// lấy thông tin từ FormE
                daoE.insert(e); // Thêm thông tin sổ tiết kiệm vào cơ sở dữ liệu
                MsgBox.alert(this, "Thêm mới thành công."); //Hiển thị thông báo 
                this.dispose(); // Đóng form
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.warring(this, "Thêm mới thất bại!");// Hiển thị thông báo
        }
    }

    public SoTietKiemImport getFormE() {
        // Khởi tạo một đối tượng SoTietKiemImport mới
        SoTietKiemImport e = new SoTietKiemImport();
         // Lấy kỳ hạn tiết kiệm đã chọn từ JComboBox
        KyHanSTK k = (KyHanSTK) cbbKyHan.getSelectedItem();
        // Thiết lập các thuộc tính cho đối tượng SoTietKiemImport từ các trường nhập liệu trên giao diện
        e.setChiNhanh(txtChiNhanh.getText());
        e.setKyHan(k.getValueKyHan());
        e.setMaKh(txtMaKh.getText());
        e.setTenKh(txtTenKh.getText());
        e.setCccd(txtCccd.getText());
        e.setSoTk(txtSoTk.getText());
        e.setSoTien(Double.parseDouble(txtSoTien.getText()));
        e.setLaiSuat(Integer.parseInt(txtLaiSuat.getText()));
        e.setNgayMoSo(XDate.toDate(txtDate.getText(), "dd-MM-yyyy"));
        e.setAddress(txtDiaChi.getText());
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
        jLabel1 = new javax.swing.JLabel();
        txtChiNhanh = new com.raven.textfield.TextField();
        txtMaKh = new com.raven.textfield.TextField();
        txtCccd = new com.raven.textfield.TextField();
        txtSoTk = new com.raven.textfield.TextField();
        txtSoTien = new com.raven.textfield.TextField();
        txtLaiSuat = new com.raven.textfield.TextField();
        txtDate = new com.raven.textfield.TextField();
        txtTenKh = new com.raven.textfield.TextField();
        textAreaScroll1 = new com.raven.textarea.TextAreaScroll();
        txtDiaChi = new com.raven.textarea.TextArea();
        btnThem = new com.raven.suportSwing.MyButton();
        btnUpdate = new com.raven.suportSwing.MyButton();
        btnClear = new com.raven.suportSwing.MyButton();
        btnClear1 = new com.raven.suportSwing.MyButton();
        lblkyhan = new javax.swing.JLabel();
        lblcn = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblCccd = new javax.swing.JLabel();
        lblStk = new javax.swing.JLabel();
        lblSoTien = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblLaiSuat = new javax.swing.JLabel();
        lblMaKh = new javax.swing.JLabel();
        cbbKyHan = new com.raven.suportSwing.Combobox();
        lblDiaChi = new javax.swing.JLabel();

        dateChooser1.setTextRefernce(txtDate);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Sổ Tiết Kiệm");

        txtChiNhanh.setLabelText("Chi Nhánh");
        txtChiNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChiNhanhActionPerformed(evt);
            }
        });

        txtMaKh.setLabelText("Mã Khách Hàng");
        txtMaKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhActionPerformed(evt);
            }
        });

        txtCccd.setLabelText("CCCD/Hộ Chiếu");
        txtCccd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCccdActionPerformed(evt);
            }
        });

        txtSoTk.setLabelText("Số Tài Khoản");
        txtSoTk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoTkActionPerformed(evt);
            }
        });

        txtSoTien.setLabelText("Số Tiền");
        txtSoTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoTienActionPerformed(evt);
            }
        });

        txtLaiSuat.setLabelText("Lãi Suất");
        txtLaiSuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLaiSuatActionPerformed(evt);
            }
        });

        txtDate.setLabelText("Ngày Mở Sổ");
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        txtTenKh.setLabelText("Tên Khách Hàng");
        txtTenKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhActionPerformed(evt);
            }
        });

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        textAreaScroll1.setViewportView(txtDiaChi);

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

        lblkyhan.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblkyhan.setForeground(new java.awt.Color(255, 51, 51));

        lblcn.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblcn.setForeground(new java.awt.Color(255, 51, 51));

        lblName.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 51, 51));

        lblCccd.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblCccd.setForeground(new java.awt.Color(255, 51, 51));

        lblStk.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblStk.setForeground(new java.awt.Color(255, 51, 51));

        lblSoTien.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblSoTien.setForeground(new java.awt.Color(255, 51, 51));

        lblDate.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 51, 51));

        lblLaiSuat.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblLaiSuat.setForeground(new java.awt.Color(255, 51, 51));

        lblMaKh.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblMaKh.setForeground(new java.awt.Color(255, 51, 51));

        cbbKyHan.setLabeText("Kỳ Hạn");
        cbbKyHan.setPreferredSize(new java.awt.Dimension(30, 40));
        cbbKyHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKyHanActionPerformed(evt);
            }
        });

        lblDiaChi.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblDiaChi.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSoTk, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(273, 273, 273)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbbKyHan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMaKh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMaKh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStk, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblcn, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblkyhan, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblCccd, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                            .addComponent(txtTenKh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCccd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(470, 470, 470)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSoTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtLaiSuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSoTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblLaiSuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                    .addComponent(lblDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(txtChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblcn, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(cbbKyHan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblkyhan, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(txtLaiSuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLaiSuat, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCccd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCccd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(txtSoTk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(lblStk, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void txtMaKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhActionPerformed
        // TODO add your handling code here:\
        lblMaKh.setText("");
    }//GEN-LAST:event_txtMaKhActionPerformed

    private void txtCccdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCccdActionPerformed
        // TODO add your handling code here:
        lblCccd.setText("");
    }//GEN-LAST:event_txtCccdActionPerformed

    private void txtChiNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChiNhanhActionPerformed
        // TODO add your handling code here:
        lblcn.setText("");
    }//GEN-LAST:event_txtChiNhanhActionPerformed

    private void txtSoTkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoTkActionPerformed
        // TODO add your handling code here:
        lblStk.setText("");
    }//GEN-LAST:event_txtSoTkActionPerformed

    private void txtSoTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoTienActionPerformed
        // TODO add your handling code here:
        lblSoTien.setText("");
    }//GEN-LAST:event_txtSoTienActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
        lblDate.setText("");
    }//GEN-LAST:event_txtDateActionPerformed

    private void txtTenKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhActionPerformed
        // TODO add your handling code here:
        lblName.setText("");
    }//GEN-LAST:event_txtTenKhActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        this.insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
                this.update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void cbbKyHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKyHanActionPerformed
        // TODO add your handling code here:
        showKyHan();
    }//GEN-LAST:event_cbbKyHanActionPerformed

    private void txtLaiSuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLaiSuatActionPerformed
        // TODO add your handling code here:
        lblLaiSuat.setText("");
    }//GEN-LAST:event_txtLaiSuatActionPerformed

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
            java.util.logging.Logger.getLogger(FormImportSoTietKiemJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormImportSoTietKiemJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormImportSoTietKiemJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormImportSoTietKiemJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormImportSoTietKiemJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.suportSwing.MyButton btnClear;
    private com.raven.suportSwing.MyButton btnClear1;
    private com.raven.suportSwing.MyButton btnThem;
    private com.raven.suportSwing.MyButton btnUpdate;
    private com.raven.suportSwing.Combobox cbbKyHan;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCccd;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblLaiSuat;
    private javax.swing.JLabel lblMaKh;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSoTien;
    private javax.swing.JLabel lblStk;
    private javax.swing.JLabel lblcn;
    private javax.swing.JLabel lblkyhan;
    private com.raven.textarea.TextAreaScroll textAreaScroll1;
    private com.raven.textfield.TextField txtCccd;
    private com.raven.textfield.TextField txtChiNhanh;
    private com.raven.textfield.TextField txtDate;
    private com.raven.textarea.TextArea txtDiaChi;
    private com.raven.textfield.TextField txtLaiSuat;
    private com.raven.textfield.TextField txtMaKh;
    private com.raven.textfield.TextField txtSoTien;
    private com.raven.textfield.TextField txtSoTk;
    private com.raven.textfield.TextField txtTenKh;
    // End of variables declaration//GEN-END:variables
}
