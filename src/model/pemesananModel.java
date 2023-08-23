/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class pemesananModel {
    
    private String nomor_pemesanan;
    private String tgl_pemesanan;
    private Long total_pemesanan;
    private supplierModel supplier_Model;
    private userModel user_Model;

    public String getNomor_pemesanan() {
        return nomor_pemesanan;
    }

    public void setNomor_pemesanan(String nomor_pemesanan) {
        this.nomor_pemesanan = nomor_pemesanan;
    }

    public String getTgl_pemesanan() {
        return tgl_pemesanan;
    }

    public void setTgl_pemesanan(String tgl_pemesanan) {
        this.tgl_pemesanan = tgl_pemesanan;
    }

    public Long getTotal_pemesanan() {
        return total_pemesanan;
    }

    public void setTotal_pemesanan(Long total_pemesanan) {
        this.total_pemesanan = total_pemesanan;
    }

    public supplierModel getSupplier_Model() {
        return supplier_Model;
    }

    public void setSupplier_Model(supplierModel supplier_Model) {
        this.supplier_Model = supplier_Model;
    }

    public userModel getUser_Model() {
        return user_Model;
    }

    public void setUser_Model(userModel user_Model) {
        this.user_Model = user_Model;
    }
}
