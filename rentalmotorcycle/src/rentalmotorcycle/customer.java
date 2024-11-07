
package rentalmotorcycle;

import java.util.Scanner;

public class customer {
    public static void crecord() {
        
        Scanner sc = new Scanner (System.in);
        String response;
        do{
        
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.println("Enter Action: ");
        int action = sc.nextInt();
        customer customer = new customer ();

        switch(action){
            case 1:
                customer.addCustomer();           
                break;
            case 2:       
                customer.viewCustomer();
                break;
            case 3:
                customer.viewCustomer();
                customer.updateCustomer();
                customer.viewCustomer();
                break;
            case 4:
                customer.viewCustomer();
                customer.deleteCustomer();
                customer.viewCustomer();    
                break;
        }
        System.out.println("Do you want to continue? (yes/no)");
        response = sc.next();
    }while(response.equalsIgnoreCase("yes"));
    System.out.println("Thank You, See you soonest!");
    
    }
    
    
    public void addCustomer(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Phone Number: ");
        String cpn = sc.next();
        System.out.print("Date start to end: ");
        String cd = sc.next();
        System.out.print("Total Cost: ");
        String ctc = sc.next();
        System.out.print("Status: ");
        String cs = sc.next();

        String sql = "INSERT INTO tbl_customer (c_phonenumber, c_datestarttoend, c_totalcost, c_status) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, cpn, cd, ctc, cs);


    }

    public void viewCustomer() {
        config conf = new config();
        String Query = "SELECT * FROM tbl_Customer";
        String[] Headers = {"CUSTOMER_ID","phonenumber", "datesstarttoend", "totalcost", "status"};
        String[] Columns = {"c_id", "c_phonenumber", "c_datestarttoend", "c_totalcost", "c_status"};
        
        
        conf.viewRecords(Query, Headers, Columns);
    }
    private void updateCustomer() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the ID to update: ");
        int id = sc.nextInt();
        
        System.out.print("Phone Number: ");
        String cpn = sc.next();
        System.out.print("Date start to end: ");
        String cd = sc.next();
        System.out.print("Total Cost: ");
        String ctc = sc.next();
        System.out.print("Status: ");
        String cs = sc.next();
        String qry = "UPDATE tbl_customer SET c_phonenumber = ?, c_datestarttoend = ?, c_totalcost = ?, c_status = ? WHERE c_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, cpn, cd, ctc, cs, id);         
    }
    
    private void deleteCustomer() {
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Enter the ID  to delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_customer WHERE c_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}


