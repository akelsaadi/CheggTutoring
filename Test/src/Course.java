/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.Scanner;


public class Course {
    private String course;
    private String credit; 
    public Student[] testing = new Student[25];
    private int count;
    public void reader() throws FileNotFoundException {
        
        count = 0;
        
            File file = new File("student.txt");
            Scanner input = new Scanner (file);
            String code = input.nextLine();
            String name = input.nextLine();
            String hours = input.nextLine(); 
                
            System.out.println("code: " + code);
            System.out.println("hours: " + hours);
            System.out.println("name: " + name);
 
            while (input.hasNext() && count < 25)
            {
                testing[count] = new Student(input);
                count++;
            }

 

    }
    public void stGR()
    {
        for (int i=0; i<count; i++)
        {
            System.out.println("Name: " + testing[i].getName() + "    " + "Grade :" + testing[i].getGrade());
        }
    }
    
        public void displayStudent(String IDn)
    {
        for (int i = 0; i<count; i++)
        {
            if (testing[i].getID().equals(IDn))
            {
                System.out.println("Name: " + testing[i].getName() + "   " + "Grade: " + testing[i].getGrade());
            }
        }
    }
        public void gradeavg()
        {
            double num = 0;
            double avg;
            double counter = 0;
            
            for (int i=0; i<count; i++) 
            {
                switch (testing[i].getGrade()) {
                    case "A+":
                        num += 4.33;
                        break;
                    case "A":
                        num += 4;
                        break;
                    case "B+":
                        num += 3.33;
                        break;
                    case "B":
                        num += 3;
                        break;
                    case "C+":
                        num += 2.33;
                        break;
                    case "C":
                        num += 2;
                        break;
                    case "D+":
                        num += 1.33;
                        break;
                    case "D":
                        num += 1;
                        break;
                
                }
                counter ++;
            }
            avg = num/counter;
            System.out.println(avg);
        }
 
}
