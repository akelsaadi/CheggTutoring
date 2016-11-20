import java.io.*;
import java.util.*;

public class PersonalityTesting{
    //class constants
    public static final int DIMENSIONS = 4;
    public static final String set1 = "1 8 15 22  29 36 43 50 57 64";
    public static final String set2 = "2 3 9 10 16 17 23 24 30 31 37 38 44 45 51 52 58 59 65 66";
    public static final String set3 = "4 5 11 12 18 19 25 26 32 33 39 40 46 47 53 54 60 61 67 68";
    public static final String set4 = "6 7 13 14 20 21 27 28 34 35 41 42 48 49 55 56 62 63 69 70";

    public static void main(String[] args) throws FileNotFoundException {
        giveIntro();
        Scanner keyboard = new Scanner(System.in);
        Scanner input = getInput(keyboard);
        PrintStream out = getOutput(keyboard);
        processing(input, out);
    }



    /* This method prompts the user for an output file name so
     the result of this program can be written to it. 
     This method will keep prompting the user until we get a valid file name and returns the file object  */
    public static PrintStream getOutput(Scanner keyboard) throws FileNotFoundException {
        System.out.print("Output file name: ");
        String name = keyboard.nextLine();
        return new PrintStream(new File(name));
    }


  // uses the given A and B count arrays to compute and return
   // a new array of the percentage of B answers out of the (A+B) total
   // for each dimension
   public static int[] percents(PrintStream out, int[] aCount, int[] bCount){
                int [] percent = new int [4];
                out.print("[");
		for(int i = 0; i <= 3; i++) {										
			percent[i] = (bCount[i] * 100)/(aCount[i] + bCount[i]);	
                        out.print(percent[i]+"%" +", ");
		}
                out.print("]" +"=");
                
		return percent;
                
   }




    /* This method process the file that conatins  the information.
    the parameters to this method are the input file object and the output file object.
    this method reads the inforamtion for each person. the first line holds he name of
    the person and the next line holds the user's answers to the personality questions. 
    after reding the answers to the questions for the person, methods count and percent and personalityType
    must be called in this method*/ 
    public static void processing(Scanner input, PrintStream out){
        String name;
        String answers;
        while (input.hasNextLine())
        {
            name = input.nextLine();//reads the name of the person
            answers = input.nextLine();//read the answers given
            for (int j = 0; j <= answers.length()-1; j++){
               answers.charAt(j);
               int question = j + 1;
            }
            int[] aCount = new int [4];
            int[] bCount = new int [4];
            out.println(name + ":");
            count(out,answers,aCount,bCount);
            int[]percents = percents(out,aCount,bCount);
            personalityType(out, percents);
        }       
    }

   public static void output(PrintStream out, int[] aCount, int[] bCount){
         for (int j = 0; j <= 3; j++){
            out.print(" " + aCount[j] + "A-" + bCount[j] + "B"); 
         }
         out.println();
   }



    /* Fills the aCount and bCount arrays with counts of how many
     As and Bs this person answered in each dimension. 
    the methods isInTheSet and output neeeds to be called in this method*/
    public static void count(PrintStream out, String answers, int[] aCount, int[] bCount){
        int index = 0;
        for (int j = 0; j <= answers.length()-1; j++){
            if (inTheSet(set1, j+1))
               index = 0;
            if (inTheSet(set2, j+1))
               index = 1;
            if (inTheSet(set3, j+1))
               index = 2;
            if (inTheSet(set4, j+1))
               index = 3;
            if (answers.charAt(j) == 'A')
               aCount[index]++;//adding up how many A responses there were
            if (answers.charAt(j) == 'a')
               aCount[index]++;
            if (answers.charAt(j) == 'B')
               bCount[index]++;//adding up how many B responses there were
            if (answers.charAt(j) == 'b')
               bCount[index]++;
        }
        output(out, aCount, bCount);
    }
   /*This method outputs the content of the array aCount
    and bCount to the output file. refer to the provided output file*/                         

   /*This method finds if the question number being processed is in the given set or not*/
   public static boolean inTheSet(String set, int num)
   {
         Scanner token = new Scanner(set);
         while (token.hasNext()){
            String s = token.next();
            int n = Integer.parseInt(s);
            if (n == num){
               return true;
            }
          }
          return false;
   }

 

    // returns the personality type that corresponds to the given
    // percentages, such as "IXTJ"
   public static void personalityType(PrintStream out, int[] percents)
   {
    		if (percents[0] >= 50) {												//If the percentage of b for dimension A is larger 
			out.print("I");												//Introverted
		} else {															//Otherwise extrovert
			out.print("E");
		}
		if (percents[1] >= 50) {
			out.print("N");												//Intuition
		} else {
			out.print("S");												//Otherwise Sensation
		}
		if (percents[2] >= 50) {
			out.print("F");												//Feeling
		} else {
			out.print("T");												//Otherwise Thinking
		}
		if (percents[3] >= 50) {
			out.println("P");											//Perceiving
		} else {
			out.println("J");											//Otherwise Judging
		}
   
   
   
   }

    /*This method prompts the user for a file name that holds the information for this program 
     your program must keep asking for a file name that exists in the current directory
    console Scanner until the user gives a legal file name. this method returns the file object*/
   public static Scanner getInput(Scanner keyboard) throws FileNotFoundException {
        System.out.print("Input file name: ");
        String name = keyboard.nextLine();
        File firstInput = new File(name);
        while (!firstInput.exists()){
        System.out.print("File not found. Try again: ");
        name = keyboard.nextLine();
        firstInput = new File(name);//prompt the user for a different file name when it is invalid
      }      
        return new Scanner(firstInput);
   }



public static void giveIntro()
{
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter.  It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();

   }
}
