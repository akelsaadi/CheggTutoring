public class MonsterAttack {
//Declaring Variables Here
        private int attackId;
	private int attackDay;
	private int attackMonth;
	private int attackYear;
	private int attackVictims;
	private String monsterName;
	private String attackLocation;
	private String fullDate;
        
// This is the constructor that sets all the isntance fields 
	public MonsterAttack(String fullDateIn, int attackIdIn, int attackVictimsIn, String monsterNameIn,
			String attackLocationIn) {

		attackId = attackIdIn;
		attackVictims = attackVictimsIn;
		monsterName = monsterNameIn;
		attackLocation = attackLocationIn;
		fullDate = fullDateIn;
	}
//Getters and setters below 
	public String getFullDate() {
		return fullDate;
	}

	public void setFullDate(String fullDate) {
		this.fullDate = fullDate;
	}

	public int getAttackId() {
		return attackId;
	}

	public void setAttackId(int attackId) {
		this.attackId = attackId;
	}

	public int getAttackDay() {
		return attackDay;
	}

	public void setAttackDay(int attackDay) {
		this.attackDay = attackDay;
	}

	public int getAttackMonth() {
		return attackMonth;
	}

	public void setAttackMonth(int attackMonth) {
		this.attackMonth = attackMonth;
	}

	public int getAttackYear() {
		return attackYear;
	}

	public void setAttackYear(int attackYear) {
		this.attackYear = attackYear;
	}

	public int getAttackVictims() {
		return attackVictims;
	}

	public void setAttackVictims(int attackVictims) {
		this.attackVictims = attackVictims;
	}

	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	public String getAttackLocation() {
		return attackLocation;
	}

	public void setAttackLocation(String attackLocation) {
		this.attackLocation = attackLocation;
	}
// Here we are parsing the Date, that way when it's entered with the slashes, it will be stored without them
	public void fullDateSplitter(String fullDate) {

		String[] afterSplit = fullDate.split("/");

		attackDay = Integer.parseInt(afterSplit[0]);
		attackMonth = Integer.parseInt(afterSplit[1]);
		attackYear = Integer.parseInt(afterSplit[2]);

	}

// Here is the toString, the toString is used to print out.
	public String toString() {

		fullDateSplitter(fullDate);

		return "Attack # " + attackId + " occured on " + attackDay + "/" + attackMonth + "/" + attackYear + ". "
				+ monsterName + " attacked " + attackLocation + ", resulting in " + attackVictims
				+ " tragic fatalities." + "\n";

	}
}