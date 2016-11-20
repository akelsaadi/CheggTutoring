import java.util.Scanner;

public class MPG {

	public static void main (String[] args)
	{
		double miles;
		double price;
		double consumptionR;
		double costPM;
		double totalCost;
	
		
		Scanner keyboard = new Scanner (System.in);
		
		System.out.println("Enter miles");
		miles=keyboard.nextDouble();
		
		System.out.println("Enter fuel consumption rate in miles per gallon: ");
		consumptionR = keyboard.nextDouble();
		
		System.out.println("Enter price");
		price =keyboard.nextDouble();
		
		costPM = price/consumptionR;
		totalCost = costPM*miles;
		
		
		if(consumptionR <= 20)
		{
		    System.out.println("totalCost: " + totalCost );
		    System.out.println("Bad");
		}
		else if(consumptionR >= 40)
		{
    		System.out.println("totalCost: " +totalCost );
    		System.out.println("Good");
		}
		else
		{
		    System.out.println("total Cost: " + totalCost);
		    System.out.println("Average");
		    
		}
		
	}
}