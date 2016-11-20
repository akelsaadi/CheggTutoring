import java.util.Scanner;

public class TicTacToe
{
	
	private static int A1, A2, A3, B1, B2, B3, C1, C2, C3;

	private static Scanner sc = new Scanner(System.in);
	private static Scanner scan = new Scanner(System.in);
			;

	public static void tictactoe()
	{
		intruduction();
		String prompt = "Welcome to Tic-Tac-Toe. Please enter your first move: ";
		String humanMove = "";
		String computerMove = "";
		boolean gameIsWon = false;

	

		for (int i = 1; i <=9; i++)
		{
			

			humanMove = getMove(prompt);
			updateBoard(humanMove, 1);
			displayBoard();
			if (isGameWon())
			{
				System.out.println("You beat me!");
				gameIsWon = true;
				break;
			}

			
			if (i < 9)
			{
				computerMove = getComputerMove();
				System.out.println("I will play at " + computerMove);
				updateBoard(computerMove, 2);
				displayBoard();
				if (isGameWon())
				{
					System.out.println("I beat you!");
					gameIsWon = true;
					break;
				}
				prompt = "Please enter your next move: ";
				i++;
			}
		}
		if (!gameIsWon)
			System.out.println("It's a draw!");
	}
	private static void intruduction()
	{
		System.out.println("" +
				"Tic_tac_toe game\n" +
				"This game is played between you and the computer.\n" +
				"You move first and the computer will then move.\n" +
				"Play continues untill you or the computer wins or\n" +
				"it is a cat's game.");
	}

	private static String getMove(String prompt)
	{
		String play;
		System.out.print(prompt);
		do
		{
			play = sc.nextLine();
			if (!isValidPlay(play))
			{
				System.out.println("That is not a valid play.");
			}
		} while (!isValidPlay(play));
		return play;
	}

	private static boolean isValidPlay(String play)
	{
		if (play.equalsIgnoreCase("A1") & A1 == 0)
			return true;
		if (play.equalsIgnoreCase("A2") & A2 == 0)
			return true;
		if (play.equalsIgnoreCase("A3") & A3 == 0)
			return true;
		if (play.equalsIgnoreCase("B1") & B1 == 0)
			return true;
		if (play.equalsIgnoreCase("B2") & B2 == 0)
			return true;
		if (play.equalsIgnoreCase("B3") & B3 == 0)
			return true;
		if (play.equalsIgnoreCase("C1") & C1 == 0)
			return true;
		if (play.equalsIgnoreCase("C2") & C2 == 0)
			return true;
		if (play.equalsIgnoreCase("C3") & C3 == 0)
			return true;
		return false;
	}

	private static void updateBoard(String play, int player)
	{
		if (play.equalsIgnoreCase("A1"))
			A1 = player;
		if (play.equalsIgnoreCase("A2"))
			A2 = player;
		if (play.equalsIgnoreCase("A3"))
			A3 = player;
		if (play.equalsIgnoreCase("B1"))
			B1 = player;
		if (play.equalsIgnoreCase("B2"))
			B2 = player;
		if (play.equalsIgnoreCase("B3"))
			B3 = player;
		if (play.equalsIgnoreCase("C1"))
			C1 = player;
		if (play.equalsIgnoreCase("C2"))
			C2 = player;
		if (play.equalsIgnoreCase("C3"))
			C3 = player;
	}

	private static void displayBoard()
	{
		String line = "";
		System.out.println();
		line = " " + getXO(A1) + " | " + getXO(A2) + " | " + getXO(A3);
		System.out.println(line);
		System.out.println("-----------");
		line = " " + getXO(B1) + " | " + getXO(B2) + " | " + getXO(B3);
		System.out.println(line);
		System.out.println("-----------");
		line = " " + getXO(C1) + " | " + getXO(C2) + " | " + getXO(C3);
		System.out.println(line);
		System.out.println();
	}

	private static String getXO(int square)
	{
		if (square == 1)
			return "X";
		if (square == 2)
			return "O";
		return " ";
	}

	private static String getComputerMove()
	{
            int localRandomNumber = (int)((Math.random() * 6) + 1);
            for (int i=0; i<localRandomNumber; i++){
		if (localRandomNumber == 1 && A1==0)
			return "A1";
               else if (localRandomNumber == 2 && A2 ==0 )
			return "A2";
               else if (localRandomNumber == 3 && A3 == 0)
			return  "A3";
               else if (localRandomNumber == 4 && B1 == 0 )
			return  "B1";
               else if (localRandomNumber == 5 && B2 == 0)
			return  "B2";
               else if (localRandomNumber == 6 && B3 == 0)
			return  "B3";
               else if (localRandomNumber == 7 && C1 == 0)
			return  "C1";
               else if (localRandomNumber == 8 && C2 == 0) 
			return  "C2";
               else if (localRandomNumber == 9 &&C3 == 0)
			return  "C3";
            }
		return "";
            
	}

	private static boolean isGameWon()
	{
		if (isRowWon(A1, A2, A3))
			return true;
		if (isRowWon(B1, B2, B3))
			return true;
		if (isRowWon(C1, C2, C3))
			return true;
		if (isRowWon(A1, B1, C1))
			return true;
		if (isRowWon(A2, B2, C2))
			return true;
		if (isRowWon(A3, B3, C3))
			return true;
		if (isRowWon(A1, B2, C3))
			return true;
		if (isRowWon(A3, B2, C1))
			return true;
		return false;
	}

	private static boolean isRowWon(int a, int b, int c)
	{
		return ((a == b) & (a == c) & (a != 0));
	}
}