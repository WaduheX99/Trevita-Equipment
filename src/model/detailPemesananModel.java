/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class detailPemesananModel {
    
    private pemesananModel pemesanan_Model;
    private barangModel barang_Model;
    private Long jml_pemesanan;
    private Long subtotal_pemesanan;
    private String status;

    public pemesananModel getPemesanan_Model() {
        return pemesanan_Model;
    }

    public void setPemesanan_Model(pemesananModel pemesanan_Model) {
        this.pemesanan_Model = pemesanan_Model;
    }

    public barangModel getBarang_Model() {
        return barang_Model;
    }

    public void setBarang_Model(barangModel barang_Model) {
        this.barang_Model = barang_Model;
    }

    public Long getJml_pemesanan() {
        return jml_pemesanan;
    }

    public void setJml_pemesanan(Long jml_pemesanan) {
        this.jml_pemesanan = jml_pemesanan;
    }

    public Long getSubtotal_pemesanan() {
        return subtotal_pemesanan;
    }

    public void setSubtotal_pemesanan(Long subtotal_pemesanan) {
        this.subtotal_pemesanan = subtotal_pemesanan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}