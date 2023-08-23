/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.barangModel;
import model.barangKeluarModel;
import model.detailBarangKeluarModel;
import service.serviceDetailBarangKeluar;

/**
 *
 * @author ASUS
 */
public class daoDetailBarangKeluar implements serviceDetailBarangKeluar{

    private Connection conn;

    public daoDetailBarangKeluar() {
        conn = koneksi.getConnection();
    }
    
    @Override
    public void addData(detailBarangKeluarModel mod_detkeluar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_barang_keluar (nomor_keluar, kode_barang, jml_keluar, subtotal_keluar)SELECT '"+mod_detkeluar.getBarangKeluar_Model().getNomor_keluar()+"', kode_barang, jml_keluar, subtotal_keluar FROM temp_barang_keluar";
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(daoDetailBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(daoDetailBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void sumTotal(detailBarangKeluarModel mod_detkeluar) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(subtotal_keluar) FROM temp_barang_keluar";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                mod_detkeluar.setSubtotal_keluar(rs.getLong(1));
            }
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoDetailBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoDetailBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusSementara(detailBarangKeluarModel mod_detkeluar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM temp_barang_keluar";
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoDetailBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoDetailBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }  
    }

    @Override
    public List<detailBarangKeluarModel> getData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT det_keluar.nomor_keluar, det_keluar.kode_barang, "
                + "brg.nama_barang, brg.harga, det_keluar.jml_keluar, "
                + "det_keluar.subtotal_keluar "
                + "FROM detail_barang_keluar det_keluar "
                + "INNER JOIN barang_keluar keluar ON keluar.nomor_keluar=det_keluar.nomor_keluar "
                + "INNER JOIN barang brg ON brg.kode_barang=det_keluar.kode_barang "
                + "WHERE det_keluar.nomor_keluar='"+id+"' ORDER BY nomor_keluar ASC";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                barangKeluarModel keluar = new barangKeluarModel();
                detailBarangKeluarModel det = new detailBarangKeluarModel();
                barangModel brg = new barangModel();
                
                keluar.setNomor_keluar(String.valueOf(rs.getString("det_keluar.nomor_keluar")));
                det.setBarangKeluar_Model(keluar);
                
                brg.setKode_barang      (rs.getString ("kode_barang"));
                brg.setNama_barang      (rs.getString ("nama_barang"));
                brg.setHarga            (rs.getLong   ("harga"));
                det.setJml_keluar       (rs.getInt("jml_keluar"));
                det.setSubtotal_keluar  (rs.getLong   ("subtotal_keluar"));
                                
                det.setBarang_Model(brg);
                
                list.add(det);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoDetailBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoDetailBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoDetailBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<detailBarangKeluarModel> search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validasiStok(detailBarangKeluarModel mod_detkeluar) {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean valid = false;
        String sql = "SELECT stok FROM barang WHERE kode_barang='"+mod_detkeluar.getBarang_Model().getKode_barang()+"' AND (stok<'"+mod_detkeluar.getJml_keluar()+"')";
        try{
            st = conn.prepareStatement(sql);
            rs= st.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Stok Barang "+mod_detkeluar.getBarang_Model().getNama_barang()+" tidak tersedia !!!","Peringatan",JOptionPane.WARNING_MESSAGE);
            }else {
                valid=true;
            }
        }catch (SQLException ex) {
                java.util.logging.Logger.getLogger(daoDetailBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                if (st!=null) {
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(daoDetailBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
            }
        return valid;
    }

    @Override
    public detailBarangKeluarModel getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }  
}