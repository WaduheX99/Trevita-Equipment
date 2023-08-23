/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class detailBarangKeluarModel {
    
    private barangKeluarModel barangKeluar_Model;
    private barangModel barang_Model;
    private int jml_keluar;
    private Long subtotal_keluar;

    public barangKeluarModel getBarangKeluar_Model() {
        return barangKeluar_Model;
    }

    public void setBarangKeluar_Model(barangKeluarModel barangKeluar_Model) {
        this.barangKeluar_Model = barangKeluar_Model;
    }

    public barangModel getBarang_Model() {
        return barang_Model;
    }

    public void setBarang_Model(barangModel barang_Model) {
        this.barang_Model = barang_Model;
    }

    public int getJml_keluar() {
        return jml_keluar;
    }

    public void setJml_keluar(int jml_keluar) {
        this.jml_keluar = jml_keluar;
    }

    public Long getSubtotal_keluar() {
        return subtotal_keluar;
    }

    public void setSubtotal_keluar(Long subtotal_keluar) {
        this.subtotal_keluar = subtotal_keluar;
    }
}
