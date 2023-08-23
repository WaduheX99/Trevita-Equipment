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
import model.barangModel;
import model.barangMasukModel;
import model.detailBarangMasukModel;
import service.serviceBarangMasuk;
import service.serviceDetailBarangMasuk;

/**
 *
 * @author ASUS
 */
public class daoDetailBarangMasuk implements serviceDetailBarangMasuk{

    private Connection conn;

    public daoDetailBarangMasuk() {
        conn = koneksi.getConnection();
    }

    @Override
    public void addData(detailBarangMasukModel detail_BarangMasuk) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_barang_masuk (nomor_masuk, kode_barang, jml_masuk, subtotal_masuk)SELECT '"+detail_BarangMasuk.getBarangMasuk_Model().getNomor_masuk()+"', kode_barang, jml_masuk, subtotal_masuk FROM temp_barang_masuk";
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(daoDetailBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(daoDetailBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void sumTotal(detailBarangMasukModel detail_BarangMasuk) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(subtotal_masuk) FROM temp_barang_masuk";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                detail_BarangMasuk.setSubtotal_masuk(rs.getLong(1));
            }
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoDetailBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoDetailBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusSementara(detailBarangMasukModel detail_BarangMasuk) {
        PreparedStatement st = null;
        String sql = "DELETE FROM temp_barang_masuk";
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoDetailBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoDetailBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public List<detailBarangMasukModel> getData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT det_masuk.nomor_masuk, det_masuk.kode_barang, "
                + "brg.nama_barang, brg.harga, det_masuk.jml_masuk, "
                + "det_masuk.subtotal_masuk "
                + "FROM detail_barang_masuk det_masuk "
                + "INNER JOIN barang_masuk masuk ON masuk.nomor_masuk=det_masuk.nomor_masuk "
                + "INNER JOIN barang brg ON brg.kode_barang=det_masuk.kode_barang "
                + "WHERE det_masuk.nomor_masuk='"+id+"' ORDER BY nomor_masuk ASC";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                barangMasukModel masuk = new barangMasukModel();
                detailBarangMasukModel det_masuk = new detailBarangMasukModel();
                barangModel brg = new barangModel();
                
                masuk.setNomor_masuk(String.valueOf(rs.getString("det_masuk.nomor_masuk")));
                det_masuk.setBarangMasuk_Model(masuk);
                
                brg.setKode_barang      (rs.getString ("kode_barang"));
                brg.setNama_barang      (rs.getString ("nama_barang"));
                brg.setHarga            (rs.getLong   ("harga"));
                det_masuk.setJml_masuk  (rs.getInt("jml_masuk"));
                det_masuk.setSubtotal_masuk(rs.getLong   ("subtotal_masuk"));
                                
                det_masuk.setBarang_Model(brg);
                
                list.add(det_masuk);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoDetailBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoDetailBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoDetailBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public detailBarangMasukModel getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
