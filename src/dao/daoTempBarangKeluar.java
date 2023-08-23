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
import model.detailBarangKeluarModel;
import model.tempBarangKeluarModel;
import service.serviceTempBarangKeluar;

/**
 *
 * @author ASUS
 */
public class daoTempBarangKeluar implements serviceTempBarangKeluar{

    private Connection conn;
    
    public daoTempBarangKeluar() {
        conn = koneksi.getConnection();
    }

    @Override
    public void addData(tempBarangKeluarModel temp_keluar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO temp_barang_keluar (kode_barang, nama_barang, harga, jml_keluar, subtotal_keluar) VALUES (?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, temp_keluar.getBarang_Model().getKode_barang());
            st.setString(2, temp_keluar.getBarang_Model().getNama_barang());
            st.setLong  (3, temp_keluar.getBarang_Model().getHarga());
            st.setLong  (4, temp_keluar.getDetailKeluar_Model().getJml_keluar());
            st.setLong  (5, temp_keluar.getDetailKeluar_Model().getSubtotal_keluar());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(daoTempBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(daoTempBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void updateData(tempBarangKeluarModel temp_keluar) {
        PreparedStatement st = null;
        String sql = "UPDATE temp_barang_keluar SET nama_barang=?, harga=?, jml_keluar=?, subtotal_keluar=? WHERE kode_barang='"+temp_keluar.getBarang_Model().getKode_barang()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, temp_keluar.getBarang_Model().getNama_barang());
            st.setLong  (2, temp_keluar.getBarang_Model().getHarga());
            st.setLong  (3, temp_keluar.getDetailKeluar_Model().getJml_keluar());
            st.setLong  (4, temp_keluar.getDetailKeluar_Model().getSubtotal_keluar());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(daoTempBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(daoTempBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void deleteData(tempBarangKeluarModel temp_keluar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM temp_barang_keluar WHERE kode_barang=? AND nama_barang=? AND harga=? AND jml_keluar=? AND subtotal_keluar=?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, temp_keluar.getBarang_Model().getKode_barang());
            st.setString(2, temp_keluar.getBarang_Model().getNama_barang());
            st.setLong  (3, temp_keluar.getBarang_Model().getHarga());
            st.setLong  (4, temp_keluar.getDetailKeluar_Model().getJml_keluar());
            st.setLong  (5, temp_keluar.getDetailKeluar_Model().getSubtotal_keluar());            
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoTempBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoTempBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public tempBarangKeluarModel getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<tempBarangKeluarModel> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM temp_barang_keluar";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                tempBarangKeluarModel smt = new tempBarangKeluarModel();
                barangModel brg = new barangModel();
                detailBarangKeluarModel det = new detailBarangKeluarModel();
                
                brg.setKode_barang          (rs.getString ("kode_barang"));
                brg.setNama_barang          (rs.getString ("nama_barang"));
                brg.setHarga                (rs.getLong ("harga"));
                
                det.setJml_keluar           (rs.getInt    ("jml_keluar"));
                det.setSubtotal_keluar      (rs.getLong   ("subtotal_keluar"));
                
                smt.setBarang_Model(brg);
                smt.setDetailKeluar_Model(det);
                
                list.add(smt);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoTempBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoTempBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoTempBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }
    
}
