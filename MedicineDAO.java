package com.pharmacy.dao;

import com.pharmacy.model.Medicine;

import java.sql.SQLException;
import java.util.List;


public interface MedicineDAO {
	
	void connect() throws SQLException;
	
	void insertMedicine(Medicine medicine) throws SQLException;
    List<Medicine> getAllMedicines() throws SQLException;
    Medicine getMedicineById(int id) throws SQLException;
    void updateMedicine(Medicine medicine) throws SQLException;
    void deleteMedicine(int id) throws SQLException;

	String findMedicineNameByIdUsingProc(int id) throws SQLException;

}
