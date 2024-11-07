
package rentalmotorcycle;

import java.util.Scanner;

public class Rentalmotorcycle {

    public static void main(String[] args) {
       
  
        
        
        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = true;
            
            
            
            
            System.out.println("1. CUSTOMER");
            System.out.println("2. MOTORCYCLE");
            System.out.println("3. RENTAL");
            System.out.println("4. EXIT");   
            
            System.out.print("Enter Action: ");
            int act = sc.nextInt();
            
            switch(act){
                case 1:
                    customer c = new customer ();
                    c.crecord();
                    break;
                    
                case 2:
                    motorcycle m = new motorcycle ();
                    m.mrecord();
                    break;
                    
                case 3:
                    rental r = new rental ();
                    r.rrecord();
                    break;
                    
                case 4:
                    System.out.println("Exiting... U SURE? (yes/no): ");
                    String resp = sc.next();
                    if(resp.equalsIgnoreCase("yes")){
                        exit = false;
                    }
                    break;
                    
                default:
                    System.out.println("Invalid action. Try Again!!");
                    break;
            }
            while (exit);
            System.out.println("TENKS, BYE!");
        }
        
        }

    }
    

