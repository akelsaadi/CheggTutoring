
import java.util.Scanner;

public class Driver {

    public static void main(String[] args){

        Grade student = new Grade("Jerry White");
        String temp;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the grade: " +"Enter 'Q' to Quit");
        String Gradescore = in.next();
        
        while (!Gradescore.equals("Q"))
        {
            student.ScoreConverter(Gradescore);
            Gradescore = in.next();
        }
        
        System.out.println("The GPA of "  + student.getName() + " is " + student.getGPA() +".");
    }
}