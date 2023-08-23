/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Main.MainMenu;
import config.koneksi;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.loginModel;
import service.serviceLogin;
import view.Form_Login;

/**
 *
 * @author ASUS
 */
public class daoLogin implements serviceLogin{
    
    private Connection conn;
    
    public daoLogin() {
        conn = koneksi.getConnection();
    }

    @Override
    public void prosesLogin(loginModel login) {
        PreparedStatement st = null;
        ResultSet rs        = null;
        String Id           = null;
        String Nama         = null;
        String Level2       = null;
        String Username     = null;
        String sql = "SELECT * FROM user WHERE(id_user='"+login.getId_user()+"'OR username='"+login.getUsername()+"') AND password='"+Encrypt.getmd5java(login.getPass_user())+"'";
         
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                Id   = rs.getString("id_user");
                Nama = rs.getString("nama_user");
                Level2 = rs.getString("level");
                Username = rs.getString("username");
                Blob gambarBlob = rs.getBlob("gambar");
                
                loginModel mod = new loginModel();
                mod.setId_user(Id);
                mod.setNama_user(Nama);
                mod.setUsername(Username);
                mod.setLevel(Level2);
                mod.setGambar(gambarBlob);
                
                MainMenu menu = new MainMenu(mod);
                menu.setVisible(true);
                menu.revalidate();
                
                Form_Login lg = new Form_Login();
                lg.tutup = true;
            }else{
                JOptionPane.showMessageDialog(null, "Username dan Password salah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                Form_Login lg = new Form_Login();
                lg.tutup = false;
            }
        }catch(SQLException ex) {
            Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } 
}
