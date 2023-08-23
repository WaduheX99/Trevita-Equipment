/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.barangModel;

/**
 *
 * @author ASUS
 */
public class tableModel_Barang extends AbstractTableModel{

    private List<barangModel> list = new ArrayList<>();
    
    public void addData(barangModel barang_Model){
        list.add(barang_Model);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void updateData(int row, barangModel barang_Model){
        list.add(row, barang_Model);
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

    public void setData(List<barangModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, barangModel barang_Model){
        list.set(index, barang_Model);
        fireTableRowsUpdated(index, index);
    }
    
    public barangModel getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    private final String[] columnNames = {"No", "Kode Barang", "Kode Jenis", "Nama Jenis", "Nama Barang", "Satuan", "Harga", "Stok"};
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return "    " + (rowIndex + 1);
        } 
        else {
            switch (columnIndex - 1) {
                case 0: return list.get(rowIndex).getKode_barang();
                case 1: return list.get(rowIndex).getJenisBarang().getKode_jenis();
                case 2: return list.get(rowIndex).getJenisBarang().getNama_jenis();
                case 3: return list.get(rowIndex).getNama_barang();
                case 4: return list.get(rowIndex).getSatuan();
                case 5: return list.get(rowIndex).getHarga();
                case 6: return list.get(rowIndex).getStok();
                default : return null;
            }
        }
    }
    
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "   " + columnNames[column];
        } else {
            return columnNames[column];
        }
    }
}
