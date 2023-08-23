/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.jenisBarangModel;

/**
 *
 * @author ASUS
 */
public interface serviceJenisBarang {
    void addData (jenisBarangModel jenisBarang);
    void updateData (jenisBarangModel jenisBarang);
    void deleteData (jenisBarangModel jenisBarang);
    
    jenisBarangModel getByid (String id);
    
    List<jenisBarangModel> getData();
    List<jenisBarangModel> search(String id);
    
    String nomor();
    
    boolean validasiNamaJenisBarang(jenisBarangModel jenisBarang);
    List<jenisBarangModel> getData(int startIndex, int entriesPerPage);
    int getTotalHalaman();
}
