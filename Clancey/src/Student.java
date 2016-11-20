public class Student {

	private String name;
	private int IDNumber;
	private double GPA;
	private int NumberOfHours;
	private String Classification;
        
	public Student(String n, int i, double g, int h){ // You defined a constructor with parameters but did not use those parameters to set them to the variables above.
            name = n;
            IDNumber = i;
            GPA = g;
            NumberOfHours = h;
	}
        public Student() // we created a default constructor ( there has to be two constructors according to the assignment
        {
            
        }

	public void setName (String n)
	{ 
		name = n;
	}
	public void setIDNumber (int i)
	{
		IDNumber = i;
	}
	public void setGPA (double g)
	{
		GPA = g;
	}
	public void setNumberOfHours (int h)
	{
		NumberOfHours = h;
	}
	public String getName()
	{
		return name;
	}
	public int getIDNumber()
	{
		return IDNumber;
	}
	public double getGPA()
	{
		return GPA;
	}
	public int getNumberOfHours()
	{
		return NumberOfHours;
	}
	public String Classification() // Your professor said that classification is a method, therefor it should not be neither a getter or a setter.
        //Therefor, we define everything related to it here, this is where the method is defined and we use the operators > < && for comparisons.
	{
		if (NumberOfHours >= 0  && NumberOfHours < 30)
                    Classification = "Freshman";
                else if(NumberOfHours >= 30 && NumberOfHours <= 59 )
                    Classification = "Sophomore";
                else if(NumberOfHours >=60 && NumberOfHours <= 89 )
                    Classification = "Junior";
                else if(NumberOfHours >= 90 && NumberOfHours <= 120)
                    Classification = "Senior";
                else
                    System.out.println("Invalid Entry");
                
                return Classification;
		
	}

}