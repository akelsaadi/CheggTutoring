/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Ali
 */
public class Main {
    
    public static void main (String args[]){
        int choice =0;  
        Course testing = new Course();
        System.out.println("Course information: ");
        testing.reader();
        Scanner scan = new Scanner (System.in);
        while (choice != 4)
        {
            System.out.println("\n1. Display all students and their grades");
            System.out.println("2. Display name and grade of one student given his ID");
            System.out.println("3. Display the course average");
            System.out.println("4. Quit");
            System.out.print("Enter choice: ");
            choice = scan.nextInt();
            
            if (choice == 1 )
                testing.stGR();
            if (choice == 2 )
            {
                System.out.print("Enter ID to search for: ");
                String idn = scan.next();
                testing.displayStudent(idn);
            }
            if (choice == 3)
            {
                testing.gradeavg();
            }
        }
          
            
    }
           
}
