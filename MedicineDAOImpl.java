package com.pharmacy.dao;


import com.pharmacy.model.Medicine;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MedicineDAOImpl implements MedicineDAO {
    private Connection con;

    @Override
    public void connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/PharmacyDB";
        String user = "root";
        String password = "bUNTY@1182%28";
        con = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to the database!");
    }

    
    @Override
    public void insertMedicine(Medicine medicine) throws SQLException {
        PreparedStatement pst = con.prepareStatement("INSERT INTO Medicines (id, name, price, quantity) VALUES (?, ?, ?, ?)");
        pst.setInt(1, medicine.getId());
        pst.setString(2, medicine.getName());
        pst.setDouble(3, medicine.getPrice());
        pst.setInt(4, medicine.getQuantity());
        int count = pst.executeUpdate();
        System.out.println(count + " record added to Medicines table successfully!");
        pst.close();
    }

    @Override
    public List<Medicine> getAllMedicines() throws SQLException {
        Statement st = con.createStatement();
        List<Medicine> medicines = new ArrayList<>();
        ResultSet rs = st.executeQuery("SELECT * FROM Medicines");
        while (rs.next()) {
            medicines.add(new Medicine(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity")));
        }
        rs.close();
        st.close();
        return medicines;
    }

    @Override
    public Medicine getMedicineById(int id) throws SQLException {
        PreparedStatement pst = con.prepareStatement("SELECT * FROM Medicines WHERE id = ?");
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        Medicine medicine = null;
        if (rs.next()) {
            medicine = new Medicine(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"));
        }
        rs.close();
        pst.close();
        return medicine;
    }

    @Override
    public void updateMedicine(Medicine medicine) throws SQLException {
        PreparedStatement pst = con.prepareStatement("UPDATE Medicines SET name = ?, price = ?, quantity = ? WHERE id = ?");
        pst.setString(1, medicine.getName());
        pst.setDouble(2, medicine.getPrice());
        pst.setInt(3, medicine.getQuantity());
        pst.setInt(4, medicine.getId());
        int count = pst.executeUpdate();
        System.out.println(count + " record updated successfully!");
        pst.close();
    }

    @Override
    public void deleteMedicine(int id) throws SQLException {
        PreparedStatement pst = con.prepareStatement("DELETE FROM Medicines WHERE id = ?");
        pst.setInt(1, id);
        int count = pst.executeUpdate();
        System.out.println(count + " record deleted successfully!");
        pst.close();
    }
    
    @Override
    public String findMedicineNameByIdUsingProc(int id) throws SQLException {
        CallableStatement cs = con.prepareCall("{CALL findMedicineNameByIdUsingProc(?, ?)}");
        cs.setInt(1, id);
        cs.registerOutParameter(2, Types.VARCHAR); 
        cs.execute();

        String medicineName = cs.getString(2); 

        cs.close();
        return medicineName;
    }
}