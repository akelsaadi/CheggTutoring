
import java.util.Scanner;

public class Main {
	public static void main(String [] args)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter nickles");
            int nickles = in.nextInt();
            System.out.println("Enter Dimes");
            int dimes = in.nextInt();
            System.out.println("Enter Quarters");
            int quarters = in.nextInt();
            System.out.println("Enter Bills");
            int bills = in.nextInt();
            	Money money = new Money(nickles, dimes, quarters, bills);

		
		money.addNickel();
		money.addDime();
		money.addQuarter();
		money.addBill();
		
		System.out.println(money);
                
		
		money.removeNickel();
		money.removeDime();
		money.removeQuarter();
		money.removeBill();
		
		System.out.println(money);
        }
}