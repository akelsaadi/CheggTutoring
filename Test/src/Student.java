/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;


public class Student {
    private String ID;
    private String name;
    private String major;
    private String letter;
    
    public Student (String ID, String name, String major, String letter)
    {
        this.ID = ID;
        this.name = name;
        this.major = major;
        this.letter = letter;
    }
    public void setID(String number)
    {
        this.ID = number;
    }
    
    public void setName(String s)
    {
        this.name= s;
    }
    
    public void setMajor(String m)
    {
        this.major = m;
    }
    public void setGrade(String g)
    {
        this.letter = g;
    }
    public String getID()
    {
        return this.ID;
    }
    public String getName()
    {
        return this.name;
    }
    public String getMajor()
    {
        return this.major;
    }
    public String getGrade()
    {
        return this.letter;
    }
    public Student(Scanner input)
    {
            if (input.hasNext()) 
        {
            String[] split= input.nextLine().split("\\s+");
            {
                ID = split[0];
                name = split[1];
                major = split[2];
                letter = split[3];
                
            }
                
        }
    }
}
