/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class barangMasukModel {
    
    private String nomor_masuk;
    private String tgl_masuk;
    private Long total_masuk;
    private supplierModel supplier_Model;
    private userModel user_Model;

    public String getNomor_masuk() {
        return nomor_masuk;
    }

    public void setNomor_masuk(String nomor_masuk) {
        this.nomor_masuk = nomor_masuk;
    }

    public String getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(String tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

    public Long getTotal_masuk() {
        return total_masuk;
    }

    public void setTotal_masuk(Long total_masuk) {
        this.total_masuk = total_masuk;
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