
package view;

import dao.daoLaporan;
import java.text.SimpleDateFormat;
import service.serviceLaporan;

public class Laporan_Pemesanan extends javax.swing.JPanel {

    private serviceLaporan servis_lap = new daoLaporan();
    
    public Laporan_Pemesanan(String Id) {
        initComponents();
        lb_id.setText(Id);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        tampilData = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        pn_pilihLaporan = new javax.swing.JPanel();
        cbx_laporan = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btn_batal = new rojerusan.RSMaterialButtonRectangle();
        pn_main = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pn_perTransaksi = new javax.swing.JPanel();
        btn_printDataBarang = new rojerusan.RSMaterialButtonRectangle();
        t_noTransaksi = new javax.swing.JTextField();
        btn_pilih = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pn_perPeriode = new javax.swing.JPanel();
        btn_printPeriode = new rojerusan.RSMaterialButtonRectangle();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        pn_perBulan = new javax.swing.JPanel();
        btn_printPerbulan = new rojerusan.RSMaterialButtonRectangle();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbx_bulan = new javax.swing.JComboBox<>();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        pn_perSupplier = new javax.swing.JPanel();
        btn_printDataBarang1 = new rojerusan.RSMaterialButtonRectangle();
        t_id = new javax.swing.JTextField();
        btn_pilih1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pn_tampilLaporan = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        tampilData.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel1.setText("Laporan Pemesanan Barang");

        lb_id.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_id.setText("ID");

        pn_pilihLaporan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbx_laporan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Jenis Laporan --", "Per Transaksi", "Per Supplier", "Per Periode", "Per Bulan" }));
        cbx_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_laporanActionPerformed(evt);
            }
        });
        pn_pilihLaporan.add(cbx_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 51, 274, 40));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("Pilih Jenis Laporan");
        pn_pilihLaporan.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 14, -1, -1));

        btn_batal.setBackground(java.awt.Color.orange);
        btn_batal.setText("KEMBALI");
        btn_batal.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        pn_pilihLaporan.add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 274, 40));

        pn_main.setBackground(new java.awt.Color(255, 255, 255));
        pn_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MAIN");

        javax.swing.GroupLayout pn_mainLayout = new javax.swing.GroupLayout(pn_main);
        pn_main.setLayout(pn_mainLayout);
        pn_mainLayout.setHorizontalGroup(
            pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_mainLayout.setVerticalGroup(
            pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_mainLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel3)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pn_pilihLaporan.add(pn_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 109, 274, 200));

        pn_perTransaksi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_printDataBarang.setBackground(new java.awt.Color(0, 153, 153));
        btn_printDataBarang.setText("PRINT");
        btn_printDataBarang.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_printDataBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printDataBarangActionPerformed(evt);
            }
        });

        t_noTransaksi.setText("No Transaksi");

        btn_pilih.setText("...");
        btn_pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pilihActionPerformed(evt);
            }
        });

        jLabel4.setText("Pilih No Transaksi");

        javax.swing.GroupLayout pn_perTransaksiLayout = new javax.swing.GroupLayout(pn_perTransaksi);
        pn_perTransaksi.setLayout(pn_perTransaksiLayout);
        pn_perTransaksiLayout.setHorizontalGroup(
            pn_perTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_perTransaksiLayout.createSequentialGroup()
                .addGroup(pn_perTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_perTransaksiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(t_noTransaksi)
                        .addGap(18, 18, 18)
                        .addComponent(btn_pilih))
                    .addGroup(pn_perTransaksiLayout.createSequentialGroup()
                        .addGroup(pn_perTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_perTransaksiLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(btn_printDataBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn_perTransaksiLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(0, 56, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_perTransaksiLayout.setVerticalGroup(
            pn_perTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_perTransaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_perTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_noTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btn_printDataBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pn_pilihLaporan.add(pn_perTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 109, 274, 200));

        pn_perPeriode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_printPeriode.setBackground(new java.awt.Color(0, 153, 153));
        btn_printPeriode.setText("PRINT");
        btn_printPeriode.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_printPeriode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printPeriodeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Dari Tanggal");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sampai Tanggal");

        javax.swing.GroupLayout pn_perPeriodeLayout = new javax.swing.GroupLayout(pn_perPeriode);
        pn_perPeriode.setLayout(pn_perPeriodeLayout);
        pn_perPeriodeLayout.setHorizontalGroup(
            pn_perPeriodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_perPeriodeLayout.createSequentialGroup()
                .addGroup(pn_perPeriodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_perPeriodeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pn_perPeriodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pn_perPeriodeLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btn_printPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pn_perPeriodeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_perPeriodeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_perPeriodeLayout.setVerticalGroup(
            pn_perPeriodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_perPeriodeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_printPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pn_pilihLaporan.add(pn_perPeriode, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 109, 274, 200));

        pn_perBulan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_printPerbulan.setBackground(new java.awt.Color(0, 153, 153));
        btn_printPerbulan.setText("PRINT");
        btn_printPerbulan.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_printPerbulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printPerbulanActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Bulan");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tahun");

        cbx_bulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Bulan --", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        javax.swing.GroupLayout pn_perBulanLayout = new javax.swing.GroupLayout(pn_perBulan);
        pn_perBulan.setLayout(pn_perBulanLayout);
        pn_perBulanLayout.setHorizontalGroup(
            pn_perBulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_perBulanLayout.createSequentialGroup()
                .addGroup(pn_perBulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_perBulanLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btn_printPerbulan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pn_perBulanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pn_perBulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
                    .addGroup(pn_perBulanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbx_bulan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_perBulanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_perBulanLayout.setVerticalGroup(
            pn_perBulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_perBulanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_printPerbulan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pn_pilihLaporan.add(pn_perBulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 109, 274, 200));

        pn_perSupplier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_printDataBarang1.setBackground(new java.awt.Color(0, 153, 153));
        btn_printDataBarang1.setText("PRINT");
        btn_printDataBarang1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_printDataBarang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printDataBarang1ActionPerformed(evt);
            }
        });

        t_id.setText("Supplier");
        t_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_idActionPerformed(evt);
            }
        });

        btn_pilih1.setText("...");
        btn_pilih1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pilih1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Piliah Supplier");

        javax.swing.GroupLayout pn_perSupplierLayout = new javax.swing.GroupLayout(pn_perSupplier);
        pn_perSupplier.setLayout(pn_perSupplierLayout);
        pn_perSupplierLayout.setHorizontalGroup(
            pn_perSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_perSupplierLayout.createSequentialGroup()
                .addGroup(pn_perSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_perSupplierLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(t_id)
                        .addGap(18, 18, 18)
                        .addComponent(btn_pilih1))
                    .addGroup(pn_perSupplierLayout.createSequentialGroup()
                        .addGroup(pn_perSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_perSupplierLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(btn_printDataBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn_perSupplierLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addGap(0, 56, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_perSupplierLayout.setVerticalGroup(
            pn_perSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_perSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_perSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_id, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pilih1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btn_printDataBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pn_pilihLaporan.add(pn_perSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 109, 274, 200));

        javax.swing.GroupLayout pn_tampilLaporanLayout = new javax.swing.GroupLayout(pn_tampilLaporan);
        pn_tampilLaporan.setLayout(pn_tampilLaporanLayout);
        pn_tampilLaporanLayout.setHorizontalGroup(
            pn_tampilLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        pn_tampilLaporanLayout.setVerticalGroup(
            pn_tampilLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tampilDataLayout = new javax.swing.GroupLayout(tampilData);
        tampilData.setLayout(tampilDataLayout);
        tampilDataLayout.setHorizontalGroup(
            tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addComponent(pn_pilihLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pn_tampilLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tampilDataLayout.setVerticalGroup(
            tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_tampilLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_pilihLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPanel.add(tampilData, "card3");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        mainPanel.removeAll();
        String Id = lb_id.getText();
        mainPanel.add(new Laporan_Pemesanan(Id));
        mainPanel.repaint();
        mainPanel.revalidate();
        
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_printDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printDataBarangActionPerformed
        pn_tampilLaporan.removeAll();
        String no = t_noTransaksi.getText();
        servis_lap.lapPemesananPerTransaksi(pn_tampilLaporan,no);
    }//GEN-LAST:event_btn_printDataBarangActionPerformed

    private void cbx_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_laporanActionPerformed
        if(cbx_laporan.getSelectedItem()=="-- Pilih Jenis Laporan --"){
            pn_main.setVisible(true);
            pn_perTransaksi.setVisible(false);
            pn_perPeriode.setVisible(false);
            pn_perBulan.setVisible(false);
            pn_perSupplier.setVisible(false);
        }else if(cbx_laporan.getSelectedItem()=="Per Transaksi"){
            pn_main.setVisible(false);
            pn_perTransaksi.setVisible(true);
            pn_perPeriode.setVisible(false);
            pn_perBulan.setVisible(false);
            pn_perSupplier.setVisible(false);
        }else if(cbx_laporan.getSelectedItem()=="Per Periode"){
            pn_main.setVisible(false);
            pn_perTransaksi.setVisible(false);
            pn_perPeriode.setVisible(true);
            pn_perBulan.setVisible(false);
            pn_perSupplier.setVisible(false);
        }else if(cbx_laporan.getSelectedItem()=="Per Bulan"){
            pn_main.setVisible(false);
            pn_perTransaksi.setVisible(false);
            pn_perPeriode.setVisible(false);
            pn_perBulan.setVisible(true);
            pn_perSupplier.setVisible(false);
        }else if(cbx_laporan.getSelectedItem()=="Per Supplier"){
            pn_main.setVisible(false);
            pn_perTransaksi.setVisible(false);
            pn_perPeriode.setVisible(false);
            pn_perBulan.setVisible(false);
            pn_perSupplier.setVisible(true);
        } 
    }//GEN-LAST:event_cbx_laporanActionPerformed

    private void btn_printPeriodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printPeriodeActionPerformed
        pn_tampilLaporan.removeAll();
        
        String tgl = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tgl);
        String tgl1 = String.valueOf(fm.format(jDateChooser1.getDate()));
        String tgl2 = String.valueOf(fm.format(jDateChooser2.getDate()));
                        
        servis_lap.lapPemesananPerPeriode(pn_tampilLaporan,tgl1,tgl2);
    }//GEN-LAST:event_btn_printPeriodeActionPerformed

    private void btn_pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pilihActionPerformed
        boolean closable = true;
        Data_Pemesanan data = new Data_Pemesanan(null, closable);
        data.setVisible(true);

        t_noTransaksi.setText(data.psn.getNomor_pemesanan());
    }//GEN-LAST:event_btn_pilihActionPerformed

    private void btn_printPerbulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printPerbulanActionPerformed
        pn_tampilLaporan.removeAll();
        
        String bulan = cbx_bulan.getSelectedItem().toString();
        int tahun = jYearChooser1.getYear();
        
        servis_lap.lapPemesananPerBulan(pn_tampilLaporan, bulan, tahun);
    }//GEN-LAST:event_btn_printPerbulanActionPerformed

    private void btn_printDataBarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printDataBarang1ActionPerformed
        pn_tampilLaporan.removeAll();
        String id = t_id.getText();
        servis_lap.lapPemesananPerSupplier(pn_tampilLaporan,id);
    }//GEN-LAST:event_btn_printDataBarang1ActionPerformed

    private void btn_pilih1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pilih1ActionPerformed
        boolean closable = true;
        Data_Supplier data = new Data_Supplier(null, closable);
        data.setVisible(true);

        t_id.setText(data.model.getId_supplier());
    }//GEN-LAST:event_btn_pilih1ActionPerformed

    private void t_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_idActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btn_batal;
    private javax.swing.JButton btn_pilih;
    private javax.swing.JButton btn_pilih1;
    private rojerusan.RSMaterialButtonRectangle btn_printDataBarang;
    private rojerusan.RSMaterialButtonRectangle btn_printDataBarang1;
    private rojerusan.RSMaterialButtonRectangle btn_printPerbulan;
    private rojerusan.RSMaterialButtonRectangle btn_printPeriode;
    private javax.swing.JComboBox<String> cbx_bulan;
    private javax.swing.JComboBox<String> cbx_laporan;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel lb_id;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pn_main;
    private javax.swing.JPanel pn_perBulan;
    private javax.swing.JPanel pn_perSupplier;
    private javax.swing.JPanel pn_perPeriode;
    private javax.swing.JPanel pn_perTransaksi;
    private javax.swing.JPanel pn_pilihLaporan;
    private javax.swing.JPanel pn_tampilLaporan;
    private javax.swing.JTextField t_id;
    private javax.swing.JTextField t_noTransaksi;
    private javax.swing.JPanel tampilData;
    // End of variables declaration//GEN-END:variables

}