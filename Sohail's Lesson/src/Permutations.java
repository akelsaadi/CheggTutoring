import java.util.Scanner;
   public class Permutations
   {
      private static int numPrimes = 0; 
      public static void main(String[] args)
      {
         Scanner sc = new Scanner(System.in);
         System.out.print("\nHow many digits? ");
         String s = sc.next();
         int n = Integer.parseInt(s);
        // oddDigits("", n);
        //leftRight("", n);
         superprime(n);
      
      }
      
      public static void leftRight(String s, int n)
      {
         int x = s.length();
        if(x == n){
        System.out.println(s);
        
        }
        else
        {
        leftRight(s + "L", n);
        leftRight(s + "R", n);
        }

      }
             
      public static void oddDigits(String x, int n)
      {
         if(x.length() == n)
            System.out.println(x);
         else
         {
            oddDigits(x + "1", n); 
            oddDigits(x + "3", n);
            oddDigits(x + "5", n);
            oddDigits(x + "7", n);
            oddDigits(x + "9", n);
         }
      }
      
   	//the SuperPrime methods 
      public static void superprime(int n)
      {
         recur(2, n); //try leading 2, 3, 5, 7, i.e. all the single-digit primes
         recur(3, n); 
         recur(5, n);
         recur(7, n); 
      }
      private static void recur(int k, int n)
      {
      
         int length = getLengthInt(k); 
         if(length == n)
         { 
            numPrimes++; 
            System.out.println(numPrimes + ": " + k);
         }
         else
         {
            String kString = k + ""; 
            if(isPrime(Integer.parseInt(kString + "1")))
               recur(Integer.parseInt(kString + "1"), n); 
            if(isPrime(Integer.parseInt(kString + "3")))
               recur(Integer.parseInt(kString + "3"), n);  
            if(isPrime(Integer.parseInt(kString + "7")))
               recur(Integer.parseInt(kString + "7"), n); 
            if(isPrime(Integer.parseInt(kString + "9")))
               recur(Integer.parseInt(kString + "9"), n); 
         }   
      } 
      private static int getLengthInt(int n)
      {
         String numString = n + ""; 
         int s = numString.length(); 
         return s; 
      }
      private static boolean isPrime(int n)
      {
         return isPrimeHelper(n, n-1); 
      }   
      private static boolean isPrimeHelper(int x, int y)
      {
         if(x == 1)
            return false; 
         if(y <= 1)
            return true;
         else if( x % y == 0)
            return false; 
      	 
         return isPrimeHelper(x, y - 1);
      	  
      }
   }