
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class MonsterAttackDriver {
	public static void main(String[] args) throws IOException {
            // Create new instance of AttackMonitor
    		AttackMonitor getDestroyed = new AttackMonitor();
                // using the instance getDestroyed we created, we call the monitor() method, which is basically our controller and has all of our cases.
		getDestroyed.monitor();
	}
}