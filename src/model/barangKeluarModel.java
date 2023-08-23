/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class barangKeluarModel {
    
    private String nomor_keluar;
    private String tgl_keluar;
    private Long total_keluar;
    private userModel user_Model;

    public String getNomor_keluar() {
        return nomor_keluar;
    }

    public void setNomor_keluar(String nomor_keluar) {
        this.nomor_keluar = nomor_keluar;
    }

    public String getTgl_keluar() {
        return tgl_keluar;
    }

    public void setTgl_keluar(String tgl_keluar) {
        this.tgl_keluar = tgl_keluar;
    }

    public Long getTotal_keluar() {
        return total_keluar;
    }

    public void setTotal_keluar(Long total_keluar) {
        this.total_keluar = total_keluar;
    }

    public userModel getUser_Model() {
        return user_Model;
    }

    public void setUser_Model(userModel user_Model) {
        this.user_Model = user_Model;
    }
}