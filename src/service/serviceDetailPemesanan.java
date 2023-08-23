/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.detailPemesananModel;

/**
 *
 * @author ASUS
 */
public interface serviceDetailPemesanan {
    void addData (detailPemesananModel detail_Pemesanan);
    void sumTotal (detailPemesananModel detail_Pemesanan);
    void hapusSementara (detailPemesananModel detail_Pemesanan);
    
    detailPemesananModel getById (String id);
    
    List<detailPemesananModel> getData(String id);
    List<detailPemesananModel> search(String id);
}
