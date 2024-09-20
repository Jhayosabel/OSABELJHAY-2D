
package main;

import java.util.Scanner;


public class Account {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            
            String password;
            while (true) {
                System.out.print("Enter Password: ");
                password = scanner.nextLine();
                if (isValidPassword(password)) {
                    break;
                } else {
                    System.out.println("Password does not meet the criteria. Please try again.");
                }
            }
            
            Account account = new Account(id, firstName, lastName, email, username, password);
            
            boolean running = true;
            while (running) {
                System.out.println("\n1. View account");
                System.out.println("2. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        account.view();
                        break;
                    case 2:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

private static boolean isValidPassword(String password) {
   
    if (!password.matches(".*[a-z].*")) return false;
    if (!password.matches(".*\\d.*")) return false;
    

    String[] commonPasswords = {"admin", "password", "1234"};
    for (String common : commonPasswords) {
        if (password.toLowerCase().contains(common.toLowerCase())) return false;
    }

    return true;
}

    private Account(int id, String firstName, String lastName, String email, String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void view() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

