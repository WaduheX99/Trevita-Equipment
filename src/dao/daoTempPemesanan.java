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
import model.detailPemesananModel;
import model.tempPemesananModel;
import service.serviceTempPemesanan;

/**
 *
 * @author ASUS
 */
public class daoTempPemesanan implements serviceTempPemesanan{

    private Connection conn;
    
    public daoTempPemesanan() {
        conn = koneksi.getConnection();
    }

    
    @Override
    public void addData(tempPemesananModel temp_Pemesanan) {
        PreparedStatement st = null;
        String sql = "INSERT INTO temp_pemesanan (kode_barang, nama_barang, harga, jml_pemesanan, subtotal_pemesanan, status) VALUES (?,?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, temp_Pemesanan.getBarang_Model().getKode_barang());
            st.setString(2, temp_Pemesanan.getBarang_Model().getNama_barang());
            st.setLong  (3, temp_Pemesanan.getBarang_Model().getHarga());
            st.setLong  (4, temp_Pemesanan.getDetailPemesanan_Model().getJml_pemesanan());
            st.setLong  (5, temp_Pemesanan.getDetailPemesanan_Model().getSubtotal_pemesanan());
            st.setString(6, temp_Pemesanan.getDetailPemesanan_Model().getStatus());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(daoTempPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(daoTempPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void updateData(tempPemesananModel temp_Pemesanan) {
        PreparedStatement st = null;
        String sql = "UPDATE temp_pemesanan SET nama_barang=?, harga=?, jml_pemesanan=?, subtotal_pemesanan=? WHERE kode_barang='"+temp_Pemesanan.getBarang_Model().getKode_barang()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, temp_Pemesanan.getBarang_Model().getNama_barang());
            st.setLong  (2, temp_Pemesanan.getBarang_Model().getHarga());
            st.setLong  (3, temp_Pemesanan.getDetailPemesanan_Model().getJml_pemesanan());
            st.setLong  (4, temp_Pemesanan.getDetailPemesanan_Model().getSubtotal_pemesanan());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(daoTempPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(daoTempPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void deleteData(tempPemesananModel temp_Pemesanan) {
        PreparedStatement st = null;
        String sql = "DELETE FROM temp_pemesanan WHERE kode_barang=? AND nama_barang=? AND harga=? AND jml_pemesanan=? AND subtotal_pemesanan=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, temp_Pemesanan.getBarang_Model().getKode_barang());
            st.setString(2, temp_Pemesanan.getBarang_Model().getNama_barang());
            st.setLong(3, temp_Pemesanan.getBarang_Model().getHarga());
            st.setLong(4, temp_Pemesanan.getDetailPemesanan_Model().getJml_pemesanan());
            st.setLong(5, temp_Pemesanan.getDetailPemesanan_Model().getSubtotal_pemesanan());
            
            
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
    public tempPemesananModel getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<tempPemesananModel> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM temp_pemesanan";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                tempPemesananModel smt = new tempPemesananModel();
                barangModel brg = new barangModel();
                detailPemesananModel det_psn = new detailPemesananModel();
                
                brg.setKode_barang  (rs.getString ("kode_barang"));
                brg.setNama_barang  (rs.getString ("nama_barang"));
                brg.setHarga        (rs.getLong ("harga"));
                
                det_psn.setJml_pemesanan(rs.getLong    ("jml_pemesanan"));
                det_psn.setSubtotal_pemesanan (rs.getLong   ("subtotal_pemesanan"));
                
                smt.setBarang_Model(brg);
                smt.setDetailPemesanan_Model(det_psn);
                
                list.add(smt);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoTempPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoTempPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoTempPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }
    
}
