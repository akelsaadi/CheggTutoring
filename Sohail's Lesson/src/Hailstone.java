
import java.util.Scanner;


public class Hailstone {
     public static void main(String[] args)
      {
         System.out.println("Hailstone Numbers!");
         System.out.print("Enter the start value: ");
         Scanner sc = new Scanner(System.in);
         int start = sc.nextInt();
         int count = hailstone(start);
         System.out.println(" takes " + count + " steps." );
         int count2 = hailstone(start, 1);
         System.out.println(" takes " + count2 + " steps." );
      }
    
         public static int hailstone(int n) 
        {         
             System.out.print(n + "  ");
             if ( n == 1)
             {
                return 1;
             }
             else if (n%2==0)
             {
                return (1 + hailstone(n/2));
             }
             else
             {
                return (1 + hailstone(3*n+1));
             }
		
        }
         
       public static int hailstone(int n, int count)
       {
           System.out.print(n + " ");
           if ( n == 1)
           {
               count += 1;
               return count-1;
           }
           else if (n % 2 == 0)
           {
               count +=1;
               return hailstone(n/2, count);
           }
           else 
           {
               count +=1;
               return hailstone(3*n+1, count);
           }
       }
}
