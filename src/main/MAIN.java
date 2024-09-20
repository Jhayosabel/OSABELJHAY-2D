
package main;

import java.util.Scanner;


public class MAIN {

    
    public static void main(String[] args) {
        

        try (Scanner sc = new Scanner(System.in)) {
            Grade gr = new Grade();
            Account ac = new Account();
            Product pr = new Product();
            
            String transaction;
            
            System.out.println("Product CRUD System\n");
            
            do {
                System.out.println("1. Salary");
                System.out.println("2. Account");
                System.out.println("3. Receipt");
                System.out.println("Enter selection: ");
                
                int select = sc.nextInt();
                
                switch(select) {
                    case 1:
                        sl.getSalary();
                        break;
                    case 2:
                        ac.getAccounts();
                        break;
                    case 3:
                        rc.getReceipt();
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
                System.out.print("Make another transaction? (y/n): ");
                transaction = sc.next();
            } while(transaction.equalsIgnoreCase("y"));
        }
    }

    private static class Account {

        public Account() {
        }

        private void getAccounts() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class Grade {

        public Grade() {
        }
    }

    private static class Product {

        public Product() {
        }
    }

    private static class sl {

        private static void getSalary() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public sl() {
        }
    }

    private static class rc {

        private static void getReceipt() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public rc() {
        }
    }
}
    
    

