/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.pemesananModel;

/**
 *
 * @author ASUS
 */
public interface servicePemesanan {
    void addData (pemesananModel pemesanan_Model);
    void updateData (pemesananModel pemesanan_Model);
    void deleteData (pemesananModel pemesanan_Model);
    
    pemesananModel getByid (String id);
    List<pemesananModel> getData();
    List<pemesananModel> search(String id);
    
    String nomor();
}
