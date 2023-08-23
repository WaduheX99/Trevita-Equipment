/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.tempBarangMasukModel;

/**
 *
 * @author ASUS
 */
public interface serviceTempBarangMasuk {
    void addData (tempBarangMasukModel temp_Masuk);
    void updateData (tempBarangMasukModel temp_Masuk);
    void deleteData (tempBarangMasukModel temp_Masuk);
    
    tempBarangMasukModel getByid (String id);
    List<tempBarangMasukModel> getData();
}
