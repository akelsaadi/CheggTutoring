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
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char user1;
        char user2;      
        Scanner scanner = new Scanner(System.in);
        System.out.println("User 1, Enter move: R for Rock, P for Paper, S for Scissors, Q for Quit");
        user1 = scanner.next().charAt(0);
        System.out.println("User 2, Enter move: R for Rock, P for Paper, S for Scissors, Q for Quit ");
        user2 = scanner.next().charAt(0);
        if (user1 == 'Q' || user2 == 'Q' )
        {
            System.exit(0);
        }
        if (user1 == 'P' && user2 == 'P' || user1 =='R' && user2 =='R' || user1 == 'S' && user2 == 'S')
        {
            System.out.println("Tie Game, no Winner");
            System.exit(0);           
                    
        }
        if (user1 == 'R')
        {
            if (user2 == 'P')
                System.out.println("User 2 wins");
            else if (user2 == 'S')
                System.out.println("User1 wins"); 
        }
        else if (user1 == 'P')
        {
            if (user2 == 'S')
                System.out.println("User 2 wins");
            else if (user2 == 'R')
                System.out.println("User 1 wins");
            
        }
        else  if (user1 == 'S')
        {
            if (user2 == 'R')
                System.out.println("User 2 wins");
            else if (user2 == 'P')
                System.out.println("User 1 wins");
                        
        }
        else 
        {
            System.out.println("Invalid Entry(s)");
            System.exit(0);
        }
    }
}
