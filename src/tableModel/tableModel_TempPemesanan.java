/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.tempPemesananModel;

/**
 *
 * @author ASUS
 */
public class tableModel_TempPemesanan extends AbstractTableModel{

    private List<tempPemesananModel> list = new ArrayList<>();
    
    public void addData(tempPemesananModel temp_Pemesanan){
        list.add(temp_Pemesanan);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void updateData(int row, tempPemesananModel temp_Pemesanan){
        list.add(row, temp_Pemesanan);
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

    public void setData(List<tempPemesananModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, tempPemesananModel temp_Pemesanan){
        list.set(index, temp_Pemesanan);
        fireTableRowsUpdated(index, index);
    }
    
    public tempPemesananModel getData(int index){
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
            case 0: return list.get(rowIndex).getBarang_Model().getKode_barang();
            case 1: return list.get(rowIndex).getBarang_Model().getNama_barang();
            case 2: return list.get(rowIndex).getBarang_Model().getHarga();
            case 3: return list.get(rowIndex).getDetailPemesanan_Model().getJml_pemesanan();
            case 4: return list.get(rowIndex).getDetailPemesanan_Model().getSubtotal_pemesanan();
                        
            default: return null;
        }       
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "Kode Barang";
            case 1: return "Nama Barang";
            case 2: return "Harga";
            case 3: return "Jumlah";
            case 4: return "Subtotal";
                      
            default: return null;
        }
    }
}
