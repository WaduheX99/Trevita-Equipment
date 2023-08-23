/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.barangMasukModel;

/**
 *
 * @author ASUS
 */
public interface serviceBarangMasuk {
    void addData (barangMasukModel barangMasuk);
    void updateStatus (String kode_barang);
    void deleteData (barangMasukModel barangMasuk);
    
    barangMasukModel getByid (String id);
    List<barangMasukModel> getData();
    List<barangMasukModel> search(String id);
    
    String nomor();
}
