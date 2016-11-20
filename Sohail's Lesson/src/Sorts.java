   import java.util.*;
   import java.io.*;
   public class Sorts
   {
      public static void main(String[] args) throws Exception
      {
        //Part 1, for doubles
         int n = (int)(Math.random()*100);
         double[] array = new double[n];
         for(int k = 0; k < array.length; k++)
            array[k] = Math.random();	
         print(array);
         System.out.println("*************  *************");
         Selection.sort(array);
         Insertion.sort(array);
         print(array);
         	//Part 2, for Strings
         int size = 100;
         Scanner sc = new Scanner(new File("declaration.txt"));
         String[] arrayStr = new String[size];
         for(int k = 0; k < arrayStr.length; k++)
            arrayStr[k] = sc.next();	
         print(arrayStr);
         System.out.println("*************  *************");
         Selection.sort(arrayStr);
         Insertion.sort(arrayStr);
         print(arrayStr);
      }
      public static void print(double[] a)
      {
         // for(int k = 0; k < a.length; k++)
            // System.out.println(a[k]);
         for(double d : a)
            System.out.println(d);
         System.out.println();
      }
      public static void print(Object[] papaya)
      {
         for(Object abc : papaya)     //for-each
            System.out.println(abc);
      }
   }
   //*******************************************************************

   class Selection
   {
      public static void sort(double[] array)
      { 
         int maxPos;
         for(int k = 0; k < array.length; k++)
         {
            maxPos = findMax(array, array.length - k - 1);
            swap(array, maxPos, array.length - k - 1);
         }
      }
      private static int findMax(double[] array, int n)
      {
         int maxIndex = 0;
         for(int x = n; x >= 0; x--)
         {
            if(array[x] > array[maxIndex])
            {
               maxIndex = x;
            }
         }
         return maxIndex;
      }
      private static void swap(double[] array, int a, int b)
      {
         double temp = array[b];
         array[b] = array[a];
         array[a] = temp;
      }

      public static void sort(String[] array)
      {
         int maxPos;
         for(int k = 0; k < array.length; k++)
         {
            maxPos = findMax(array, array.length - k - 1);
            swap(array, maxPos, array.length - k - 1);
         }
      }
      public static int findMax(String[] array, int upper)
      {
         int maxIndex = 0;
         for(int x = upper; x >= 0; x--)
         {
            if(array[x].compareTo(array[maxIndex]) == 1)
            {
               maxIndex = x;
            }
         }
         return maxIndex;
      }
      public static void swap(String[] array, int a, int b)
      {
         String temp = array[b];
         array[b] = array[a];
         array[a] = temp;
      }

      public static void sort(Comparable[] array)
      {
         int maxPos;
         for(int k = 0; k < array.length; k++)
         {
            maxPos = findMax(array, array.length - k - 1);
            swap(array, maxPos, array.length - k - 1);
         }
      }
      public static int findMax(Comparable[] array, int upper)
      {
         int maxIndex = 0;
         for(int x = upper; x >= 0; x--)
         {
            if(array[x].compareTo(array[maxIndex]) == 1)
            {
               maxIndex = x;
            }
         }
         return maxIndex;
      }
      public static void swap(Object[] array, int a, int b)
      {
         Object temp = array[b];
         array[b] = array[a];
         array[a] = temp;
      }
   }   


   class Insertion
   {
      public static void sort(double[] array)
      { 
         for(int i = 1; i < array.length; i++)
         {
            shift(array, i, array[i]);
         }
      }
      private static void shift(double[] array, int index, double value)
      {
         for(int i = index - 1; i >=0; i--)
         {
            if(array[i]>value)
            {
               array[i+1]=array[i];
               if(i==0)
                  array[i]=value;
            }
            else
            {
               array[i+1]=value;
               return;
            }
         }
      
      }

      public static void sort(Comparable[] array)
      { 
         for(int i = 1; i < array.length; i++)
         {
            shift(array, i, array[i]);
         }
      }
      private static void shift(Comparable[] array, int index, Comparable value)
      {
         for(int i = index - 1; i >=0; i--)
         {
            if(array[i].compareTo(value) > 0)
            {
               array[i+1]=array[i];
               if(i==0)
                  array[i]=value;
            }
            else
            {
               array[i+1]=value;
               return;
            }
         }
      
      }	
   }
