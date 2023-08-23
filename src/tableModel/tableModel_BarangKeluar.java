/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.barangKeluarModel;

/**
 *
 * @author ASUS
 */
public class tableModel_BarangKeluar extends AbstractTableModel{

    private List<barangKeluarModel> list = new ArrayList<>();
    
    public void addData(barangKeluarModel barangKeluar){
        list.add(barangKeluar);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void updateData(int row, barangKeluarModel barangKeluar){
        list.add(row, barangKeluar);
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

    public void setData(List<barangKeluarModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, barangKeluarModel barangKeluar){
        list.set(index, barangKeluar);
        fireTableRowsUpdated(index, index);
    }
    
    public barangKeluarModel getData(int index){
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
            case 0: return list.get(rowIndex).getNomor_keluar();
            case 1: return list.get(rowIndex).getTgl_keluar();
            case 2: return list.get(rowIndex).getTotal_keluar();
            case 3: return list.get(rowIndex).getUser_Model().getId_user();
                      
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "Nomor Keluar";
            case 1: return "Tanggal Keluar";
            case 2: return "Total Keluar";
            case 3: return "ID User";
                      
            default: return null;
        }
    }
}
