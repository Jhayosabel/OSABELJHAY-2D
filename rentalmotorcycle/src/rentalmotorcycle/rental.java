package rentalmotorcycle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class rental {

    
    public static void rrecord() {
        Scanner sc = new Scanner(System.in);
        String response;

        do {
            System.out.println("\nRental Record");
            System.out.println("1. Add Record");
            System.out.println("2. View Record");
            System.out.println("3. Update Record");
            System.out.println("4. Delete Record");
            System.out.println("5. Exit");
            System.out.print("Enter action: ");
            int action = sc.nextInt();

            rental rental = new rental();
            switch (action) {
                case 1:
                    rental.addRecord();
                    rental.viewRecord();
                    break;
                case 2:
                    rental.viewRecord();
                    break;
                case 3:
                    rental.updateRecord();
                    rental.viewRecord();
                    break;
                case 4:
                   rental.deleteRecord();
                   rental.viewRecord();
                    break;
                case 5:           
                    return;
                default:
                    System.out.println("Invalid action. Please try again.");
            }

            System.out.print("Do you want to continue? (yes/no): ");
            response = sc.next();
        } while (response.equalsIgnoreCase("yes"));

        System.out.println("Thank You!");
        sc.close();
    }

   
    public void addRecord() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        customer customer = new customer();
        customer.viewCustomer();

        System.out.print("Enter the ID of the customer: ");
        int customerId = sc.nextInt();

        String customerQuery = "SELECT c_id FROM tbl_customer WHERE c_id = ?";
        while (conf.getSingleValue(customerQuery, customerId) == 0) {
            System.out.print("Selected ID doesn't exist! Please enter a valid ID: ");
            customerId = sc.nextInt();
        }

        motorcycle motorcycle = new motorcycle();
        motorcycle.viewmotorcycle();

        System.out.print("Enter the ID of the motorcycle: ");
        int motorcycleId = sc.nextInt();

        String motorcycleQuery = "SELECT m_id FROM tbl_motorcycle WHERE m_id = ?";
        while (conf.getSingleValue(motorcycleQuery, motorcycleId) == 0) {
            System.out.print("Selected ID doesn't exist! Please enter a valid ID: ");
            motorcycleId = sc.nextInt();
        }

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String rentalDate = currentDate.format(formatter);

       
        String returnDate = "12/31/2024"; 
        String totalAmount = "1000";      

        String rentalRecordQuery = "INSERT INTO tbl_rental (c_id, mc_id, r_rentaldate, r_returndate, r_totalamount) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(rentalRecordQuery, customerId, motorcycleId, rentalDate, returnDate, totalAmount);
    }

    
    public void viewRecord() {
        String query = "SELECT r.r_id, r.r_rentaldate, r.r_returndate, r.r_totalamount, c.c_id, m.m_id " +
                       "FROM tbl_rental r " +
                       "LEFT JOIN tbl_customer c ON r.c_id = c.c_id " +
                       "LEFT JOIN tbl_motorcycle m ON r.mc_id = m.m_id";
        String[] headers = {"RID", "Customer ID", "Motorcycle ID", "Rental Date", "Return Date", "Total Amount"};
        String[] columns = {"r_id", "c_id", "c_id", "r_rentaldate", "r_returndate", "r_totalamount"};

      config conf = new config();
        conf.viewRecords(query, headers, columns);
    }
    
    public void updateRecord() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Enter the rental ID to update: ");
        int rentalId = sc.nextInt();

        String rentalCheckSql = "SELECT r_id FROM tbl_rental WHERE r_id = ?";
        while (conf.getSingleValue(rentalCheckSql, rentalId) == 0) {
            System.out.print("rental ID not found! Enter again: ");
            rentalId = sc.nextInt();
        }

        System.out.print("Enter the new customer ID: ");
        int newcustomerId = sc.nextInt();
        System.out.print("Enter the new motorcycle ID: ");
        int newmotorcycleId = sc.nextInt();
        System.out.print("Enter the new rental status (padong na, kompleto na, nag paabot pa): ");
        String newStatus = sc.next();

        String updateQuery = "UPDATE tbl_rental SET customer_id = ?, d_id = ?, new_status = ? WHERE motorcycle_id = ?";
        conf.updateRecord(updateQuery, newcustomerId, newmotorcycleId, newStatus, rentalId);
    }
    
      public void deleteRecord() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Enter the rental ID to delete: ");
        int rentalId = sc.nextInt();

        String deleteQuery = "DELETE FROM tbl_rental WHERE r_id = ?";
        conf.deleteRecord(deleteQuery, rentalId);
    }
}
