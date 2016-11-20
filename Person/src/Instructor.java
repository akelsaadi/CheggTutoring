
import java.util.Scanner;

public class Instructor implements Person{
	String department;
        String Fname;
        String Lname;
        String course;
        String idNumber;
        
        public Instructor(Scanner in2)
        {
            in2.useDelimiter("[,\r,\n]+");
            if (in2.hasNext())
            {
                idNumber = in2.next();
                Fname = in2.next();
                Lname = in2.next();
                course = in2.next();   
                
            }
        }
        public String getCourse()
        {
            return course;
        }
        public void setDepartment(String department)
        {
            this.department = department;
        }
        public String getDepartment()
        {
            return department;
        }
        public String toString()
        {
            return "Name: " + Fname + " " + Lname + " " + "ID: " + idNumber + " " + "Course Taught: " + course;
        }
}