
import java.util.Scanner;


public class Babylonain 
{

    public static void main(String[] argsdf) 
    {
        double ss = 0;
        double gg = 0;
        double ee = 0;
        System.out.println("Enter Initial number: " ); // prompt user for initial number
        Scanner scan = new Scanner(System.in); // scanner to scan for user input
        ss = scan.nextDouble(); // set ss which is a parameter used below to whatever the user inputted. 
        gg = ss; // set the guess equal to the initial number (whatever the user entered)
        System.out.println("Enter Error margin: ");//prompt user to enter error margin
        ee = scan.nextDouble(); // set ee which is a parameter to the method below to whatever the user inputted. 
        double squareroot = babylonianSqrtmethod(ss, gg, ee); // use the babylonian method and set it to a variable called squareroot
        System.out.println("Square root is:" +squareroot); //print out the babylonian number
    }

	public static double babylonianSqrtmethod(double s, double g, double e) { //takes three parameters, the initial number, the guess, and the error
		double g_new = 0.5*(g + s/g); //this is the new guess( formula from the problem)
		if( Math.abs(g_new - g) > e) { // if new guess - old guess is greater than the error margin then we keep trying, if not we go to else.
			return babylonianSqrtmethod(s, g_new, e); // recursion happens here (we try again, but this time with the new guess)
		} else { 
			return g_new; // if new guess - old guess is less than error then we print out the new guess 
		}
	}
}