/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.barangModel;

/**
 *
 * @author ASUS
 */
public interface serviceBarang {
    void addData (barangModel barang_Model);
    void updateData (barangModel barang_Model);
    void deleteData (barangModel barang_Model);
    
    barangModel getByid (String id);
            
    List<barangModel> getDataByID();
    List<barangModel> getData();
    
    List<barangModel> search1(String id);
    List<barangModel> search2(String id);
    
    String nomor1();
    String nomor2();
}
