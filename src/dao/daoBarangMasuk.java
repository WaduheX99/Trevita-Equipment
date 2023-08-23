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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.barangMasukModel;
import model.supplierModel;
import model.pemesananModel;
import model.userModel;
import service.serviceBarangMasuk;

/**
 *
 * @author ASUS
 */
public class daoBarangMasuk implements serviceBarangMasuk{

    private Connection conn;
    
    public daoBarangMasuk() {
        conn = koneksi.getConnection();
    }

    @Override
    public void addData(barangMasukModel barangMasuk) {
        PreparedStatement st = null;
        String sql = "INSERT INTO barang_masuk (nomor_masuk, tgl_masuk, total_masuk, id_supplier, id_user) VALUES (?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, barangMasuk.getNomor_masuk());
            st.setString(2, barangMasuk.getTgl_masuk());
            st.setLong  (3, barangMasuk.getTotal_masuk());
            st.setString(4, barangMasuk.getSupplier_Model().getId_supplier());
            st.setString(5, barangMasuk.getUser_Model().getId_user());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(daoBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(daoBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }
    
    @Override
    public void deleteData(barangMasukModel barangMasuk) {
        PreparedStatement st = null;
        String sql = "DELETE FROM barang_masuk WHERE nomor_masuk=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, barangMasuk.getNomor_masuk());
            
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void updateStatus(String kode_barang) {
        PreparedStatement st = null;
        String sql = "UPDATE detail_pemesanan SET status='Barang Telah Datang' WHERE kode_barang='"+kode_barang+"'";
    
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Perbarui Status Barang");
            java.util.logging.Logger.getLogger(daoBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @Override
    public barangMasukModel getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<barangMasukModel> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM barang_masuk";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                barangMasukModel masuk = new barangMasukModel();
                supplierModel sup = new supplierModel();
                userModel usr = new userModel();
                
                masuk.setNomor_masuk       (rs.getString ("nomor_masuk"));
                masuk.setTgl_masuk      (rs.getString ("tgl_masuk"));
                masuk.setTotal_masuk    (rs.getLong("total_masuk"));
                sup.setId_supplier   (rs.getString("id_supplier"));
                usr.setId_user     (rs.getString("id_user"));
                                
                masuk.setSupplier_Model(sup);
                masuk.setUser_Model(usr);
                list.add(masuk);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<barangMasukModel> search(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM barang_masuk WHERE nomor_masuk LIKE '%"+id+"%' OR tgl_masuk LIKE '%"+id+"%' OR total_masuk LIKE '%"+id+"%' OR id_supplier LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                pemesananModel psn = new pemesananModel();
                supplierModel sup = new supplierModel();
                userModel usr = new userModel();

                psn.setNomor_pemesanan       (rs.getString ("nomor_masuk"));
                psn.setTgl_pemesanan        (rs.getString ("tgl_masuk"));
                psn.setTotal_pemesanan      (rs.getLong   ("total_masuk"));
                sup.setId_supplier  (rs.getString ("id_supplier"));
                usr.setId_user    (rs.getString ("id_user"));
                
                psn.setSupplier_Model(sup);
                psn.setUser_Model(usr);
                                
                list.add(psn);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;

        Date now = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat noformat = new SimpleDateFormat("yyMMdd");
        String tgl = tanggal.format(now);
        String no = noformat.format(now);

        String sql = "SELECT RIGHT(nomor_masuk, 3) AS Nomor " +
                     "FROM barang_masuk " +
                     "WHERE nomor_masuk LIKE 'BM" + no + "%' " +
                     "ORDER BY nomor_masuk DESC " +
                     "LIMIT 1";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "BM" + no + String.format("%03d", nomor);
            } else {
                urutan = "BM" + no + "001";
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return urutan;
    }   
}