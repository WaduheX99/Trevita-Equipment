/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.tempPemesananModel;

/**
 *
 * @author ASUS
 */
public interface serviceTempPemesanan {
    void addData (tempPemesananModel temp_Pemesanan);
    void updateData (tempPemesananModel temp_Pemesanan);
    void deleteData (tempPemesananModel temp_Pemesanan);
    
    tempPemesananModel getByid (String id);
    List<tempPemesananModel> getData();
}
