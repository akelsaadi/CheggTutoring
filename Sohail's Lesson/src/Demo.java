import java.util.Scanner;
public class Demo
{
	public static void main(String [] args) 
	{
		int choiceNumber = 0;
		intruduction();
		while(choiceNumber != 7)
		{
			printMenuChoices();
			choiceNumber = readChoiceNumber();
			switch (choiceNumber)
			{
			/*case 1:
				DiceFaceInARow.diceface();
				break;
			case 2:
			PrintRandomChart.randomChart();
			break;
			case 3:
				PatternOfSix.patternOfSix();
		
		    break;
			case 4:
				RandomDistribution.randomDistribution();
				break;*/
			case 5:
				TicTacToe.tictactoe();
				break;
			/*case 6:
				FiveDigitNumber.fivedigitnumber();
			case 7:
				System.out.println("                     Thank you for learning the examples.");
				choiceNumber = 7;
				break;*/
			default:
				System.out.println("         Invalid choice.  The game is over.");
				choiceNumber = 7;
				break;
			}//switch

		}//while
	}
	private static void intruduction()
	{
		System.out.println("\n\n" +
				"                   Ten empty lines are added.  This is useful.\n\n\n\n\n\n\n\n\n\n");
		System.out.println("" +
				"                   This program demonstrates the framework\n" +
				"                            of the games projects.\n"+
				"                      \n" );
	}
	private static void printMenuChoices()
	{
		System.out.println(""+
				  "                      Testing an example project.\n"
				+ "                        1) DiceFaceInARow project.\n"
				+ "                        2) PrintRandomChart project.\n"
				+ "                        3) PatternOfSix project.\n"
				+ "                        4) RandomDistribution project.\n"
				+ "                        5) Tic Tac Toe project.\n"
				+ "                        6) FiveDigitNumber project.\n"
				+ "                        7) Quit playing this example. \n"
				+ "                      Please choose one of the two choices.");

	}
	private static int readChoiceNumber()
	{
		Scanner scan = new Scanner(System.in);
		int choiceNumber;
		String indent = "                   ";
		choiceNumber = scan.nextInt();
		while(choiceNumber < 1 || choiceNumber > 7)
		{
			System.out.println(indent + "the number must be 1 through 7 inclusive");
			System.out.println(indent + "    please enter a proper choice.  ");
			choiceNumber = scan.nextInt();
		}
		return choiceNumber;
	}
}