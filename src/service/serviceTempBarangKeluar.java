/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.tempBarangKeluarModel;

/**
 *
 * @author ASUS
 */
public interface serviceTempBarangKeluar {
    void addData (tempBarangKeluarModel temp_Keluar);
    void updateData (tempBarangKeluarModel temp_Keluar);
    void deleteData (tempBarangKeluarModel temp_Keluar);
    
    tempBarangKeluarModel getByid (String id);
    List<tempBarangKeluarModel> getData();
}
