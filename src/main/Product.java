
package main;

import java.util.Scanner;


public class Product {
    
    private final Product[] products = new Product[100];
    private int nums = 0;
    private int sold;
    private int id;
    private String name;
    private double price;
    private int stocks;

    public void getProducts() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("INVENTORY PRODUCTS");
            System.out.println("---------------------------------");
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. EDIT");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            System.out.println("---------------------------------");

            System.out.print("Enter Action: ");
            int opt = scan.nextInt();

            switch (opt) {
                case 1:
                    addProducts(scan);
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    editProduct(scan);
                    break;
                case 4:
                    deleteProduct(scan);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scan.close();
                    return;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    private void addProducts(Scanner scan) {
        System.out.print("Enter Number of Products: ");
        int np = scan.nextInt();

        for (int i = 0; i < np; i++) {
            System.out.println("\nEnter Details for Product " + (i + 1));
            System.out.print("ID: ");
            int pid = scan.nextInt();
            System.out.print("Name: ");
            String pname = scan.next();
            System.out.print("Price: ");
            double pprice = scan.nextDouble();
            System.out.print("Stocks: ");
            int pstocks = scan.nextInt();
            System.out.print("Sold: ");
            int psold = scan.nextInt();
            System.out.println("");

            products[nums] = new Product();
            products[nums].addProducts(pid, name, price, stocks, sold);
            nums++;
        }
    }

    private void viewProducts() {
        if (nums == 0) {
            System.out.println("No products added yet!");
        } else {
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                    "ID", "Name", "Price", "Stocks", "Sold", "Profit", "TEP", "Status");
            for (int i = 0; i < nums; i++) {
                products[i].viewProducts();
            }
        }
    }

    private void editProduct(Scanner scan) {
        System.out.print("Enter the ID of the product to edit: ");
        int idToEdit = scan.nextInt();
        for (int i = 0; i < nums; i++) {
            if (products[i].id == idToEdit) {
                System.out.print("New Name: ");
                products[i].name = scan.next();
                System.out.print("New Price: ");
                products[i].price = scan.nextDouble();
                System.out.print("New Stocks: ");
                products[i].stocks = scan.nextInt();
                System.out.print("New Sold: ");
                products[i].sold = scan.nextInt();
                System.out.println("Product updated.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    private void deleteProduct(Scanner scan) {
        System.out.print("Enter the ID of the product to delete: ");
        int idToDelete = scan.nextInt();
        for (int i = 0; i < nums; i++) {
             if (products[i].id == idToDelete) {
                products[i] = products[nums - 1]; // Move the last product to the deleted spot
                products[nums - 1] = null; // Clear the last product
                nums--;
                System.out.println("Product deleted.");
                return;
            }
        }
        System.out.println("Product not found.");
    }


    private void addProducts(int id, String name, double price, int stocks, int sold) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void getProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

