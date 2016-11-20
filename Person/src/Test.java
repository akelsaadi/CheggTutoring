
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
public class Test {

       
      Student aStudent [];
      Instructor aInstructor [];
      public Scanner in;
      public Scanner in2;
      int count = 0;
      int count2 = 0;
      public Test()
      {
          aStudent = new Student [5000];
          aInstructor = new Instructor [5000];
          try 
          {
              File f = new File ("Instructor Data.csv");
              File file = new File ("Student Data.csv");
              in = new Scanner(file);
              in2 = new Scanner(f);
          }
          catch (FileNotFoundException err)
          {
              System.err.println("/nCannot open");
          }
          while (in.hasNext())
          {
              aStudent[count] = new Student (in);
              count ++;
          }
          while (in2.hasNext())
          {
              aInstructor[count2] = new Instructor(in2);
              count2 ++;
          }
          
      }
      
      public void displayCourse(String course)
      {
          for (int i = 0; i<count; i++)
          {
              if (aStudent[i].getDesClass().equals(course))
              {
                 System.out.println(aStudent[i].toString());
              }
          }
          for (int i =0; i<count2; i++)
          {
              if (aInstructor[i].getCourse().equals(course))
              {
                  System.out.println(aInstructor[i].toString());
              }
          }
      }

      public static void main(String[] args)
      {
          Test tt = new Test();
          //testing for one course. 
          tt.displayCourse("COMP 182");
      }
    
}
