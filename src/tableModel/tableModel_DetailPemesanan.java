/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.detailPemesananModel;

/**
 *
 * @author ASUS
 */
public class tableModel_DetailPemesanan extends AbstractTableModel{

    private List<detailPemesananModel> list = new ArrayList<>();
    
    public void addData(detailPemesananModel detail_Pemesanan){
        list.add(detail_Pemesanan);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void updateData(int row,  detailPemesananModel detail_Pemesanan){
        list.add(row, detail_Pemesanan);
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

    public void setData(List<detailPemesananModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, detailPemesananModel detail_Pemesanan){
        list.set(index, detail_Pemesanan);
        fireTableRowsUpdated(index, index);
    }
    
    public detailPemesananModel getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return list.get(rowIndex).getPemesanan_Model().getNomor_pemesanan();
            case 1: return list.get(rowIndex).getBarang_Model().getKode_barang();
            case 2: return list.get(rowIndex).getBarang_Model().getNama_barang();
            case 3: return list.get(rowIndex).getBarang_Model().getHarga();
            case 4: return list.get(rowIndex).getJml_pemesanan();
            case 5: return list.get(rowIndex).getSubtotal_pemesanan();
            case 6: return list.get(rowIndex).getStatus();
                      
            default: return null;
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "Nomor Pemesanan";
            case 1: return "Kode Barang";
            case 2: return "Nama Barang";
            case 3: return "Harga";
            case 4: return "Jumlah Pemesanan";
            case 5: return "Subtotal";
            case 6: return "Keterangan";
                      
            default: return null;
        }
    }
    
}
