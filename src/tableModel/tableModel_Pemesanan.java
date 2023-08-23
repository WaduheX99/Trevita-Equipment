/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.pemesananModel;

/**
 *
 * @author ASUS
 */
public class tableModel_Pemesanan extends AbstractTableModel{

    private List<pemesananModel> list = new ArrayList<>();
    
    public void addData(pemesananModel pemesanan_Model){
        list.add(pemesanan_Model);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void updateData(int row, pemesananModel pemesanan_Model){
        list.add(row, pemesanan_Model);
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

    public void setData(List<pemesananModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, pemesananModel pemesanan_Model){
        list.set(index, pemesanan_Model);
        fireTableRowsUpdated(index, index);
    }
    
    public pemesananModel getData(int index){
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
            case 0: return list.get(rowIndex).getNomor_pemesanan();
            case 1: return list.get(rowIndex).getTgl_pemesanan();
            case 2: return list.get(rowIndex).getTotal_pemesanan();
            case 3: return list.get(rowIndex).getSupplier_Model().getId_supplier();
            case 4: return list.get(rowIndex).getUser_Model().getId_user();
                        
            default: return null;
        }       
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "No Pemesanan";
            case 1: return "Tanggal";
            case 2: return "Total Pemesanan";
            case 3: return "ID Supplier";
            case 4: return "ID User";
                      
            default: return null;
        }
    }  
}
