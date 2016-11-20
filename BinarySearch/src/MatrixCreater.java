



public class MatrixCreater {
    //Takes in the size of all three Matrices, A,B,C and initializes them.
    //After initializing the Matrices, it runs the 2 versions taking there times
    //to execute.
    public void MatrixInitializer(int n)
    {
      int A[][] = new int[n][n]; // initializing All three matrices
      int B[][] = new int[n][n];
      int C[][] = new int[n][n];
      for (int i = 0; i < n; i++)
          for ( int j = 0; j < n; j++) // Giving values to each element of the 
          {                            //matrices A and B
              A[i][j] = 1;
              B[i][j] = 1;
            
              
         
               
          }
      //this is Version 1 Row Major
     long startTime = System.currentTimeMillis(); // starting the timer
      for(int i = 0; i < n; i++)
          for(int j = 0; j < n; j++)
              C[i][j] = A[i][j] + B[i][j];
     long endTime = System.currentTimeMillis();// stopping the timer
     long TimeElapsed = endTime - startTime;
     System.out.println("The time for Version 1 for a " + n + " x " + n + " matrix is: " + TimeElapsed + " miliseconds");
            
      //This is Version 2 Column Major
       startTime = System.currentTimeMillis(); // starting the timer
       for(int j = 0; j < n; j++)
          for(int i = 0; i < n; i++)
              C[i][j] = A[i][j] + B[i][j];
       endTime = System.currentTimeMillis(); // stopping the timer
       TimeElapsed =endTime - startTime;
       System.out.println("The time for Version 2 for a " + n + " x " + n + " matrix is: " + TimeElapsed + " miliseconds");
       System.out.println("");
      
    }



}  
