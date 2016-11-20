import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class AdditionPanel extends JPanel
{
     public int num1 = 0;
     public int num2 = 0;
     public int answer = num1 + num2;
     private JLabel number1, number2;
     private JLabel answerCheck;
     private JTextField studentAnswer;
     private JRadioButton easy, medium, hard;
     private JButton newProb, checkAns;
     
     //----------------------------------------------------
     // Constructor: setting up the GUI for the math game.
     //----------------------------------------------------
     public AdditionPanel ()
     {
         number1 = new JLabel ("First Number: " + num1);
         number2 = new JLabel ("Second Number: " + num2);
         studentAnswer = new JTextField ("    ");
         
         
         //---------------------------
         
         // Student answer text field
         //---------------------------
         
       
         
         //----------------------------------------
         // Difficulty choice using radio buttons
         //----------------------------------------
         easy = new JRadioButton ("(1) Easy", true);
         medium = new JRadioButton ("(2) Medium");
         hard = new JRadioButton ("(3) Hard");
         ButtonGroup group = new ButtonGroup();
         group.add(easy);
         group.add(medium);
         group.add(hard);
         
         newProb = new JButton ("Display a New Problem");
         checkAns = new JButton ("Check the Answer");
         

     
         //-----------------------------------------------------------
         // Add section for all buttons, labels, and other components
         //-----------------------------------------------------------
         add(number1);
         add(number2);
         add(studentAnswer);
         add(easy);
         add(medium);
         add(hard);
         
         setBackground(Color.cyan);
         setPreferredSize(new Dimension(1000, 1000));
     }
     
     //****************************************************************
     // Listener for the radio buttons to chose the difficulty.
     //****************************************************************
}