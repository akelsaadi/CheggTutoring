/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework82816;


import java.util.Scanner;

public class BasicInput {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int userInt = 0;
      double userDouble = 0.0;
      char userChar;
      String userString = "";
      
      System.out.println("Enter integer: ");
      userInt = scnr.nextInt();
      System.out.println("Enter double: ");
      userDouble = scnr.nextDouble();
      System.out.print("Enter character: \n");
      userChar = scnr.next().charAt(0);
      System.out.println("Enter string: ");
      userString = scnr.next();
      System.out.println(userInt + " " +  userDouble + " " + userChar + " " + userString );
      System.out.println((int)(userDouble));
      
      
      return;
   }
}