public class MyInteger {

	public static void main (String[] args){
        MyIntegerr n1 = new MyIntegerr();
        MyIntegerr n2 = new MyIntegerr(7);
        
        System.out.println("n1 is even?" + n1.isEven());
        System.out.println("n2 is odd?" + n2.isOdd());
        
        //the even MyInteger test
        MyIntegerr num = new MyIntegerr(2);
        MyIntegerr num1 = new MyIntegerr(3);
        System.out.println("n is even?" + MyIntegerr.isEven(num));
        System.out.println("n1 is odd?" + MyIntegerr.isOdd(num1));
        
        System.out.println("n is even" + MyIntegerr.isEven(2));
        System.out.println("n is odd?" + MyIntegerr.isOdd(7));
	}
}

class MyIntegerr{
	int value;
    MyIntegerr(int newValue) 
    {
    	value = newValue;
    }
    MyIntegerr()
    {
        value = 1082;
    }
    public int getValue(){
    	return this.value;
    }
    
    public static boolean isEven(int n)
    {
        if (n % 2 == 0 ) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean isOdd(int n)
    {
    	if (n % 2 == 1 )
    	{
    	    return true;
    	}
    	else
    	{
    	    return false;
    	}
    }
    
    public static boolean isEven(MyIntegerr n)
    {
    	int num = n.getValue();
    	if ( num % 2 == 0)
    	{
    	    return true;
    	}
    	else
    	{
    	    return false;
    	}
    }
    
    public static boolean isOdd(MyIntegerr n)
    {
    	int num = n.getValue();
    	if ( num % 2 == 1 ) 
    	{
    	    return true;
    	}
    	else
    	{
    	    return false;
    	}
    }
    
    public boolean isEven()
    {
    	if (this.value % 2 == 0 )
    	{
    	    return true;
    	}
    	else 
    	{
    	    return false;
    	}
    	
    }
    
    public boolean isOdd()
    {
    	if (this.value % 2 == 1 ) 
    	{
    	    return true;
    	}
    	else 
    	{
    	    return false;
    	}
    }
    
    

}