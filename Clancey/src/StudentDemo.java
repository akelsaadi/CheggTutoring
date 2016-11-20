import java.util.Scanner;
// The purpose of this program is to simulate the shopping process by calculating the cost of the items
// and producing a receipt for Vic's SweetShop
public class StudentDemo {
	private static Scanner keyboard;

	public static void main(String[] args){
		Student Student1 = new Student(); //Here you were using the constructor with the parameters, you should instead be using the default constructor.
                Student Student2= new Student();
		String StudentName;
		int StudentIDNumber;
		double StudentGPA;
		int StudentNumberOfHours = 0;
                boolean check = true;
		
		keyboard = new Scanner(System.in);
		
		System.out.println("Please Enter Your Name");
		StudentName = keyboard.nextLine();
		
		System.out.println("Please Enter Your ID Number");
		StudentIDNumber = keyboard.nextInt();
		
		System.out.println("Please Enter Your Current GPA");
		StudentGPA = keyboard.nextDouble();
		
		do // Your professor said to have the number of hours between 0 and 120 and if the user enters anything other than that 
                    // to ask again and prompt user to enter the number once more.
                    // this is done by a while loop with the help of a boolean to set false when the user enters the right numbers
                    // if it's not false, it will keep looping until it's false.
                {   
                    System.out.println("Please Enter Your Current Number of Hours in Numerical Form");
                    StudentNumberOfHours = keyboard.nextInt();
                    if (StudentNumberOfHours >= 0 && StudentNumberOfHours <= 120 )
                    {
                        check = false;
                    }
                    else 
                        System.out.println("Invalid Entry");
                }while(check);
                check = true; // after we exit the while loop we set the boolean to true again to be able to use it again. That is because when we exit the loop it was set to false. 
		
		Student1.setName(StudentName);
		Student1.setIDNumber(StudentIDNumber);
		Student1.setGPA(StudentGPA);
		Student1.setNumberOfHours(StudentNumberOfHours);
		
		
		System.out.println("The Name You Entered is: " + Student1.getName()); // here you were not utilizing the getter like you should be. same goes for the next three statements.
		
		System.out.println("Your Current GPA is: " + Student1.getGPA());
                
                System.out.println("Your ID number is: " + Student1.getIDNumber());
		
		System.out.println("Your Current Classification is a: "+ Student1.Classification());
		
		
	
		
		System.out.println("Please Enter Your Name");
		StudentName = keyboard.next(); // Here you had keyboard.nextLine() which will basically skip this line and go to "Please Enter Your ID Number, and in turn you'll mess up everything"
		
		System.out.println("Please Enter Your ID Number");
		StudentIDNumber = keyboard.nextInt();
		
		System.out.println("Please Enter Your Current GPA");
		StudentGPA = keyboard.nextDouble();
		
		do
                {   
                    System.out.println("Please Enter Your Current Number of Hours in Numerical Form");
                    StudentNumberOfHours = keyboard.nextInt();
                    if (StudentNumberOfHours >= 0 && StudentNumberOfHours <= 120 )
                    {
                        check = false;
                    }
                    else 
                        System.out.println("Invalid Entry");
                }while(check);
		
		Student2.setName(StudentName);
		Student2.setIDNumber(StudentIDNumber);
		Student2.setGPA(StudentGPA);
		Student2.setNumberOfHours(StudentNumberOfHours);		
	
		System.out.println("The Name You Entered is " + Student2.getName());
		
		System.out.println("Your Current GPA is " + Student2.getGPA());
                
                System.out.println("Your ID number is: " + Student2.getIDNumber());
		
		System.out.println("Your Current Classification is "+ Student2.Classification());
}
}