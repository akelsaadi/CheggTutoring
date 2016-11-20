import java.io.*; //the File
import java.util.*; //the Scanner
import javax.swing.*; //the JOptionPane
    public class Search_Driver {
    public static void main(String[] args) throws Exception 
    {
            Comparable arr[] = input("declaration.txt");
            sort(arr);
            System.out.print("Enter a word: ");
            Scanner x = new Scanner(System.in);
            Comparable in = x.next();
            int pos1 = Searches.linear(arr, in );
            int pos2 = Searches.binary(arr, in );
            int linearCount = Searches.linearCount();
            int binaryCount = Searches.binaryCount();
            System.out.println("Linear search found it at location " + pos1 + " in " + linearCount + " comparisons.");
            System.out.println("Binary search found it at location " + pos2 + " in " + binaryCount + " comparisons.");
     }
     public static String[] input(String filename) throws Exception 
     {
        Scanner infile = new Scanner(new File(filename));
        String[] array = new String[1325];
        for (int i = 0; i < array.length; i++) {
            array[i] = infile.next();
        }
        infile.close();
        return array;
     }
     public static void sort(Comparable[] array) 
     {
            int maxPos;
            for (int x = 0; x < array.length; x++) 
            {
                  maxPos = findMax(array, array.length - x);
                  swap(array, maxPos, array.length - x - 1);
            }
      }

     private static int findMax(Comparable[] array, int upper) 
     {
      int maxPos = 0;
      for (int a = 1; a < upper; a++) {
            if (array[a].compareTo(array[maxPos]) >= 0)
            maxPos = a;
      }

      return maxPos;
     }

     public static void swap(Comparable[] array, int a, int b) 
     {
            Comparable t = array[a];
            array[a] = array[b];

            array[b] = t;
     }


    }


    class Searches {
        public static int linearCount = 0;
        private static int binaryCount = 0;
        public static int linearCount() 
        {
            return linearCount;
        }

        public static int linear(Comparable[] array, Comparable target) {
         int postemp;
         for (int i = 0; i < array.length; i++) 
         {
               linearCount++;
               if (array[i].compareTo(target) == 0) 
               {
                   return i;
               }
         }
         return -1;
        }
        public static int binaryCount() {

            return binaryCount;
        }

        public static int binary(Comparable[] array, Comparable target) {
           return binaryhelper(array, target, 0, array.length - 1);
        }

        private static int binaryhelper(Comparable[] array, Comparable target, int start, int end) {
         int mid = (start + end) / 2;
         if (end < start) 
         {
              return -1;
         }

         if (array[mid].compareTo(target) < 0) 
         {
               binaryCount++;
               return binaryhelper(array, target, mid + 1, end);
         } 
         else if (array[mid].compareTo(target) > 0) {
               binaryCount++;
               return binaryhelper(array, target, start, mid - 1);
         } 
         else {
               binaryCount++;
               return mid;
         }
    }
}