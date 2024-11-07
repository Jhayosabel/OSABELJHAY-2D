package rentalmotorcycle;

import java.util.Scanner;

public class motorcycle {

   
    public static void mrecord() {
        Scanner sc = new Scanner(System.in);
        String response;
        motorcycle motorcycle = new motorcycle();
        
        do {
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            System.out.print("Enter Action: ");
            
            int action = sc.nextInt();

            switch (action) {
                case 1:
                    motorcycle.addmotorcycle();
                    break;
                case 2:
                    motorcycle.viewmotorcycle();
                    break;
                case 3:
                    motorcycle.updatemotorcycle();
                    break;
                case 4:
                    motorcycle.deletemotorcycle();
                    break;
                case 5:
                    System.out.println("Thank You, See you soon!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.print("Do you want to continue? (yes/no): ");
            response = sc.next();
        } while (response.equalsIgnoreCase("yes"));

        System.out.println("Thank You, See you soon!");
        sc.close();
    }


    public void addmotorcycle() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Model: ");
        String model = sc.next();
        System.out.print("Brand: ");
        String brand = sc.next();
        System.out.print("Type of Motorcycle: ");
        String type = sc.next();
        System.out.print("Engine CC: ");
        String engineCc = sc.next();
        System.out.print("Plate Number: ");
        String plateNumber = sc.next();
       
        String sql = "INSERT INTO tbl_motorcycle (m_model, m_brand, m_typeofmotorcycle, m_enginecc, m_platenumber) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, model, brand, type, engineCc, plateNumber);
    }

   
    public void viewmotorcycle() {
       config conf = new config();
        String query = "SELECT * FROM tbl_motorcycle";
        String[] headers = {"MOTORCYCLE_ID", "m_model", "m_brand", "m_typeofmotorcycle", "m_enginecc", "m_platenumber"};
        String[] columns = {"m_id", "m_model", "m_brand", "m_typeofmotorcycle", "m_enginecc", "m_platenumber"};
        
        conf.viewRecords(query, headers, columns);
    }

 
    private void updatemotorcycle() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the Motorcycle ID to update: ");
        int id = sc.nextInt();
        System.out.print("Model: ");
        String model = sc.next();
        System.out.print("Brand: ");
        String brand = sc.next();
        System.out.print("Type of Motorcycle: ");
        String type = sc.next();
        System.out.print("Engine CC: ");
        String engineCc = sc.next();
        System.out.print("Plate Number: ");
        String plateNumber = sc.next();
        
        String query = "UPDATE tbl_motorcycle SET m_model = ?, m_brand = ?, m_typeofmotorcycle = ?, m_enginecc = ?, m_platenumber = ? WHERE m_id = ?";
        
       config conf = new config();
        conf.updateRecord(query, model, brand, type, engineCc, plateNumber, id);         
    }

    
    private void deletemotorcycle() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the Motorcycle ID to delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_motorcycle WHERE m_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}
