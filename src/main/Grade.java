package main;

import java.util.Scanner;


public class Grade {
    
    public void getGradeInput(){
        
        try (Scanner sc = new Scanner(System.in)) {
            Grades[] gr = new Grades[100];
            int nums = 0;
            String option;
            
            do {
                System.out.println("---------------------------------");
                System.out.println("WELCOME TO GRADING APP");
                System.out.println("---------------------------------");
                System.out.println("1. ADD");
                System.out.println("2. VIEW");
                System.out.println("3. EDIT");
                System.out.println("4. DELETE");
                System.out.println("5. EXIT");
                System.out.println("---------------------------------");
                
                System.out.println("Enter Action: ");
                int opt = sc.nextInt();
                
                while (opt > 5){
                    System.out.println("Invalid, Try Again: ");
                    opt = sc.nextInt();
                }
                
                switch (opt) {
                    case 1:
                        System.out.print("Enter no. of students: ");
                        nums = sc.nextInt();
                        
                        for(int i = 0; i < nums; i++) {
                            System.out.println("Enter details of student "+(i+1)+":");
                            System.out.print("ID: ");
                            int id = sc.nextInt();
                            System.out.print("Name: ");
                            String name = sc.next();
                            System.out.print("Prelim: ");
                            double pr = sc.nextDouble();
                            System.out.print("Midterm: ");      
                            double md = sc.nextDouble();
                            System.out.print("Prefinal: ");
                            double pf = sc.nextDouble();
                            System.out.print("Final: ");
                            double fn = sc.nextDouble();
                            
                            gr[i] = new Grades();
                            gr[i].addGrades(name, id, pr, md, pf, fn);
                        }
                        break;
                    case 2:
                        if (nums == 0) {
                            System.out.println("No students added yet!");
                        } else {
                            for(int i=0; i < nums; i++){
                                gr[i].viewGrades();
                            }
                        }
                        break;
                    case 3:
                        if (nums == 0) {
                            System.out.println("No students to edit!");
                        } else {
                            System.out.println("Enter Student ID: ");
                            int sid = sc.nextInt();
                            
                            boolean found = false;
                            for (int x = 0; x < nums; x++){
                                if(gr[x].id == sid){
                                    System.out.println("Enter updated details for student " + gr[x].name);
                                    System.out.print("Prelim: ");
                                    double prl = sc.nextDouble();
                                    gr[x].editGrades(sid, prl); // Edit prelim only for now (can be extended)
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Student ID not found!");
                            }
                        }
                        break;
                    case 4:
                        if (nums == 0) {
                            System.out.println("No students to delete!");
                        } else {
                            System.out.println("Enter Student ID to delete: ");
                            int sid = sc.nextInt();
                            
                            boolean found = false;
                            int deletedIndex = -1;
                            for (int x = 0; x < nums; x++){
                                if(gr[x].id == sid){
                                    found = true;
                                    deletedIndex = x;
                                    break;
                                }
                            }
                            if (found) {
                                
                                for (int i = deletedIndex; i < nums - 1; i++) {
                                    gr[i] = gr[i + 1];
                                }
                                nums--;
                                System.out.println("Student deleted successfully!");
                            } else {
                                System.out.println("Student ID not found!");
                            }
                        }
                        break;
                    case 5:
                        
                        System.out.println("Exiting Grading App.");
                        return;
                    default:
                        System.out.println("Invalid action. Please try again.");
                }
                System.out.print("Do you want to perform another action? (Y/N): ");
                option = sc.next();
            } while (option.equalsIgnoreCase("Y"));
        }
    }

    void getGrade() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
