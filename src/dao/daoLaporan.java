/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.koneksi;
import static config.koneksi.getConnection;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import service.serviceLaporan;



public class daoLaporan implements serviceLaporan{

    private Connection conn;
    
    public daoLaporan(){
        conn = koneksi.getConnection();
    }

    @Override
    public void suratJalanPemesanan(String no) {
        try {
                String reportPath = "src/laporan/SuratJalanPemesanan.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("no", no); // Menyimpan nomor pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void transaksiBarangMasuk(String no) {
        try {
                String reportPath = "src/laporan/TransaksiBarangMasuk.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("no", no); // Menyimpan nomor pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void transaksiBarangKeluar(String no) {
        try {
                String reportPath = "src/laporan/TransaksiBarangKeluar.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("no", no); // Menyimpan nomor pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void lapDataBarang(JPanel jp) {
        try {
                String reportPath = "src/laporan/LapDataBarang.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
               
                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void lapTransaksiBarang(JPanel jp) {
        try {
                String reportPath = "src/laporan/LapStokBarang.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
               
                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void lapPemesananPerTransaksi(JPanel jp, String no) {
        try {
                String reportPath = "src/laporan/LapPesanPerTransaksi.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("no", no); // Menyimpan nomor pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    
    @Override
    public void lapPemesananPerPeriode(JPanel jp, String tgl1, String tgl2) {
        try {
                String reportPath = "src/laporan/LapPesanPerPeriode.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("tgl1", tgl1);
                parameters.put("tgl2", tgl2);

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void lapBarangMasukPerPeriode(JPanel jp, String tgl1, String tgl2) {
        try {
                String reportPath = "src/laporan/LapBarangMasukPerPeriode.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("tgl1", tgl1);
                parameters.put("tgl2", tgl2);

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    
    @Override
    public void lapBarangKeluarPerPeriode(JPanel jp, String tgl1, String tgl2) {
        try {
                String reportPath = "src/laporan/LapKeluarPerPeriode.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("tgl1", tgl1);
                parameters.put("tgl2", tgl2);

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void lapPemesananPerBulan(JPanel jp, String dt1, int dt2) {
        try {
                String reportPath = "src/laporan/LapPesanPerPerbulan.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("dt1", dt1);
                parameters.put("dt2", dt2);

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void lapPemesananPerSupplier(JPanel jp, String id) {
        try {
                String reportPath = "src/laporan/LapPesanPerSupplier.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("id", id);

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }   
}