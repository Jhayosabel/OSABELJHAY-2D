
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
                System.out.println("1. Grade");
                System.out.println("2. Account");
                System.out.println("3. Product");
                System.out.println("Enter selection: ");
                
                int select = sc.nextInt();
                
                switch(select) {
                    case 1:
                        gr.getGrade();
                        break;
                    case 2:
                        ac.getAccount();
                        break;
                    case 3:
                        pr.getProduct();
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

        private void getAccount() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class Grade {

        public Grade() {
        }

        private void getGrade() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class Product {

        public Product() {
        }

        private void getProduct() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class gr {

        private static void getGrade() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public gr() {
        }
    }

    private static class pr {

        private static void getProduct() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public pr () {
        }
    }
}
    
    

