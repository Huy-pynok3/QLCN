package com.raven.main;

import com.qlcnnh.entity.MyProfile;
import com.qlcnnh.utils.Auth;
import com.qlcnnh.utils.MsgBox;
import com.raven.component.Header;
import com.raven.component.Menu;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;
import com.raven.form.FormCustomer;
import com.raven.form.FormListEmpolyee;
import com.raven.form.FormMyProfile;
import com.raven.form.FormSoTietKiem;
import com.raven.form.Form_Home;
import com.raven.form.Form_Phieu_Chi;
import com.raven.form.Form_Phieu_Thu;
import com.raven.form.MainForm;
import com.raven.form.Test;
import com.raven.suportSwing.ZoomHandler;
import com.raven.swing.MenuItem;
import com.raven.swing.PopupMenu;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;
    private int zoomLevel = 100; // Kích thước ban đầu là 100%

    public Main() {
        initComponents();
        init();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\com\\raven\\icon\\banklogo.png");
        this.setIconImage(icon);

    }

    private void init() {

        setLocationRelativeTo(null);    //cho ra giữa màn hình
        setExtendedState(JFrame.MAXIMIZED_BOTH);//cho toàn màn hình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header();
        main = new MainForm();

        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                //     System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (Auth.isManager()) {
                    if (menuIndex == 0) {
                        if (subMenuIndex == 0) {
                            main.showForm(new Form_Home());
                        } else if (subMenuIndex == 1) {
                            // main.showForm(new Form1());
                        }
                    } else if (menuIndex == 1) {
                        if (subMenuIndex == 0) {
                            main.showForm(new FormSoTietKiem());
                        }
                    }/* else if (menuIndex == 2) {
                        if (subMenuIndex == 0) {
                            main.showForm(new Test());
                        }
                    } else if (menuIndex == 3) {
                        if (subMenuIndex == 0) {
                            main.showForm(new Form_Phieu_Thu());
                        } else if (subMenuIndex == 1) {
                            main.showForm(new Form_Phieu_Chi());
                        }
                    } else if (menuIndex == 4) {
                        if (subMenuIndex == 0) {
                            main.showForm(new Test());
                        }
                    }*/ else if (menuIndex == 2) {
                        if (subMenuIndex == 0) {
                            main.showForm(new FormListEmpolyee());
                        }
                    } else if (menuIndex == 3) {
                        if (subMenuIndex == 0) {
                            main.showForm(new FormCustomer());
                        }
                    } else if (menuIndex == 4) {
                        if (subMenuIndex == 0) {
                            main.showForm(new FormMyProfile());
                        }

                    } else {

                        // Kiểm tra xem người dùng có muốn đăng xuất không bằng cách hiển thị hộp thoại xác nhận
                        if (MsgBox.confirm(Main.this, "Bạn có muốn đăng xuất không?")) {
                            // Nếu người dùng chọn YES trong hộp thoại xác nhận
                            // Xóa thông tin đăng nhập hiện tại
                            Auth.clear();
                            // Đóng cửa sổ chính (Main)
                            dispose();
                            // Tạo một cửa sổ đăng nhập mới và hiển thị nó
                            new Login().setVisible(true);
                        } else {
                            // Nếu người dùng chọn NO trong hộp thoại xác nhận, không làm gì cả và thoát khỏi phương thức
                            return;
                        }

                    }

                } else {
                    if (menuIndex == 0) {
                        if (subMenuIndex == 0) {
                            main.showForm(new Form_Home());
                        } else if (subMenuIndex == 1) {
                            // main.showForm(new Form1());
                        }
                    } else if (menuIndex == 1) {
                        if (subMenuIndex == 0) {
                            main.showForm(new FormSoTietKiem());
                        }
                    
                    } else if (menuIndex == 2) {
                        if (subMenuIndex == 0) {
                            main.showForm(new FormCustomer());
                        }
                    } else if (menuIndex == 3) {
                        if (subMenuIndex == 0) {
                            main.showForm(new FormMyProfile());
                        }

                    } else {
                        // Kiểm tra xem người dùng có muốn đăng xuất không bằng cách hiển thị hộp thoại xác nhận
                        if (MsgBox.confirm(Main.this, "Bạn có muốn đăng xuất không?")) {
                            // Nếu người dùng chọn YES trong hộp thoại xác nhận
                            // Xóa thông tin đăng nhập hiện tại
                            Auth.clear();
                            // Đóng cửa sổ chính (Main)
                            dispose();
                            // Tạo một cửa sổ đăng nhập mới và hiển thị nó
                            new Login().setVisible(true);
                        } else {
                            // Nếu người dùng chọn NO trong hộp thoại xác nhận, không làm gì cả và thoát khỏi phương thức
                            return;
                        }
                    }
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Main.this.getX() + 52;
                int y = Main.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        main.showForm(new Form_Home());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
