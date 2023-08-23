/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.detailBarangMasukModel;

/**
 *
 * @author ASUS
 */
public interface serviceDetailBarangMasuk {
    void addData (detailBarangMasukModel detail_BarangMasuk);
    void sumTotal (detailBarangMasukModel detail_BarangMasuk);
    void hapusSementara (detailBarangMasukModel detail_BarangMasuk);
    
    detailBarangMasukModel getById (String id);
    
    List<detailBarangMasukModel> getData(String id);
}
