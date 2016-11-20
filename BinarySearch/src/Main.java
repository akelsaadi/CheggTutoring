public class Main {

    
    public static void main(String[] args) {
      MatrixCreater m = new MatrixCreater();// creating an object of type MatrixCreater
      m.MatrixInitializer(128); // Executing the computations
      m.MatrixInitializer(256);
      m.MatrixInitializer(512);
      m.MatrixInitializer(1024);
      m.MatrixInitializer(2048);
      m.MatrixInitializer(4096);
      m.MatrixInitializer(8192); 
     // m.MatrixInitializer(16384);
     // m.MatrixInitializer(32768);
      //m.MatrixInitializer(65536);

    }

}