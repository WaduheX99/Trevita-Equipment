/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.supplierModel;

/**
 *
 * @author ASUS
 */
public class tableModel_Supplier extends AbstractTableModel{

    private List<supplierModel> list = new ArrayList<>();
    
    public void addData(supplierModel supplier_Model){
        list.add(supplier_Model);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void updateData(int row, supplierModel supplier_Model){
        list.add(row, supplier_Model);
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

    public void setData(List<supplierModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, supplierModel supplier_Model){
        list.set(index, supplier_Model);
        fireTableRowsUpdated(index, index);
    }
    
    public supplierModel getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return list.get(rowIndex).getId_supplier();
            case 1: return list.get(rowIndex).getNama_supplier();
            case 2: return list.get(rowIndex).getTelp_supplier();
            case 3: return list.get(rowIndex).getAlamat_supplier();
            
            default: return null;
        }    
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "ID Supplier";
            case 1: return "Nama Supplier";
            case 2: return "Telepon Supplier";
            case 3: return "Alamat Supplier";
                      
            default: return null;
        }
    }
    
}
