
import java.util.Scanner;

public class Calculator{

    public static void main (String[] args )
    {
        String option;
        System.out.println("Please choose a distance to calculate or type 'Quit' to quit: "); 
        System.out.println("1. Euclidean ");
        System.out.println("2. Cityblock");
        System.out.println("3. Chessboard");
        System.out.println("4. Angle");
        System.out.println("5. Slope");
        Scanner scan = new Scanner(System.in);
        option = scan.next();
        while(!"Quit".equals(option))
        {
            double x1, y1, x2, y2;
                System.out.println("x1: ");
                x1 = scan.nextDouble();
                System.out.println("x2: ");
                x2 = scan.nextDouble();
                System.out.println("y1: ");
                y1 = scan.nextDouble();
                System.out.println("y2: ");
                y2 = scan.nextDouble();
            if("1".equals(option))
            {  
                System.out.println("Euclidean Calculation: " + euclidean(x1,x2,y1,y2));
            }
            if("2".equals(option))
            {
                System.out.println("CityBlock Calculation: " +  cityblockDistance(x1,x2,y1,y2));
            }
            if("3".equals(option))
            {
                System.out.println("Chess board Calculation: " + chessboardDistance(x1,x2,y1,y2));
            }
            if ("4".equals(option))
            {
                System.out.println("Angle Calculation: " + angle(x1,x2,y1,y2));
            }
            if ("5".equals(option))
            {
                System.out.println("Slop Calculation: " + angle(x1,x2,y1,y2));
            }
            else
            {
                System.out.println("Please choose a distance to calculate or type 'Quit' to quit: "); 
                System.out.println("1. Euclidean ");
                System.out.println("2. Cityblock");
                System.out.println("3. Chessboard");
                System.out.println("4. Angle");
                System.out.println("5. Slope");
                option = scan.next(); 
            }
                
        }
        

    }
    
    public static double euclidean(double x1, double y1, double x2, double y2)
    {
        double euclideanDistance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return euclideanDistance;
        
    }
   
    public static double chessboardDistance(double x1, double x2, double y1, double y2)
    {
        double chessboardCalculate = (Math.abs(x2 - x1) + Math.abs(y2 - y1))/2;
        return chessboardCalculate;
    } public static double cityblockDistance(double x1, double x2, double y1, double y2)
    {
        double CalculateCityblock = Math.abs(x2 - x1) + Math.abs(y2 - y1);
        return CalculateCityblock;
    }
    public static double angle(double x1, double x2, double y1, double y2)
    {
        double CalculateAngle = Math.toDegrees(Math.asin((y2-y1)/(x2-x1)));
        return CalculateAngle;
    }
    
        public static double Calculateslope(double x1, double x2, double y1, double y2)
    {
        double Num = y2 - y1;
        double Denom = x2 - x1;
        double slope = (Num / Denom);
        return slope;
    }
}