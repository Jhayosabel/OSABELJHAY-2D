
package main;


public class Products {
    
    int id;
    String name;
    double price;
    int stocks;
    int sold;

    
    public void addProducts(int id, String name, double price, int stocks, int sold) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stocks = stocks;
        this.sold = sold;
    }

    
    public void viewProducts() {
        double profit = price * sold;
        double tep = profit - (price * stocks); // Total Estimated Profit
        System.out.printf("%-10d %-10s %-10.2f %-10d %-10d %-10.2f %-10.2f %-10s\n",
                id, name, price, stocks, sold, profit, tep, stocks > 0 ? "Available" : "Out of Stock");
    }
}

