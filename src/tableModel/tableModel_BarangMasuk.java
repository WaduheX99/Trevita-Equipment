/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.barangMasukModel;

/**
 *
 * @author ASUS
 */
public class tableModel_BarangMasuk extends AbstractTableModel{
    
    private List<barangMasukModel> list = new ArrayList<>();
    
    public void addData(barangMasukModel barangMasuk){
        list.add(barangMasuk);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void updateData(int row, barangMasukModel barangMasuk){
        list.add(row, barangMasuk);
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

    public void setData(List<barangMasukModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, barangMasukModel barangMasuk){
        list.set(index, barangMasuk);
        fireTableRowsUpdated(index, index);
    }
    
    public barangMasukModel getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return list.get(rowIndex).getNomor_masuk();
            case 1: return list.get(rowIndex).getTgl_masuk();
            case 2: return list.get(rowIndex).getTotal_masuk();
            case 3: return list.get(rowIndex).getSupplier_Model().getId_supplier();
            case 4: return list.get(rowIndex).getUser_Model().getId_user();
                      
            default: return null;
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "Nomor Masuk";
            case 1: return "Tanggal Masuk";
            case 2: return "Total Masuk";
            case 3: return "ID Supplier";
            case 4: return "ID User";
                      
            default: return null;
        }
    }
    
}
