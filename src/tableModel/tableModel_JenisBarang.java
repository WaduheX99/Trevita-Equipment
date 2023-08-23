/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.jenisBarangModel;

/**
 *
 * @author ASUS
 */
public class tableModel_JenisBarang extends AbstractTableModel{

    Icon iconSukses = new javax.swing.ImageIcon(getClass().getResource("/img/berhasil.png"));
    Icon iconDelete = new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"));
    
    private List<jenisBarangModel> list = new ArrayList<>();
    
    private final String[] columnNames = {"No", "Kode Jenis", "Nama Jenis"};
    
    public void addData(jenisBarangModel jenisBarang){
        list.add(jenisBarang);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        //JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan", "Tambah Data", 0, iconSukses);
    }
    
    public void updateData(int row, jenisBarangModel jenisBarang){
        list.add(row, jenisBarang);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil di perbarui");
    }
    
    public void deleteData(int index){
        list.remove(index);
        fireTableRowsDeleted(index, index);
        //JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
        JOptionPane.showMessageDialog(null, "Data Berhasil di hapus", "Hapus Data", 0, iconDelete);
    }
    
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }

    public void setData(List<jenisBarangModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, jenisBarangModel jenisBarang){
        list.set(index, jenisBarang);
        fireTableRowsUpdated(index, index);
    }
    
    public jenisBarangModel getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
       
    @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return "    " + (rowIndex + 1);
            } else {
                switch (columnIndex - 1) {
                    case 0: return list.get(rowIndex).getKode_jenis();
                    case 1: return list.get(rowIndex).getNama_jenis();
                    default: return null;
                }
            }
        }
    
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "    " + columnNames[column];
        } else {
            return columnNames[column];
        }
    }
}
