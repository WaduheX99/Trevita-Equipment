/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class detailBarangMasukModel {
    
    private barangMasukModel barangMasuk_Model;
    private barangModel barang_Model;
    private int jml_masuk;
    private Long subtotal_masuk;

    public barangMasukModel getBarangMasuk_Model() {
        return barangMasuk_Model;
    }

    public void setBarangMasuk_Model(barangMasukModel barangMasuk_Model) {
        this.barangMasuk_Model = barangMasuk_Model;
    }

    public barangModel getBarang_Model() {
        return barang_Model;
    }

    public void setBarang_Model(barangModel barang_Model) {
        this.barang_Model = barang_Model;
    }

    public int getJml_masuk() {
        return jml_masuk;
    }

    public void setJml_masuk(int jml_masuk) {
        this.jml_masuk = jml_masuk;
    }

    public Long getSubtotal_masuk() {
        return subtotal_masuk;
    }

    public void setSubtotal_masuk(Long subtotal_masuk) {
        this.subtotal_masuk = subtotal_masuk;
    }

}
