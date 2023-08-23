/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.userModel;

/**
 *
 * @author ASUS
 */
public class tableModel_User extends AbstractTableModel{

    private List<userModel> list = new ArrayList<>();
    
    public void addData(userModel user_Model){
        list.add(user_Model);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void updateData(int row, userModel user_Model){
        list.add(row, user_Model);
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

    public void setData(List<userModel> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, userModel user_Model){
        list.set(index, user_Model);
        fireTableRowsUpdated(index, index);
    }
    
    public userModel getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    private final String[] columnNames = {"No", "ID", "Nama", "Username", "Telepon", "Alamat", "Level"};
    
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
                case 0: return list.get(rowIndex).getId_user();
                case 1: return list.get(rowIndex).getNama_user();
                case 2: return list.get(rowIndex).getUsername();
                case 3: return list.get(rowIndex).getTelp_user();
                case 4: return list.get(rowIndex).getAlamat_user();
                case 5: return list.get(rowIndex).getLevel();
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