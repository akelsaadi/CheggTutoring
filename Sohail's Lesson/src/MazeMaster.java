import java.util.*;
import java.io.*;
public class MazeMaster
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the maze's filename: ");
      char[][] retArr = buildCharArr(sc.next());
      Maze m = new Maze(retArr);
      m.display();
      System.out.println("Options: ");
      System.out.println("1: Mark all paths.");
      System.out.println("2: Mark all paths, and display the count of all steps.");
      System.out.println("3: Show only the correct path.");
      System.out.println("4: Show only the correct path. If no path exists, display 'No path exists'.");
      System.out.println("5: Show only the correct path, and display the count of steps.");
      System.out.print("Please make a selection: ");
      m.solve(sc.nextInt());
      m.display();  
   } 
   //take in a filename, and return a char[][]
   public static char[][] buildCharArr(String fileName)
   {
      if (!fileName.endsWith(".txt"))
         fileName += ".txt";
      try {
         Scanner infile = new Scanner(new File(fileName));
         char[][] ch = new char[infile.nextInt()][infile.nextInt()];
         infile.nextLine();
         for (int r = 0; r < ch.length; r++) {
            String s = infile.nextLine();
            for (int c = 0; c < ch[r].length; c++) {
               ch[r][c] = s.charAt(c);
            }
         }
         return ch;
      }
      catch (Exception e) {
         return null;
      }
   }
}


class Maze
{
   //Constants
   private final char WALL = 'W';
   private final char PATH = '.';
   private final char START = 'S';
   private final char EXIT = 'E';
   private final char STEP = '*';
   //fields
   private char[][] maze;
   private int startRow, startCol;
   private boolean S_Exists=false, E_Exists=false;
   //constructor initializes all the fields
   public Maze(char[][] inCharArr)    
   {
      maze = inCharArr;
      startRow = startCol = 0;
      for (int r = 0; r < maze.length; r++)
         for (int c = 0; c < maze[r].length; c++) {
            if (maze[r][c] == START) {
               S_Exists = true;
               startRow = r;
               startCol = c;
            }
            if (maze[r][c] == EXIT) {
               E_Exists = true;
            }
         }
            
   }
   
   public void display()
   {
      if(maze==null) 
         return;
      for(int a = 0; a<maze.length; a++)
      {
         for(int b = 0; b<maze[0].length; b++)
         {
            System.out.print(maze[a][b]);
         }
         System.out.println("");
      }
      System.out.println("");
   }
   public void solve(int n)
   {
      if(n==1)
      {
         markAllPaths(startRow, startCol);
      }
      else if(n==2)
      {
         int count = markAllPathsAndCountStars(startRow, startCol);
         System.out.println("Number of steps = " + count);
      }
      else if(n==3)
      {
         displayTheCorrectPath(startRow, startCol);
      }
      else if(n==4)   //use maze3 here
      {
         if( !displayTheCorrectPath(startRow, startCol) )
            System.out.println("No path exists");   
      }     
      else if(n==5)
      {
         displayCorrectPathAndCountStars(startRow, startCol, 0);
      }
      else System.out.println("invalid submission");
      
   }
   private void markAllPaths(int r, int c)
   {
      if (!S_Exists || !E_Exists)
         return;
      if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length) {
         if (maze[r][c] == PATH || maze[r][c] == START || maze[r][c] == EXIT) {
            maze[r][c] = STEP;
            markAllPaths(r-1, c);
            markAllPaths(r, c-1);
            markAllPaths(r+1, c);
            markAllPaths(r, c+1);
         }
      }
   }
        
   private int markAllPathsAndCountStars(int r, int c)
   {
      if (!S_Exists || !E_Exists)
         return 0;
      int x = 0;
      if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length) {
         if (maze[r][c] == PATH || maze[r][c] == START || maze[r][c] == EXIT) {
            maze[r][c] = STEP;
            x = 1;
            x += markAllPathsAndCountStars(r-1, c);
            x += markAllPathsAndCountStars(r, c-1);
            x += markAllPathsAndCountStars(r+1, c);
            x += markAllPathsAndCountStars(r, c+1);
         }
      }
      return x;
   }

   private boolean displayTheCorrectPath(int r, int c)
   {
      if (!S_Exists || !E_Exists)
         return false;
      if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length) {
         if (maze[r][c] == EXIT) {
            maze[r][c] = STEP;
            return true;
         }
         if (maze[r][c] == PATH || maze[r][c] == START) {
            maze[r][c] = STEP;
            if (displayTheCorrectPath(r-1, c) ||
                     displayTheCorrectPath(r, c-1) ||
                     displayTheCorrectPath(r+1, c) ||
                     displayTheCorrectPath(r, c+1)) {
               
               return true;
            }
            if (maze[r][c] == STEP)
               maze[r][c] = PATH;
         }
      }
      return false;
   }
   
   private boolean displayCorrectPathAndCountStars(int r, int c, int count)
   {
      if (!S_Exists || !E_Exists)
         return false;
      if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length) {
         if (maze[r][c] == EXIT) {
            maze[r][c] = STEP;
            count++;
            System.out.println(count);
            return true;
         }
         if (maze[r][c] == PATH || maze[r][c] == START) {
            maze[r][c] = STEP;
            count++;
            if (displayCorrectPathAndCountStars(r-1, c, count) ||
                     displayCorrectPathAndCountStars(r, c-1, count) ||
                     displayCorrectPathAndCountStars(r+1, c, count) ||
                     displayCorrectPathAndCountStars(r, c+1, count)) {
               
               return true;
            }
            if (maze[r][c] == STEP) {
               maze[r][c] = PATH;
               count--;
            }
         }
      }
      return false;
   }
   
   //This is for testing purposes. Do not change or remove this method.
   public char[][] getMaze()
   {
      return maze;
   }
}