
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
    public Student (Scanner in)
    {
       if (in.hasNext())
       {
           ID = in.next();
           name = in.next();
           major = in.next();
           letter = in.next();
           
       }
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
    public String toString()
    {
        String output = "";
        output +=  name + letter;
        return output;
    }
    

}
