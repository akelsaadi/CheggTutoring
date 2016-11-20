package a1adept;

import java.util.Scanner;

public class A1Adept {

	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
		
	}
	
	public static void process(Scanner s) {
		int numberOfAssignments = s.nextInt();
	//Iterates through the Scanner input for however many assignments there are to store the max. points
	//a student can score.
		int maxPoints[] = new int[numberOfAssignments];
		for(int t = 0; t < numberOfAssignments; t++){
			maxPoints[t] = s.nextInt();
		}
		
		int numberStudents = s.nextInt();
		
			for(int i = 0; i < numberStudents; i++){
				
				String studentNames[] = {s.next(), s.next()};	
				
				int numberOfRecitations = s.nextInt();
				double recitationGrade = (double)numberOfRecitations / 15.0;
				
				double[] assignmentScores = new double[numberOfAssignments];
				double assignmentAverage = 0;
				double assignmentPoints = 0;
				
			//Established for loop to iterate through students' assignment scores and calculate the sum of all their assignment grades (100-point scale).
				for(int j = 0; j < numberOfAssignments; j++) {
					assignmentScores[j] = s.nextDouble();
					assignmentPoints += maxPoints[j];
					assignmentAverage += assignmentScores[j];
				}
				
			//Average the sum of the assignment grades, then convert from 100-point scale to 4.0 scale via method. Finally, weight the converted average.
				assignmentAverage = (percentageConversion(assignmentAverage/assignmentPoints)* .4);
				
				double testGrades[] = {s.nextDouble(), s.nextDouble(), s.nextDouble()};
				
				double weightedAverage = assignmentAverage + 
									 	 (percentageConversion(recitationGrade) *.1) + 
									 	 (testGrades[0]*.15) + 
									 	 (testGrades[1]*.15) + 
									 	 (testGrades[2]*.2);
											
				String[] firstName = {studentNames[0]};
				char firstInitial = firstName[0].charAt(0);
				
				String letterGrade = "A";
				
				if(weightedAverage >= 3.85){
					letterGrade = "A";
				} else if(weightedAverage >= 3.5 && weightedAverage < 3.85){
					letterGrade = "A-";
				} else if(weightedAverage >= 3.15 && weightedAverage < 3.5){
					letterGrade = "B+";
				} else if(weightedAverage >= 2.85 && weightedAverage < 3.15){
					letterGrade = "B";
				} else if(weightedAverage >= 2.5 && weightedAverage < 2.85){
					letterGrade = "B-";
				} else if(weightedAverage >= 2.15 && weightedAverage < 2.5){
					letterGrade = "C+";
				} else if(weightedAverage >= 1.85 && weightedAverage < 2.15){
					letterGrade = "C";
				} else if(weightedAverage >= 1.5 && weightedAverage < 2.15){
					letterGrade = "C-";
				} else if(weightedAverage >= 1.15 && weightedAverage < 1.5){
					letterGrade = "D+";
				} else if(weightedAverage >= 0.85 && weightedAverage < 1.15){
					letterGrade = "D";
				} else if(weightedAverage < 0.85){
					letterGrade = "F";
				} else {
					letterGrade = "A";
				}
				
				System.out.print(firstInitial + ". " + studentNames[1] + " ");
				System.out.println(letterGrade);
			}
			
	}
	
	//Created a method that uses linear interpolation to convert from 100-point scale to 4.0 scale.
	
	public static double percentageConversion(double a){
		double conversion = a;
		
		if(a >= .95) {
			conversion = 4.0;
		} else if(a < .95 && a >= .9) {
			conversion = (((a - .9) / (.95-.9)) * (4.0 - 3.5)) + 3.5;
		} else if(a < .9 && a >= .8) {
			conversion = (((a - .8) / (.9-.8)) * (3.5 - 2.5)) + 2.5;
		} else if(a < .8 && a >= .7) {
			conversion = (((a - .7) / (.8-.7)) * (2.5 - 1.5)) + 1.5;
		} else if(a < .7 && a >= .4) {
			conversion = (((a - .4) / (.7-.4)) * (1.5 - 0.0)) + 0.0;
		}
		return conversion;
	}
}