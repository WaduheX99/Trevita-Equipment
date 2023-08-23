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
import model.barangKeluarModel;
import model.supplierModel;
import model.userModel;
import service.serviceBarangKeluar;

/**
 *
 * @author ASUS
 */
public class daoBarangKeluar implements serviceBarangKeluar{
    
    private Connection conn;
    
    public daoBarangKeluar() {
        conn = koneksi.getConnection();
    }

    @Override
    public void addData(barangKeluarModel mod_keluar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO barang_keluar (nomor_keluar, tgl_keluar, total_keluar, id_user) VALUES (?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_keluar.getNomor_keluar());
            st.setString(2, mod_keluar.getTgl_keluar());
            st.setLong  (3, mod_keluar.getTotal_keluar());
            st.setString(4, mod_keluar.getUser_Model().getId_user());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(daoBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(daoBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void deleteData(barangKeluarModel mod_keluar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM barang_keluar WHERE nomor_keluar=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mod_keluar.getNomor_keluar());
            
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    
    @Override
    public barangKeluarModel getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<barangKeluarModel> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM barang_keluar";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                barangKeluarModel keluar = new barangKeluarModel();
                userModel usr = new userModel();
                
                keluar.setNomor_keluar       (rs.getString ("nomor_keluar"));
                keluar.setTgl_keluar      (rs.getString ("tgl_keluar"));
                keluar.setTotal_keluar    (rs.getLong("total_keluar"));
                usr.setId_user      (rs.getString("id_user"));
                                
                keluar.setUser_Model(usr);
                list.add(keluar);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<barangKeluarModel> search(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM barang_keluar WHERE nomor_keluar LIKE '%"+id+"%' OR tgl_keluar LIKE '%"+id+"%' OR total_keluar LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                barangKeluarModel keluar = new barangKeluarModel();
                userModel usr = new userModel();
                
                keluar.setNomor_keluar       (rs.getString ("nomor_keluar"));
                keluar.setTgl_keluar      (rs.getString ("tgl_keluar"));
                keluar.setTotal_keluar    (rs.getLong("total_keluar"));
                usr.setId_user      (rs.getString("id_user"));
                                
                keluar.setUser_Model(usr);
                list.add(keluar);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
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

        String sql = "SELECT RIGHT(nomor_keluar, 3) AS Nomor " +
                     "FROM barang_keluar " +
                     "WHERE nomor_keluar LIKE 'BK" + no + "%' " +
                     "ORDER BY nomor_keluar DESC " +
                     "LIMIT 1";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "BK" + no + String.format("%03d", nomor);
            } else {
                urutan = "BK" + no + "001";
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