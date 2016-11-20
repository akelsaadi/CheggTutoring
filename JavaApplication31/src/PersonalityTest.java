import java.util.*;															//Import utility packages
import java.io.*;

public class PersonalityTest { 
	public static void main (String[] args) throws FileNotFoundException {	//Main method header 
		Scanner console = new Scanner(System.in);
		System.out.println("Input file name: ");							//Prompt the user for file name input
		String name1 = console.nextLine();									//File name "name1"
		File name = new File(name1);										//Create a new file under "name1"
		do {												//If this file did not exist(TESTING)
			System.out.println("File not found. Try again: " + name1);		//Prompt the user to type again
			name1 = console.nextLine();
		    name = new File(name1);
		} while (!name.exists());
		System.out.println("Output file name: output.txt");					//Successful input: directed to the output file
		Scanner input1 = new Scanner(new File(name1));						//Create a scanner object using the file "personality.txt"
		PrintStream output = new PrintStream(new File("output.txt"));       //Create an output file "output.txt"
		int count = 0;														//Initializing line counter as 0
		while (input1.hasNextLine()) {										//While there's more lines in the input file
			count++;														//line counter incremented
			String line = input1.nextLine();								//String the next line
			
			if (count % 2 == 1) {											//If odd numbered line
				output.println(line + " : ");								//It's the name line and print
			} else {														//Otherwise answer key
				char a = 'a';												//Create 2 targeted characters
				char b = 'b';
				int [] countA = count(line,a);								//Return the arrays contain the counts of "a","b"
				int [] countB = count(line,b);
				int [] percent = percent(countA,countB);					//Return the arrays containing the percentage of b
				for(int i = 0; i <= 3; i++) {								//Prints out the outcome of 
					output.print(countA[i]+"A-"+countB[i]+"B  ");			//the numbers of "a" and "b"
				}
				output.println();
				output.print("[");
				for(int j = 0; j <= 2; j++){								//Prints out the percentage outcome
					output.print(percent[j]+"%,");
				}
				output.print(percent[3]+"%]  =  ");
				type(percent,output);										//Output the type results
			}
		}
	}
	public static int[] count(String input, char letter) throws NoSuchElementException{
		int [] count = new int [4];											//Creating a new array that counts the occurrences of each character
		input = input.toLowerCase();										
		for(int i = 0; i < input.length(); i++) {							//Use the for-loop to create the counter array
			char answer = input.charAt(i);
			if (answer == letter) {
				if(i % 7 == 0) {			
					count[0]++;
				}
				if(i % 7 ==1 || i % 7 == 2){
					count[1]++;
				}
				if(i % 7 == 3 || i % 7 == 4){
					count[2]++;
				}
				if(i % 7 ==5 || i % 7 == 6){
					count[3]++;
				}
			}
		}
		return count;
	}
	
	public static int[] percent(int[] counta, int[] countb) {				//Use a static method to create an array counting percentage
		int [] percent = new int [4];										//Creating a new array counting the percentage of b
		for(int i = 0; i <= 3; i++) {										
			percent[i] = (countb[i] * 100)/(counta[i] + countb[i]);			//Calculating the percentage
		}
		return percent;														//Returning the array									
	}
	public static void type(int [] percent, PrintStream output) {			//Static method that prints out the counts
		
		if (percent[0] >= 50) {												//If the percentage of b for dimension A is larger 
			output.print("I");												//Introverted
		} else {															//Otherwise extrovert
			output.print("E");
		}
		if (percent[1] >= 50) {
			output.print("N");												//Intuition
		} else {
			output.print("S");												//Otherwise Sensation
		}
		if (percent[2] >= 50) {
			output.print("F");												//Feeling
		} else {
			output.print("T");												//Otherwise Thinking
		}
		if (percent[3] >= 50) {
			output.println("P");											//Perceiving
		} else {
			output.println("J");											//Otherwise Judging
		}
	}
}
			
						
		
		