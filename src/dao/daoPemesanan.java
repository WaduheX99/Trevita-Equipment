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
import model.supplierModel;
import model.pemesananModel;
import model.userModel;
import service.servicePemesanan;

/**
 *
 * @author ASUS
 */
public class daoPemesanan implements servicePemesanan{

    private Connection conn;
    
    public daoPemesanan() {
        conn = koneksi.getConnection();
    }
    

    @Override
    public void addData(pemesananModel pemesanan_Model) {
        PreparedStatement st = null;
        String sql = "INSERT INTO pemesanan (nomor_pemesanan, tgl_pemesanan, total_pemesanan, id_supplier, id_user) VALUES (?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, pemesanan_Model.getNomor_pemesanan());
            st.setString(2, pemesanan_Model.getTgl_pemesanan());
            st.setLong  (3, pemesanan_Model.getTotal_pemesanan());
            st.setString(4, pemesanan_Model.getSupplier_Model().getId_supplier());
            st.setString(5, pemesanan_Model.getUser_Model().getId_user());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(daoPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(daoPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }
    
    @Override
    public void deleteData(pemesananModel pemesanan_Model) {
        PreparedStatement st = null;
        String sql = "DELETE FROM pemesanan WHERE nomor_pemesanan=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, pemesanan_Model.getNomor_pemesanan());
            
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public pemesananModel getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<pemesananModel> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM pemesanan";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                pemesananModel psn = new pemesananModel();
                supplierModel dst = new supplierModel();
                userModel pgn = new userModel();
                
                psn.setNomor_pemesanan(rs.getString ("nomor_pemesanan"));
                psn.setTgl_pemesanan(rs.getString ("tgl_pemesanan"));
                psn.setTotal_pemesanan(rs.getLong("total_pemesanan"));
                dst.setId_supplier(rs.getString("id_supplier"));
                pgn.setId_user(rs.getString("id_user"));
                                
                psn.setSupplier_Model(dst);
                psn.setUser_Model(pgn);
                list.add(psn);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<pemesananModel> search(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM pemesanan WHERE nomor_pemesanan LIKE '%"+id+"%' OR tgl_pemesanan LIKE '%"+id+"%' OR total_pemesanan LIKE '%"+id+"%' OR id_supplier LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                pemesananModel psn = new pemesananModel();
                supplierModel dst = new supplierModel();
                userModel pgn = new userModel();

                psn.setNomor_pemesanan         (rs.getString ("nomor_pemesanan"));
                psn.setTgl_pemesanan        (rs.getString ("tgl_pemesanan"));
                psn.setTotal_pemesanan      (rs.getLong   ("total_pemesanan"));
                dst.setId_supplier   (rs.getString ("id_supplier"));
                pgn.setId_user      (rs.getString ("id_user"));
                
                psn.setSupplier_Model(dst);
                psn.setUser_Model(pgn);
                                
                list.add(psn);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoPemesanan.class.getName()).log(Level.SEVERE, null, ex);
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

        String sql = "SELECT RIGHT(nomor_pemesanan, 3) AS Nomor " +
                     "FROM pemesanan " +
                     "WHERE nomor_pemesanan LIKE 'PB" + no + "%' " +
                     "ORDER BY nomor_pemesanan DESC " +
                     "LIMIT 1";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "PB" + no + String.format("%03d", nomor);
            } else {
                urutan = "PB" + no + "001";
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

    @Override
    public void updateData(pemesananModel pemesanan_Model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}