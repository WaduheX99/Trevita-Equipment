
package view;

import dao.daoLaporan;
import java.text.SimpleDateFormat;
import service.serviceLaporan;

public class Laporan_BarangMasuk extends javax.swing.JPanel {

    private serviceLaporan servis_lap = new daoLaporan();
    
    public Laporan_BarangMasuk(String Id) {
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
        t_noTransaksi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pn_perPeriode = new javax.swing.JPanel();
        btn_printPeriode = new rojerusan.RSMaterialButtonRectangle();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbx_bulan = new javax.swing.JComboBox<>();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        t_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pn_tampilLaporan = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        tampilData.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel1.setText("Laporan Barang Masuk");

        lb_id.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_id.setText("ID");

        pn_pilihLaporan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbx_laporan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Jenis Laporan --", "Per Periode"}));
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

        t_noTransaksi.setText("No Transaksi");

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Bulan");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tahun");

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
        mainPanel.add(new Laporan_BarangMasuk(Id));
        mainPanel.repaint();
        mainPanel.revalidate();
        
    }//GEN-LAST:event_btn_batalActionPerformed

    private void cbx_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_laporanActionPerformed
        if(cbx_laporan.getSelectedItem()=="-- Pilih Jenis Laporan --"){
            pn_main.setVisible(true);
            pn_perPeriode.setVisible(false);
        }else if(cbx_laporan.getSelectedItem()=="Per Periode"){
            pn_main.setVisible(false);
            pn_perPeriode.setVisible(true);
        }
    }//GEN-LAST:event_cbx_laporanActionPerformed

    private void btn_printPeriodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printPeriodeActionPerformed
        pn_tampilLaporan.removeAll();
        
        String tgl = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tgl);
        String tgl1 = String.valueOf(fm.format(jDateChooser1.getDate()));
        String tgl2 = String.valueOf(fm.format(jDateChooser2.getDate()));
                        
        servis_lap.lapBarangMasukPerPeriode(pn_tampilLaporan,tgl1,tgl2);
    }//GEN-LAST:event_btn_printPeriodeActionPerformed


    private void t_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_idActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btn_batal;
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
    private javax.swing.JPanel pn_perPeriode;
    private javax.swing.JPanel pn_pilihLaporan;
    private javax.swing.JPanel pn_tampilLaporan;
    private javax.swing.JTextField t_id;
    private javax.swing.JTextField t_noTransaksi;
    private javax.swing.JPanel tampilData;
    // End of variables declaration//GEN-END:variables

}