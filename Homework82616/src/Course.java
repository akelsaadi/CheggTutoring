
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ali
 */
public class Course {
    Student aStudent[];
    public Scanner in;
    int count = 0;
    public Course() {
        aStudent =  new Student [25];
        try {
            File file = new File ("student.txt");
            in = new Scanner(file);
        }
        catch (FileNotFoundException err){
            System.err.println("/nCannot open");
        }
        while (in.hasNext())
        {
            aStudent[count] = new Student(in);
            count ++;
        }
        
    }
    public void displayStudent(String IDn)
    {
        for (int i = 0; i<count; i++)
        {
            if (aStudent[i].getID().equals (IDn))
            {
                System.out.println("Name: " + aStudent[i].getName()+ " "+ aStudent[i].getGrade());
            }
        }
    }
    public void display()
    {
        for (int i = 0; i<count; i++)
        {
            System.out.println("Name: " + aStudent[i].toString());
        }
    }
}
