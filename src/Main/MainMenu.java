/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.loginModel;
import view.Form_About;
import view.Form_Settings;
import view.Laporan_Barang;
import view.Laporan_BarangKeluar;
import view.Laporan_BarangMasuk;
import view.Laporan_Pemesanan;
import view.Master_Barang;
import view.Master_JenisBarang;
import view.Master_Supplier;
import view.Master_User;
import view.Transaksi_BarangKeluar;
import view.Transaksi_BarangMasuk;
import view.Transaksi_Pemesanan;

public class MainMenu extends javax.swing.JFrame {
    
    private loginModel login_Model;
    
    public MainMenu(loginModel login_Model) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        label_nama.setText(login_Model.getNama_user());
        label_level.setText(login_Model.getLevel());
        lb_id.setText(login_Model.getId_user());
        lb_id.setVisible(false);
        
        try {
            // Konversi blob gambar ke ImageIcon
            byte[] img = login_Model.getGambar().getBytes(1, (int) login_Model.getGambar().length());
            ImageIcon imageIcon = new ImageIcon(img);

            // Ukuran JLabel
            int labelWidth = 150;
            int labelHeight = 150;

            // Ukuran gambar asli
            int imageWidth = imageIcon.getIconWidth();
            int imageHeight = imageIcon.getIconHeight();

            // Hitung skala untuk ukuran gambar yang baru
            double scaleX = (double) labelWidth / (double) imageWidth;
            double scaleY = (double) labelHeight / (double) imageHeight;
            double scale = Math.min(scaleX, scaleY);

            // Ubah ukuran gambar dengan skala yang sudah dihitung
            Image scaledImage = imageIcon.getImage().getScaledInstance((int) (scale * imageWidth), (int) (scale * imageHeight), Image.SCALE_SMOOTH);

            // Tampilkan ImageIcon pada JLabel
            label_gambar.setIcon(new ImageIcon(scaledImage));
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        execute(login_Model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_navbar = new javax.swing.JPanel();
        lb_username = new javax.swing.JLabel();
        btn_settings = new javax.swing.JButton();
        lb_id = new javax.swing.JLabel();
        panel_sidebar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_menu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        label_gambar = new javax.swing.JLabel();
        label_nama = new javax.swing.JLabel();
        label_level = new javax.swing.JLabel();
        panel_content = new javax.swing.JPanel();
        mainPanel = new custom.PanelRounded();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Project Tugas Akhir Kuliah");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/carIcon.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel_navbar.setBackground(new java.awt.Color(254, 217, 201));
        panel_navbar.setPreferredSize(new java.awt.Dimension(872, 70));

        lb_username.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lb_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_username.setPreferredSize(new java.awt.Dimension(56, 30));

        btn_settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_settings_20px.png"))); // NOI18N
        btn_settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_settingsActionPerformed(evt);
            }
        });

        lb_id.setForeground(new java.awt.Color(255, 255, 255));
        lb_id.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_id.setText("ID");

        javax.swing.GroupLayout panel_navbarLayout = new javax.swing.GroupLayout(panel_navbar);
        panel_navbar.setLayout(panel_navbarLayout);
        panel_navbarLayout.setHorizontalGroup(
            panel_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_navbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_username, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187)
                .addComponent(lb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addComponent(btn_settings)
                .addContainerGap())
        );
        panel_navbarLayout.setVerticalGroup(
            panel_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_navbarLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(panel_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_navbarLayout.createSequentialGroup()
                            .addComponent(lb_username, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_navbarLayout.createSequentialGroup()
                            .addComponent(btn_settings)
                            .addGap(14, 14, 14)))))
        );

        getContentPane().add(panel_navbar, java.awt.BorderLayout.PAGE_START);

        panel_sidebar.setBackground(new java.awt.Color(255, 255, 255));
        panel_sidebar.setPreferredSize(new java.awt.Dimension(280, 495));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        panel_menu.setBackground(new java.awt.Color(255, 255, 255));
        panel_menu.setLayout(new javax.swing.BoxLayout(panel_menu, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(panel_menu);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        label_gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        label_nama.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        label_nama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nama.setText("Nama");
        label_nama.setPreferredSize(new java.awt.Dimension(56, 30));

        label_level.setFont(new java.awt.Font("Poppins", 2, 14)); // NOI18N
        label_level.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_level.setText("Level");
        label_level.setPreferredSize(new java.awt.Dimension(56, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(label_nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_level, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_level, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_sidebarLayout = new javax.swing.GroupLayout(panel_sidebar);
        panel_sidebar.setLayout(panel_sidebarLayout);
        panel_sidebarLayout.setHorizontalGroup(
            panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_sidebarLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_sidebarLayout.setVerticalGroup(
            panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_sidebarLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        getContentPane().add(panel_sidebar, java.awt.BorderLayout.LINE_START);

        panel_content.setBackground(new java.awt.Color(204, 204, 204));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panel_contentLayout = new javax.swing.GroupLayout(panel_content);
        panel_content.setLayout(panel_contentLayout);
        panel_contentLayout.setHorizontalGroup(
            panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_contentLayout.setVerticalGroup(
            panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panel_content, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(859, 604));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        mainPanel.add(new content_bg());
        mainPanel.repaint();
        mainPanel.revalidate();

    }//GEN-LAST:event_formWindowOpened

    private void btn_settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_settingsActionPerformed
        //Membuat instance JDialog
        Form_Settings menu = new Form_Settings(this, true, this);

        //Menampilkan JDialog dibawah button settings
        Point p = btn_settings.getLocationOnScreen();
        int x = p.x + btn_settings.getWidth() - menu.getWidth();
        int y = p.y + btn_settings.getHeight();
        menu.setLocation(x,y);
        menu.setVisible(true);
    }//GEN-LAST:event_btn_settingsActionPerformed
    
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                loginModel login_Model = null;
                new MainMenu(login_Model).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_settings;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_gambar;
    private javax.swing.JLabel label_level;
    private javax.swing.JLabel label_nama;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_username;
    private custom.PanelRounded mainPanel;
    private javax.swing.JPanel panel_content;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JPanel panel_navbar;
    private javax.swing.JPanel panel_sidebar;
    // End of variables declaration//GEN-END:variables

    private void execute(loginModel login_Model) {
        ImageIcon iconHome = new ImageIcon(getClass().getResource("/img/home.png"));
        
        ImageIcon iconMaster = new ImageIcon(getClass().getResource("/img/masterMenu.png"));
        ImageIcon iconBarang = new ImageIcon(getClass().getResource("/img/barang.png"));
        ImageIcon iconJenisBarang = new ImageIcon(getClass().getResource("/img/jenisBarang.png"));
        ImageIcon iconSupplier = new ImageIcon(getClass().getResource("/img/supplier.png"));
        ImageIcon iconUser = new ImageIcon(getClass().getResource("/img/pengguna.png"));
        
        ImageIcon iconTransaksi = new ImageIcon(getClass().getResource("/img/transaksi.png"));
        ImageIcon iconPemesananBarang = new ImageIcon(getClass().getResource("/img/pemesananBarang.png"));
        ImageIcon iconBarangMasuk = new ImageIcon(getClass().getResource("/img/barangMasuk.png"));
        ImageIcon iconBarangKeluar = new ImageIcon(getClass().getResource("/img/barangKeluar.png"));
        
        ImageIcon iconLaporanBarang = new ImageIcon(getClass().getResource("/img/laporanBarang.png"));
        ImageIcon iconLaporanPemesanan = new ImageIcon(getClass().getResource("/img/laporanPemesanan.png"));
        ImageIcon iconLaporanBarangMasuk = new ImageIcon(getClass().getResource("/img/lapMasuk.png"));
        ImageIcon iconLaporanBarangKeluar = new ImageIcon(getClass().getResource("/img/lapKeluar.png"));
        ImageIcon iconLaporan = new ImageIcon(getClass().getResource("/img/laporan.png"));
        
        ImageIcon iconAbout = new ImageIcon(getClass().getResource("/img/about.png"));
        
        ItemMenu menuHome = new ItemMenu(iconHome, false, null, "Home", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new content_bg());
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        
        ItemMenu subBarang = new ItemMenu(null, true, iconBarang, "Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new Master_Barang());
                mainPanel.repaint();
                mainPanel.revalidate();
            } 
        });
        ItemMenu subJenisBarang = new ItemMenu(null, true, iconJenisBarang, "Jenis Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new Master_JenisBarang());
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        
        ItemMenu subSupplier= new ItemMenu(null, true, iconSupplier, "Supplier", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new Master_Supplier());
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        
        ItemMenu subUser = new ItemMenu(null, true, iconUser, "User", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new Master_User());
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        
        ItemMenu menuMaster = new ItemMenu(iconMaster, false, null, "Master", null, subBarang, subJenisBarang, subSupplier, subUser);
        
        ItemMenu subPemesanan = new ItemMenu(null, true, iconPemesananBarang, "Pemesanan Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                String Id = lb_id.getText();
                mainPanel.add(new Transaksi_Pemesanan(Id));
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        
        ItemMenu subMasuk = new ItemMenu(null, true, iconBarangMasuk, "Barang Masuk", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                String Id = lb_id.getText();
                mainPanel.add(new Transaksi_BarangMasuk(Id));
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        
        ItemMenu subKeluar = new ItemMenu(null, true, iconBarangKeluar, "Barang Keluar", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                String Id = lb_id.getText();
                mainPanel.add(new Transaksi_BarangKeluar(Id));
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        
        ItemMenu menuTransaksi= new ItemMenu(iconTransaksi, false, null, "Transaksi", null, subPemesanan, subMasuk, subKeluar);
        
        ItemMenu subLaporanBarang = new ItemMenu(null, true, iconLaporanBarang, "Laporan Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                String Id = lb_id.getText();
                mainPanel.add(new Laporan_Barang(Id));
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        
        ItemMenu subLaporanPemesanan = new ItemMenu(null, true, iconLaporanPemesanan, "Laporan Pemesanan", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                String Id = lb_id.getText();
                mainPanel.add(new Laporan_Pemesanan(Id));
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        
        ItemMenu subLaporanBarangMasuk = new ItemMenu(null, true, iconLaporanBarangMasuk, "Laporan Barang Masuk", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                String Id = lb_id.getText();
                mainPanel.add(new Laporan_BarangMasuk(Id));
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        
        ItemMenu subLaporanBarangKeluar = new ItemMenu(null, true, iconLaporanBarangKeluar, "Laporan Barang Keluar", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                String Id = lb_id.getText();
                mainPanel.add(new Laporan_BarangKeluar(Id));
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
        
        ItemMenu menuLaporan = new ItemMenu(iconLaporan, false, null, "Laporan", null, subLaporanBarang, subLaporanPemesanan, subLaporanBarangMasuk, subLaporanBarangKeluar);
        
        ItemMenu menuAbout = new ItemMenu(iconAbout, false, null, "About Us", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean closable = true;
                Form_About ab = new Form_About(null, closable);
                ab.setVisible(true);
            }
        });
    
        
        if(login_Model.getLevel().equals("Owner")){
            addMenu(menuHome, menuMaster, menuTransaksi, menuLaporan, menuAbout);
        }
        else if(login_Model.getLevel().equals("Admin")){
            addMenu(menuHome, menuMaster, menuTransaksi, menuLaporan, menuAbout);
        }
        else {
            addMenu(menuHome,menuTransaksi,menuLaporan);
        }
    }
    
    private void addMenu(ItemMenu... menu) {
        for (int i = 0; i < menu.length; i++) {
            panel_menu.add(menu[i]);
            ArrayList<ItemMenu> subMenu = menu[i].getSubMenu();
            for (ItemMenu m : subMenu) {
                addMenu(m);
            }
        }
        panel_menu.revalidate();
    }
    
    public JPanel getMainPanel() {
        return mainPanel;
    }
    
}
