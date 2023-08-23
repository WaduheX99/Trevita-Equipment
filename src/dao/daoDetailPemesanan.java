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
import model.detailPemesananModel;
import model.pemesananModel;
import service.serviceDetailPemesanan;

/**
 *
 * @author ASUS
 */
public class daoDetailPemesanan implements serviceDetailPemesanan{

    private Connection conn;

    public daoDetailPemesanan() {
        conn = koneksi.getConnection();
    }
    
    @Override
    public void addData(detailPemesananModel detailPemesanan_Model) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_pemesanan (nomor_pemesanan, kode_barang, jml_pemesanan, subtotal_pemesanan, status)SELECT '"+detailPemesanan_Model.getPemesanan_Model().getNomor_pemesanan()+"', kode_barang, jml_pemesanan, subtotal_pemesanan, status FROM temp_pemesanan";
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(daoDetailPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(daoDetailPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void sumTotal(detailPemesananModel detailPemesanan_Model) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(subtotal_pemesanan) FROM temp_pemesanan";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                detailPemesanan_Model.setSubtotal_pemesanan(rs.getLong(1));
            }
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoDetailPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoDetailPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusSementara(detailPemesananModel detailPemesanan_Model) {
        PreparedStatement st = null;
        String sql = "DELETE FROM temp_pemesanan";
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoTempPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoTempPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public detailPemesananModel getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<detailPemesananModel> getData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT det_psn.nomor_pemesanan, det_psn.kode_barang, brg.nama_barang, "
                + "brg.harga, det_psn.jml_pemesanan, det_psn.subtotal_pemesanan, det_psn.status "
                + "FROM detail_pemesanan det_psn "
                + "INNER JOIN pemesanan psn ON psn.nomor_pemesanan=det_psn.nomor_pemesanan "
                + "INNER JOIN barang brg ON brg.kode_barang=det_psn.kode_barang "
                + "WHERE det_psn.nomor_pemesanan='"+id+"' ORDER BY nomor_pemesanan ASC";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                pemesananModel psn = new pemesananModel();
                detailPemesananModel det_psn = new detailPemesananModel();
                barangModel brg = new barangModel();
                
                psn.setNomor_pemesanan(String.valueOf(rs.getString("det_psn.nomor_pemesanan")));
                det_psn.setPemesanan_Model(psn);
                
                brg.setKode_barang (rs.getString ("kode_barang"));
                brg.setNama_barang (rs.getString ("nama_barang"));
                brg.setHarga (rs.getLong   ("harga"));
                det_psn.setJml_pemesanan (rs.getLong   ("jml_pemesanan"));
                det_psn.setSubtotal_pemesanan (rs.getLong   ("subtotal_pemesanan"));
                det_psn.setStatus (rs.getString ("status"));
                                
                det_psn.setBarang_Model(brg);
                
                list.add(det_psn);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoDetailPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoDetailPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoDetailPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<detailPemesananModel> search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}