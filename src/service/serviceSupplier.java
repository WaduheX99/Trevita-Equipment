/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.supplierModel;

/**
 *
 * @author ASUS
 */
public interface serviceSupplier {
    void addData (supplierModel supplier_Model);
    void updateData (supplierModel supplier_Model);
    void deleteData (supplierModel supplier_Model);
    
    supplierModel getByid (String id);
    
    List<supplierModel> getData();
    List<supplierModel> getData(int startIndex, int entriesPerPage);
    List<supplierModel> search(String id);
    
    String nomor();
    int getTotalEntries();
}
