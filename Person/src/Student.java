
import java.util.Scanner;


public class Student implements Person{
	String Fname;
        String Lname;
        String Clevel;
        String DesClass;
        String idNumber;
        String credits;
        String gradePoints;
        
        public Student (String FnameIn, String LnameIn, String ClevelIn, String DesClassIn, String idNumberIn, String creditsIn, String gradePointsIn)
        {
            Fname = FnameIn;
            Lname = LnameIn;
            Clevel = ClevelIn;
            DesClass = DesClassIn;
            idNumber = idNumberIn;
            credits = creditsIn;
            gradePoints = gradePointsIn;
        }
        public Student(Scanner in)
        {
            in.useDelimiter("[,\r\n]+");
            if (in.hasNext())
            { 
                idNumber = in.next();
                Fname = in.next();
                Lname = in.next();
                Clevel = in.next();
                DesClass = in.next();
                credits = in.next();
                gradePoints = in.next();
                
            }
        }
        public String getFName()
        {
            return Fname;
        }
        public String getLName()
        {
            return Lname;
        }
        public String getID()
        {
            return idNumber;
        }
        public String getCredits()
        {
            return credits;
        }
        public String getDesClass()
        {
            return DesClass;
        }
        public String getGradePoints()
        {
            return gradePoints;
        }
        public void setCredits(String credits)
        {
            this.credits = credits;
        }
        public void setGradePoints(String gradePoints)
        {
            this.gradePoints = gradePoints;
        }
        public int calculateGPA()
        {
            int gp = Integer.parseInt(gradePoints);
            int cr = Integer.parseInt(credits);
            
            return (gp/cr);
        }
        public boolean equals(Student a, Student b)
        {
            if(a.idNumber.equals(b.idNumber))
            {
                return true;
            }
            else
            {
                return false;
            }
	}
        public String toString()
        {
            return "Name: " + Fname + " " +  Lname + " ID: " + idNumber + " " + "Class Level: " + Clevel
            + " " + "Desired Class: " + DesClass + " " + "Credits: " + credits + " " + "Points: " + gradePoints;
        }
        
		
}

