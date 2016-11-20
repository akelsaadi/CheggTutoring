import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AttackMonitor {
//Monster attack is now an Array list
	private List<MonsterAttack> monsterAttacks = new ArrayList<MonsterAttack>();

	public void monitor() throws IOException {
// Here we create our options.
		String[] options = { "Quit", "Input a New Monster Attack", "Show List of Attacks", "Delete an Attack", "Save to File", "Read From File" };

		int selection;
// a do while loop to wait for the user to pick an option
		do {

			selection = JOptionPane.showOptionDialog(null, "What would you like to do?", "Main Menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

			switch (selection) {
// If he picks input a new monster, we call addmonster method
			case 1:
				addMonsterAttack();
				break;
// If monster is not empty we call showmonsterattacks method, if it is empty we output error message
			case 2:
				if (!(monsterAttacks.isEmpty()))
					showMonsterAttacks();
				else if (monsterAttacks.isEmpty())
					JOptionPane.showMessageDialog(null, "There are no Monster Attacks.");
				break;
// Same thing here, if it's not empty, we call deletemonsterattack, if it's empty we output message saying noth to delete                           
			case 3:
				if (!(monsterAttacks.isEmpty()))
					deleteMonsterAttack();
				else if (monsterAttacks.isEmpty())
					JOptionPane.showMessageDialog(null, "There is nothing to delete.");
				break;
// calling save to file                            
                        case 4:
                                saveToFile();
                                break;
// calling writeToFile method                        
                        case 5:
                                readFromFile();
                                break;
			}

		} while (selection != 0);
	}
//
	private void addMonsterAttack() {
                // We output message to enter the attack id, then we parse it to make it an Int
		int attackIdIn = Integer.parseInt(JOptionPane.showInputDialog("Please Enter the Attack ID #: "));
                //same thing here, except no parsing is needed as it's a string
		String monsterNameIn = JOptionPane.showInputDialog("Please Enter the Monster Name: ");

		String fullDateIn = JOptionPane.showInputDialog("Please Enter the Date the attack occured on (MM/DD/YYYY): ");

		int attackVictimsIn = Integer.parseInt(JOptionPane.showInputDialog("How many fatalities were there? "));

		String attackLocationIn = JOptionPane.showInputDialog("Where did this happen? ");
                // we now add the mosnter to the arraylist monsterattacks that we created above 
		monsterAttacks.add(new MonsterAttack(fullDateIn, attackIdIn, attackVictimsIn, monsterNameIn, attackLocationIn));

	}
//This is where we display our attacks
	private void showMonsterAttacks() {

		String wholeList = "";
// small for loop to collect all the attacks and put them in one string.
		for (int i = 0; i < monsterAttacks.size(); i++)
			wholeList += monsterAttacks.get(i);
//when that's done we output that string in a dialog box
		JOptionPane.showMessageDialog(null, wholeList);

	}
// deleteMonsterAttack method is where we delete a certain attack from our arraylist
	private void deleteMonsterAttack() {
// we first give the user a chance to see what attacks exist, we do that by calling showMonsterAttacks
		showMonsterAttacks();
//Then prompt user to enter the attack ID of which attack he chooses to delete, Parse it to make it an int
		int choice = Integer.parseInt(
				JOptionPane.showInputDialog("Enter the ID # of the Monster attack you would like to delete: "));
//We now forloop around all our monsterAttacks arraylist to look for the certain ID the user entered
		for (int i = 0; i < monsterAttacks.size(); i++) {
                        // Here we match the ID that the user Entered with the ID that we have in our ArrayList monsterAttacks
                        // we find that ID by calling the getter for the Attack ID
			if (choice == monsterAttacks.get(i).getAttackId())
				monsterAttacks.remove(i);
                        // Once Found we remove it from our arrayList by calling .remove()

		}
	}
        
        private void saveToFile() throws IOException
        {
            //create a writer named out and name the file we write to as "Attack.txt", set it as UTF-8 just to be safe incase any random characters are there
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter (new FileOutputStream("Attacks.txt"), "UTF-8"));
            
            // we are looping through all of our monsterattacks list.
            for (int i = 0; i< monsterAttacks.size(); i++)
            {
               //We call the monsterAttacks getter to get the AttackID, call the Integer.toString() for us to be able to write to the text file
               out.write(Integer.toString(monsterAttacks.get(i).getAttackId())); 
               // add the comma to seperate each value, just like the instructions asks.
               out.write(",");
               //call the name getter, this is a string already, so there will be no need to convert it to one. 
               out.write(monsterAttacks.get(i).getMonsterName());
               out.write(",");
               //etc...
               out.write(monsterAttacks.get(i).getFullDate());
               out.write(",");
               out.write(Integer.toString(monsterAttacks.get(i).getAttackVictims()));
               out.write(",");
               out.write(monsterAttacks.get(i).getAttackLocation());
               out.newLine();
            }
           out.close(); 
        }
        private void readFromFile() throws FileNotFoundException, IOException
        {
            //Instructions ask to clear list of monster attacks when reading from file. calling clear() would do the trick here
            monsterAttacks.clear();
            //read the file "attacks.txt" using scanner
            String filen = (JOptionPane.showInputDialog("Enter File's name "));
            Scanner read = new Scanner(new File(filen));
            //this is a delimiter, it's used so we can split the text based on the commas that seperates them
            read.useDelimiter("[,\r\n]+");
            //create variables to use them to store everything we read from the file
            String fullDateIn = "";
            int attackIdIn = 0;
            int attackVictimsIn = 0;
            String monsterNameIn= "";
            String attackLocationIn= "";
            //While loop over the file until it does not have anything to read.
            while (read.hasNext())
            { 
               //we first start by attackID ( that's how it's written to file, in that specific format)
               //attackID is written to file as a string, now we have to make it an Int again so we parse it and call read.next. 
               attackIdIn = Integer.parseInt(read.next());
               //read what's after the comma, which is the monster's name.
               monsterNameIn = read.next();
               //etc...
               fullDateIn = read.next();
               attackVictimsIn = Integer.parseInt(read.next());
               attackLocationIn = read.next();
               //we now add everything we read to our Arraylist that we have, which is monsterAttacks. With everything being in our arrayList, we can list everything fine.
               monsterAttacks.add(new MonsterAttack(fullDateIn, attackIdIn, attackVictimsIn, monsterNameIn, attackLocationIn));

            }
            read.close();
        }
}