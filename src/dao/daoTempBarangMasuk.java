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
import model.detailBarangMasukModel;
import model.tempBarangMasukModel;
import service.serviceTempBarangMasuk;

/**
 *
 * @author Uhnuy Kozuki
 */
public class daoTempBarangMasuk implements serviceTempBarangMasuk{

    private Connection conn;
    
    public daoTempBarangMasuk() {
        conn = koneksi.getConnection();
    }
    
    @Override
    public void addData(tempBarangMasukModel temp_Masuk) {
        PreparedStatement st = null;
        String sql = "INSERT INTO temp_barang_masuk (kode_barang, nama_barang, harga, jml_masuk, subtotal_masuk) VALUES (?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, temp_Masuk.getBarang_Model().getKode_barang());
            st.setString(2, temp_Masuk.getBarang_Model().getNama_barang());
            st.setLong  (3, temp_Masuk.getBarang_Model().getHarga());
            st.setLong  (4, temp_Masuk.getDetailMasuk_Model().getJml_masuk());
            st.setLong  (5, temp_Masuk.getDetailMasuk_Model().getSubtotal_masuk());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(daoTempBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(daoTempBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void updateData(tempBarangMasukModel temp_Masuk) {
        PreparedStatement st = null;
        String sql = "UPDATE temp_barang_masuk SET nama_barang=?, harga=?, jml_masuk=?, subtotal_masuk=? WHERE kode_barang='"+temp_Masuk.getBarang_Model().getKode_barang()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, temp_Masuk.getBarang_Model().getNama_barang());
            st.setLong  (2, temp_Masuk.getBarang_Model().getHarga());
            st.setLong  (3, temp_Masuk.getDetailMasuk_Model().getJml_masuk());
            st.setLong  (4, temp_Masuk.getDetailMasuk_Model().getSubtotal_masuk());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(daoTempBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(daoTempBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void deleteData(tempBarangMasukModel temp_Masuk) {
        PreparedStatement st = null;
        String sql = "DELETE FROM temp_barang_masuk WHERE kode_barang=? AND nama_barang=? AND harga=? AND jml_masuk=? AND subtotal_masuk=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, temp_Masuk.getBarang_Model().getKode_barang());
            st.setString(2, temp_Masuk.getBarang_Model().getNama_barang());
            st.setLong(3, temp_Masuk.getBarang_Model().getHarga());
            st.setLong  (4, temp_Masuk.getDetailMasuk_Model().getJml_masuk());
            st.setLong  (5, temp_Masuk.getDetailMasuk_Model().getSubtotal_masuk());
            
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoTempBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoTempBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public tempBarangMasukModel getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<tempBarangMasukModel> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM temp_barang_masuk";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                tempBarangMasukModel smt = new tempBarangMasukModel();
                barangModel brg = new barangModel();
                detailBarangMasukModel det_masuk = new detailBarangMasukModel();
                
                brg.setKode_barang          (rs.getString ("kode_barang"));
                brg.setNama_barang          (rs.getString ("nama_barang"));
                brg.setHarga                (rs.getLong ("harga"));
                
                det_masuk.setJml_masuk      (rs.getInt    ("jml_masuk"));
                det_masuk.setSubtotal_masuk (rs.getLong   ("subtotal_masuk"));
                
                smt.setBarang_Model(brg);
                smt.setDetailMasuk_Model(det_masuk);
                
                list.add(smt);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoTempBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoTempBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoTempBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }
    
}
