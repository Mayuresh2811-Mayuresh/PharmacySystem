// Name : Mayuresh Kalal

// Java 2 - Capstone Project - Pharmacy Service

package com.pharmacy.service;


import com.pharmacy.dao.MedicineDAOImpl;
import com.pharmacy.dao.MedicineDAO;
import com.pharmacy.model.Medicine;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PharmacyService {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if(username.equals("Mayuresh28") && password.equals("MSK28@")) {
            System.out.println("SUCCESSFULLY LOGGED IN ... WELCOME TO THE SYSTEM\n");

            MedicineDAO dao = new MedicineDAOImpl();

            int choice;
            int id;
            String name;
            double price;
            int quantity;

            do {
                System.out.println("***** MENU *****\n");
                
                System.out.println("1. INSERT A NEW MEDICINE");
                System.out.println("2. SHOW ALL MEDICINES");
                System.out.println("3. UPDATE A MEDICINE");
                System.out.println("4. DELETE A MEDICINE");
                System.out.println("5. FIND A MEDICINE BY ID");
                System.out.println("6. FIND MEDICINE NAME BY ID (STORED PROCEDURE)");
                System.out.println("7. EXIT\n");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    
                    case 1:
                    	dao.connect();
                        System.out.print("Enter ID: ");
                        id = sc.nextInt();
                        sc.nextLine(); 
                        System.out.print("Enter Name: ");
                        name = sc.nextLine();
                        System.out.print("Enter Price: ");
                        price = sc.nextDouble();
                        System.out.print("Enter Quantity: ");
                        quantity = sc.nextInt();
                        sc.nextLine(); 
                        Medicine newMedicine = new Medicine(id, name, price, quantity);
                        dao.insertMedicine(newMedicine);
                        break;
                    case 2:
                        dao.connect();
                        List<Medicine> medicines = dao.getAllMedicines();
                        if (medicines.isEmpty()) {
                            System.out.println("\nNO ENTRY FOUND IN THE MEDICINE TABLE");
                        } else {
                            for (Medicine medicine : medicines) {
                                System.out.println(medicine);
                            }
                        }
                        break;
                    case 3:
                    	dao.connect();
                        System.out.print("Enter ID of the medicine to update: ");
                        id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter New Name: ");
                        name = sc.nextLine();
                        System.out.print("Enter New Price: ");
                        price = sc.nextDouble();
                        System.out.print("Enter New Quantity: ");
                        quantity = sc.nextInt();
                        sc.nextLine(); 
                        Medicine updateMedicine = new Medicine(id, name, price, quantity);
                        dao.updateMedicine(updateMedicine);
                        break;
                    case 4:
                        dao.connect();
                        System.out.print("Enter ID of the medicine to delete: ");
                        id = sc.nextInt();
                        sc.nextLine(); 
                        dao.deleteMedicine(id);
                        break;
                    case 5:
                        dao.connect();
                        System.out.print("Enter ID of the medicine to find: ");
                        id = sc.nextInt();
                        sc.nextLine(); 
                        Medicine foundMedicine = dao.getMedicineById(id);
                        System.out.println(foundMedicine != null ? foundMedicine : "MEDICINE NOT FOUND");
                        break;
                    case 6:
                        dao.connect();
                        System.out.print("Enter ID of the medicine to find using stored procedure: ");
                        id = sc.nextInt();
                        sc.nextLine(); 
                        String medicineName = dao.findMedicineNameByIdUsingProc(id);
                        System.out.println(medicineName != null ? "Medicine Name: " + medicineName : "MEDICINE NOT FOUND");
                        break;
                    case 7:
                        System.out.println("\nEXITING THE PROGRAM ...");
                        break;
                    default:
                        System.out.println("\nINVALID CHOICE !!! PLEASE TRY AGAIN.");
                        break;
                }
            } while (choice != 8);
            sc.close();
        } else {
            System.out.println("INVALID LOGIN CREDENTIALS !! TRY AGAIN");
        }
    }
}