/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import javax.swing.JLabel;
import model.userModel;

/**
 *
 * @author ASUS
 */
public interface serviceUser {
    void addData (userModel user_Model);
    void updateData (userModel user_Model);
    void deleteData (userModel user_Model);
    
    userModel getByid (String id);
    List<userModel> getData();
    List<userModel> search(String id);
    
    String nomor();
    boolean validateOldPassword(String username, String oldPassword);
    boolean changePassword(String username, String oldPassword, String newPassword);
    void tampilGambar(JLabel lb_gambar, String id);
}
