   import java.util.Scanner;
   import java.io.*;
   public class AreaFill
   {
      public static char[][] grid = null;
      private static Scanner sc; 
      private static String filename;
      private static int row, col;  
      private static char symbol; 
      public static void main(String[] args) throws FileNotFoundException
      {
         while(true)
         {
            sc = new Scanner(System.in);
            System.out.print("Filename: ");
            filename = sc.next();
            if(filename.equals("-1"))
            {
               System.out.println("Good-bye!"); 
               System.exit(0); 
            }
            grid = read(filename);
            display(grid);
            System.out.print("\nEnter ROW COL to fill from: ");
            row = sc.nextInt();
            col = sc.nextInt(); 
            fill(grid, row, col, grid[row][col]);
            display(grid);
         }
      }
      public static char[][] read(String filename)throws FileNotFoundException
      {
         Scanner infile = null; 
         while(infile == null)
         {
            try
            {
               infile = new Scanner(new File(filename)); 
            }
               catch(FileNotFoundException e)
               {
                  System.out.println("File not found. Please try again."); 
                  System.out.print("Filename: ");
                  filename = sc.next();
                  if(filename.equals("-1"))
                  {
                     System.out.println("Good-bye!"); 
                     System.exit(0); 
                  }
               }
         } 
         int row = Integer.parseInt(infile.next());
         int column = Integer.parseInt(infile.next()); 
         char[][] array = new char[row][column]; 
         for(int r = 0; r < row; r++)
         {
            String nextline = infile.next(); 
            for(int c = 0; c < column; c++)
               array[r][c] = nextline.charAt(c); 
         }
         infile.close();
      	   
         return array; 
      }
      
      public static void display(char[][] g)
      {
         for(int i = 0; i < g.length; i++)
         {
            for(int k = 0; k < g[0].length; k++)
            {System.out.print(" " + g[i][k]); }
         	  
            System.out.println(); 
         }            
      }
      public static void fill(char[][] g, int r, int c, char ch) //recursive method
      {
      
         if(g[r][c] == ch)
            g[r][c] = '*'; 
      		
         if(r > 0 && g[r-1][c] == ch)
            fill(g, (r-1), c, ch);
        
         if(r < (g.length-1) && g[r+1][c] == ch)
            fill(g, (r + 1), c, ch); 
       
         if(c > 0 && g[r][c-1] == ch)
            fill(g, r, (c-1), ch); 
         
         if(c < (g[0].length-1) && g[r][c+1] == ch)
            fill(g, r, (c+1), ch); 
      
       
      }
   }