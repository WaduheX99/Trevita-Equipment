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
import model.barangModel;
import model.jenisBarangModel;
import service.serviceBarang;

public class daoBarang implements serviceBarang{

    private Connection conn;
    
    public daoBarang() {
        conn = koneksi.getConnection();   
    }
    
    @Override
    public void addData(barangModel barang_Model) {
        PreparedStatement st = null;
        String sql = "INSERT INTO barang (kode_barang, kode_jenis, nama_barang, satuan, harga, stok) VALUES (?,?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, barang_Model.getKode_barang());
            st.setString(2, barang_Model.getJenisBarang().getKode_jenis());
            st.setString(3, barang_Model.getNama_barang());
            st.setString(4, barang_Model.getSatuan());
            st.setLong  (5, barang_Model.getHarga());
            st.setInt   (6, barang_Model.getStok());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void updateData(barangModel barang_Model) {
        PreparedStatement st = null;
        String sql = "UPDATE barang SET  kode_jenis=?, nama_barang=?, satuan=?, harga=?, stok=? WHERE kode_barang='"+barang_Model.getKode_barang()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, barang_Model.getJenisBarang().getKode_jenis());
            st.setString(2, barang_Model.getNama_barang());
            st.setString(3, barang_Model.getSatuan());
            st.setLong  (4, barang_Model.getHarga());
            st.setInt   (5, barang_Model.getStok());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update Gagal");
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void deleteData(barangModel barang_Model) {
        PreparedStatement st = null;
        String sql = "DELETE FROM barang WHERE kode_barang=?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, barang_Model.getKode_barang());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public barangModel getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<barangModel> getDataByID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<barangModel> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT bg.kode_barang,bg.kode_jenis,jb.nama_jenis,bg.nama_barang,bg.satuan,bg.harga,bg.stok FROM barang bg INNER JOIN jenis_barang jb ON jb.kode_jenis=bg.kode_jenis";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                barangModel barang_Model = new barangModel();
                jenisBarangModel jenisBarang = new jenisBarangModel();

                barang_Model.setKode_barang    (rs.getString ("kode_barang"));
                jenisBarang.setKode_jenis       (rs.getString ("kode_jenis"));
                jenisBarang.setNama_jenis       (rs.getString ("nama_jenis"));
                barang_Model.setNama_barang    (rs.getString ("nama_barang"));
                barang_Model.setSatuan         (rs.getString ("satuan"));
                barang_Model.setHarga          (rs.getLong   ("harga"));
                barang_Model.setStok           (rs.getInt    ("stok"));
                
                barang_Model.setJenisBarang(jenisBarang);
                
                list.add(barang_Model);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<barangModel> search1(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT bg.kode_barang,bg.kode_jenis,jb.nama_jenis, "
                + "bg.nama_barang,bg.satuan,bg.harga,bg.stok FROM barang bg "
                + "INNER JOIN jenis_barang jb ON jb.kode_jenis=bg.kode_jenis WHERE kode_barang LIKE '%"+id+"%' OR nama_barang LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                barangModel barang_Model = new barangModel();
                jenisBarangModel jenisBarang = new jenisBarangModel();
                barang_Model.setKode_barang    (rs.getString ("kode_barang"));
                jenisBarang.setKode_jenis        (rs.getString ("kode_jenis"));
                jenisBarang.setNama_jenis        (rs.getString ("nama_jenis"));
                barang_Model.setNama_barang    (rs.getString ("nama_barang"));
                barang_Model.setSatuan         (rs.getString ("satuan"));
                barang_Model.setHarga          (rs.getLong   ("harga"));
                barang_Model.setStok           (rs.getInt    ("stok"));
                                
                barang_Model.setJenisBarang(jenisBarang);
                list.add(barang_Model);
            }
          return list;
        } catch (SQLException ex) {
            
            java.util.logging.Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<barangModel> search2(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nomor1() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;

        Date now = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat noformat = new SimpleDateFormat("yyMM");
        String tgl = tanggal.format(now);
        String no = noformat.format(now);

        String sql = "SELECT RIGHT(kode_barang, 3) AS Nomor " +
                     "FROM barang " +
                     "WHERE kode_barang LIKE 'B" + no + "%' " +
                     "ORDER BY kode_barang DESC " +
                     "LIMIT 1";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "B" + no + String.format("%03d", nomor);
            } else {
                urutan = "B" + no + "001";
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return urutan;

    }

    @Override
    public String nomor2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
