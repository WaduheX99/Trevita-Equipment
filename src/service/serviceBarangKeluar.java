/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.barangKeluarModel;

/**
 *
 * @author ASUS
 */
public interface serviceBarangKeluar {
    void addData (barangKeluarModel barangKeluar);
    void deleteData (barangKeluarModel barangKeluar);
    
    barangKeluarModel getByid (String id);
    List<barangKeluarModel> getData();
    List<barangKeluarModel> search(String id);
    
    String nomor();
}
