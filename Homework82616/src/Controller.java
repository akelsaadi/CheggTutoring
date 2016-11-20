
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ali
 */
public class Controller {
    public void controller()
    {
        int choice; 
        Scanner scan = new Scanner (System.in);
        Course coursea = new Course();

        do
        {
            choice = scan.nextInt();
            if (choice == 1)
            {
                coursea.display();
            }
            else if (choice == 2)
            {
                System.out.print("Enter ID to search for: ");
                String idn = scan.next();
                coursea.displayStudent(idn);
                
            }

        }while (choice!=4);
    }
}
