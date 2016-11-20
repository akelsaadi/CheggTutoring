import javax.swing.JFrame;

public class MathGame
{
      //-----------------------------------------------
      //  Creates the main frame for the program.
      //-----------------------------------------------
    public static void main(String[] args)
    {
        JFrame frame= new JFrame("Addition Math Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        AdditionPanel panel = new AdditionPanel();
        frame.getContentPane().add(panel);
        
        frame.pack();
        frame.setVisible(true);
    }
}