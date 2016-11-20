/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevin;

import java.util.Scanner;

/**
 *
 * @author Ali
 */
public class Kevin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    
        double length = 0;
        double width = 0;
        double radius;
        final double costFencing = 2.50;
        final double costSod = 1.50;
        double areaFencing = 0;
        double totalFencing = 0;
        double sod = 0;
        double totalSOD = 0;
        double totalcost = 0;
        
        
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter length: ");
        length = s.nextDouble();
        System.out.println("Enter width: ");
        width = s.nextDouble();
        System.out.println("Enter radius: ");
        radius = s.nextDouble();
        areaFencing = length*width;
        areaFencing = (int)(areaFencing);
        System.out.println();
        System.out.println("Area of fencing: " + areaFencing);
        totalFencing = areaFencing * costFencing; 
        System.out.println("Total cost of fencing: " + totalFencing);
        sod = areaFencing - radius;
        System.out.println("SOD: " + sod);
        totalSOD = sod * costSod;
        System.out.println("Cost of SOD: " + totalSOD);
        totalcost = totalFencing + totalSOD;
        System.out.println("Total Cost: " + totalcost);
        
    }
    
}
