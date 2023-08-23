/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.detailBarangKeluarModel;

/**
 *
 * @author ASUS
 */
public class tableModel_DetailBarangKeluar extends AbstractTableModel{

    private List<detailBarangKeluarModel> list = new ArrayList<>();
    
    public void addData(detailBarangKeluarModel detail_BarangKeluar){
        list.add(detail_BarangKeluar);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void updateData(int row, detailBarangKeluarModel detail_BarangKeluar){
        list.add(row, detail_BarangKeluar);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil di perbarui");
    }
    
    public void deleteData(int index){
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
    }
    
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }

    public void setData(List<detailBarangKeluarModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, detailBarangKeluarModel detail_BarangKeluar){
        list.set(index, detail_BarangKeluar);
        fireTableRowsUpdated(index, index);
    }
    
    public detailBarangKeluarModel getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return list.get(rowIndex).getBarangKeluar_Model().getNomor_keluar();
            case 1: return list.get(rowIndex).getBarang_Model().getKode_barang();
            case 2: return list.get(rowIndex).getBarang_Model().getNama_barang();
            case 3: return list.get(rowIndex).getBarang_Model().getHarga();
            case 4: return list.get(rowIndex).getJml_keluar();
            case 5: return list.get(rowIndex).getSubtotal_keluar();
                      
            default: return null;
        }       
    }
 
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "Nomor Keluar";
            case 1: return "Kode Barang";
            case 2: return "Nama Barang";
            case 3: return "Harga";
            case 4: return "Jumlah Keluar";
            case 5: return "Subtotal";
                      
            default: return null;
        }
    }
}