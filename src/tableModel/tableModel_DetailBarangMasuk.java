/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.detailBarangMasukModel;

/**
 *
 * @author ASUS
 */
public class tableModel_DetailBarangMasuk extends AbstractTableModel{
    
    private List<detailBarangMasukModel> list = new ArrayList<>();
    
    public void addData(detailBarangMasukModel detail_BarangMasuk){
        list.add(detail_BarangMasuk);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void updateData(int row, detailBarangMasukModel detail_BarangMasuk){
        list.add(row, detail_BarangMasuk);
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

    public void setData(List<detailBarangMasukModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, detailBarangMasukModel detail_BarangMasuk){
        list.set(index, detail_BarangMasuk);
        fireTableRowsUpdated(index, index);
    }
    
    public detailBarangMasukModel getData(int index){
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
            case 0: return list.get(rowIndex).getBarangMasuk_Model().getNomor_masuk();
            case 1: return list.get(rowIndex).getBarang_Model().getKode_barang();
            case 2: return list.get(rowIndex).getBarang_Model().getNama_barang();
            case 3: return list.get(rowIndex).getBarang_Model().getHarga();
            case 4: return list.get(rowIndex).getJml_masuk();
            case 5: return list.get(rowIndex).getSubtotal_masuk();
                      
            default: return null;
        }       
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "Nomor Masuk";
            case 1: return "Kode Barang";
            case 2: return "Nama Barang";
            case 3: return "Harga";
            case 4: return "Jumlah Masuk";
            case 5: return "Subtotal";
                      
            default: return null;
        }
    }
}
