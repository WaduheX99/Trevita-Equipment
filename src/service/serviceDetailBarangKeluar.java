/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.detailBarangKeluarModel;

/**
 *
 * @author ASUS
 */
public interface serviceDetailBarangKeluar {
    void addData (detailBarangKeluarModel detail_BarangKeluar);
    void sumTotal (detailBarangKeluarModel detail_BarangKeluar);
    void hapusSementara (detailBarangKeluarModel detail_BarangKeluar);
    
    detailBarangKeluarModel getById (String id);
    
    List<detailBarangKeluarModel> getData(String id);
    List<detailBarangKeluarModel> search(String id);
    
    boolean validasiStok (detailBarangKeluarModel detail_BarangKeluar);
}
