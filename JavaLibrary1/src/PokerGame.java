import java.util.*;

/*
 * Ref: http://en.wikipedia.org/wiki/Video_poker
 *
 * Short Description and Poker rules:
 *
 * Video poker is also known as draw poker. 
 * The dealer uses a 52-card deck, which is played fresh after each playerHand. 
 * The player is dealt one five-card poker playerHand. 
 * After the first draw, which is automatic, you may hold any of the cards and draw 
 * again to replace the cards that you haven't chosen to hold. 
 * Your cards are compared to a table of winning combinations. 
 * The object is to get the best possible combination so that you earn the highest 
 * payout on the bet you placed. 
 *
 * Winning Combinations
 *  
 * 1. Jacks or Better: a pair pays out only if the cards in the pair are Jacks, 
 * 	Queens, Kings, or Aces. Lower pairs do not pay out. 
 * 2. Two Pair: two sets of pairs of the same card denomination. 
 * 3. Three of a Kind: three cards of the same denomination. 
 * 4. Straight: five consecutive denomination cards of different suit. 
 * 5. Flush: five non-consecutive denomination cards of the same suit. 
 * 6. Full House: a set of three cards of the same denomination plus 
 * 	a set of two cards of the same denomination. 
 * 7. Four of a kind: four cards of the same denomination. 
 * 8. Straight Flush: five consecutive denomination cards of the same suit. 
 * 9. Royal Flush: five consecutive denomination cards of the same suit, 
 * 	starting from 10 and ending with an ace
 *
 */


/* This is the main poker game class.
 * It uses Decks and Card objects to implement poker game.
 * Please do not modify any data fields or defined methods
 * You may add new data fields and methods
 * Note: You must implement defined methods
 */


public class PokerGame {

    // default constant values
    private static final int startingBalance=100;
    private static final int numberOfCards=5;

    // default constant payout value and playerHand types
    private static final int[] multipliers={1,2,3,5,6,9,25,50,250};
    private static final String[] goodHandTypes={ 
	  "Royal Pair" , "Two Pairs" , "Three of a Kind", "Straight", "Flush", 
	  "Full House", "Four of a Kind", "Straight Flush", "Royal Flush" };

    // must use only one deck
  
    private static final Decks oneDeck = new Decks(1);

    
    

    // holding current poker 5-card hand, balance, bet    
    public List<Card> playerHand;
    private int playerBalance;
    private int playerBet;
    
    

    /** default constructor, set balance = startingBalance */
    public PokerGame()
    {
	this(startingBalance);
    }

    /** constructor, set given balance
     * @param balance */
    public PokerGame(int balance)
    {
	this.playerBalance= balance;
    }

    /** This display the payout table based on multipliers and goodHandTypes arrays */
    private void showPayoutTable()
    { 
	System.out.println("\n\n");
	System.out.println("Payout Table   	      Multiplier   ");
	System.out.println("=======================================");
	int size = multipliers.length;
	for (int i=size-1; i >= 0; i--) {
		System.out.println(goodHandTypes[i]+"\t|\t"+multipliers[i]);
	}
	System.out.println("\n\n");
    }

    private void getBet(){
        Scanner input = new Scanner(System.in);
		boolean valid = false;
		while(!valid){
			System.out.print("Enter bet=>");
                        playerBet = input.nextInt();
			if(playerBet > playerBalance){
				System.out.println("insufficient funds!");
				playerBet = 0;
			}
			else
				valid = true;
		}
		playerBalance -= playerBet;
	}
    
    private void  hold(){
        
    }
    private void cardsToKeep(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Position of Cards You Would like to Keep: ");
        String inputString = input.nextLine();
        List<Card> newHand = new ArrayList<>();
        if (!inputString.equals("")){
			String[] pos = inputString.split(" ");
			
			
			for(int i=0; i<pos.length; i++){
				if(Integer.parseInt(pos[i])<= numberOfCards){
					newHand.add(playerHand.get(Integer.parseInt(pos[i])-1));
				}
			}
		}
        playerHand = newHand;
        List<Card> deal = new ArrayList<>();
        try {
            deal = oneDeck.deal(numberOfCards-playerHand.size());
        }catch(PlayingCardException e){
            System.out.println(e.getMessage());
        }
        for (int i=0; i<deal.size();i++){
            playerHand.add(deal.get(i));
        }
    }

    private void payout(int value){
        if(value < 9){
            playerBalance += (playerBet*multipliers[value]);
        }
    }
        private boolean continuePlaying(){
            System.out.println("Would You Like To Play Again? (Y / N)");
            Scanner input = new Scanner(System.in);
            if(input.next().equals("Y")){
                return true;
            } else {
                return false;
            }
            
        }
    private void showBalance(){
    if (playerBalance <=20){
    System.out.print("Game Over");
    } else {
        System.out.println("Current Balance: "+playerBalance+" coins");
    }
}
    /** Check current playerHand using multipliers and goodHandTypes arrays
     *  Must print yourHandType (default is "Sorry, you lost") at the end of function.
     *  This can 
     * e checked by testCheckHands() and main() method.
     */
    private void checkHands()
    {
     
        
        Collections.sort(playerHand,new CompareCard());
       
        int value=-1;

    
       //Special Straight Case
     
        
        if(hasJacksOrBetter(playerHand)){
            value = 0;
        }
        
       if(hasTwoPair(playerHand)){
           value = 1;
       }
        
       if(hasThreeOfAKind(playerHand)){
           value =2;
       }
       
       if(hasStraight(playerHand) || hasRoyalStraight(playerHand)){
           value = 3;
           
       }
       if(hasFlush(playerHand)){
           value = 4;
       }
       if (hasFullHouse(playerHand)){
           value = 5;
       }
       if(hasFourOfAKind(playerHand)){
           value = 6;
       }
       
       if(hasStraight(playerHand)&& hasFlush(playerHand)){
        
           value = 7;
       }
       if(hasRoyalStraight(playerHand) && hasFlush(playerHand)){
           value=8;
       }
     
      
       switch(value){
           case 8:
               System.out.println(goodHandTypes[8]);
               payout(8);
               break;
           case 7:
               System.out.println(goodHandTypes[7]);
               payout(7);
               break;
           case 6:
               System.out.println(goodHandTypes[6]);
               payout(6);
               break;
           case 5:
               System.out.println(goodHandTypes[5]);
               payout(5);
               break;
           case 4:
               System.out.println(goodHandTypes[4]);
               payout(4);
               break;
               
           case 3:
               System.out.println(goodHandTypes[3]);
               payout(3);
               break;
          case 2:
               System.out.println(goodHandTypes[2]);
               payout(2);
               break;
           case 1:
               System.out.println(goodHandTypes[1]);
               payout(1);
               break;
           case 0:
               System.out.println(goodHandTypes[0]);
               payout(0);
               break;
           default:
               System.out.println("Sorry, you lost.");
               break;
               
       }
        

       
          
        

    
    }
    
private boolean hasFourOfAKind(List<Card> handPar){
    boolean fourOfAKind = false;
   /* int matches = 0;
    for(int i = 1; i<handPar.size();i++){
        if(handPar.get(0).getRank()==handPar.get(i).getRank()){
            matches++;
        }
    }
    if(matches==3 || (matches==0 &&hasThreeOfAKind(handPar))){
        fourOfAKind=true;
    } */
    if((handPar.get(0).getRank()==handPar.get(1).getRank() &&handPar.get(1).getRank()==handPar.get(2).getRank() && handPar.get(3).getRank()==handPar.get(2).getRank())||
            (handPar.get(1).getRank()==handPar.get(2).getRank() &&handPar.get(2).getRank()==handPar.get(3).getRank() && handPar.get(3).getRank()==handPar.get(4).getRank())){
        fourOfAKind=true;
        
    }
    
    
    return fourOfAKind;
    
    
    
}

private boolean hasFlush(List<Card> handPar){
   boolean flush = true;
    for(int i=1;i<handPar.size();i++){
            if(handPar.get(0).getSuit()!=handPar.get(i).getSuit()){
                flush = false;
            } 
       }
    return flush;
    
    
    }

private boolean hasStraight(List<Card> handPar){
    boolean straight = true;
     for (int i=1;i<handPar.size();i++){
           if(handPar.get(i-1).getRank()-1!=handPar.get(i).getRank()){
               straight = false;
           }
       }
     return straight;
}
 
private boolean hasRoyalStraight(List<Card> handPar){
    boolean royalStraight = false;
    if(handPar.get(0).getRank()==13 && handPar.get(1).getRank()==12 && handPar.get(2).getRank()==11&& handPar.get(3).getRank()==10&&handPar.get(4).getRank()==1){
           royalStraight = true;
       }
    return royalStraight;
}

private boolean hasJacksOrBetter(List<Card> handPar){
    boolean jacksOrBetter = false;
    for (int i =0; i<handPar.size()-1;i++){
        if(handPar.get(i).getRank()>=11 && (handPar.get(i+1).getRank()==handPar.get(i).getRank())){
            jacksOrBetter = true;
            break;
        }
    }
    return jacksOrBetter;
}

private boolean hasTwoPair(List<Card> handPar){
    boolean twoOfAKind= false;
    if(handPar.get(0).getRank()==handPar.get(1).getRank() && handPar.get(2).getRank()==handPar.get(3).getRank()){
        twoOfAKind=true;
    } else if(handPar.get(1).getRank()==handPar.get(2).getRank() && handPar.get(3).getRank()==handPar.get(4).getRank()){
        twoOfAKind=true;
    } else if(handPar.get(0).getRank()==handPar.get(1).getRank() && handPar.get(3).getRank()==handPar.get(4).getRank()){
        twoOfAKind=true;
    }
    
    return twoOfAKind;
}

private boolean hasThreeOfAKind(List<Card> handPar){
    boolean threeOfAKind = false;
    // the hand is previously ordered
     if(handPar.get(0).getRank()==handPar.get(1).getRank() && handPar.get(1).getRank()==handPar.get(2).getRank()){ // front of Hand
        threeOfAKind=true;
    } else if(handPar.get(1).getRank()==handPar.get(2).getRank() && handPar.get(2).getRank()==handPar.get(3).getRank()){ //Middle of Hand
        threeOfAKind=true;
    } else if(handPar.get(2).getRank()==handPar.get(3).getRank() && handPar.get(3).getRank()==handPar.get(4).getRank()){ //End of Hand
        threeOfAKind=true;
    }
    return threeOfAKind;
    
    
}


private boolean hasFullHouse(List<Card> handPar){
    boolean fullHouse = true;
    if(hasThreeOfAKind(handPar) != true || handPar.get(0).getRank()!=handPar.get(1).getRank() || handPar.get(3).getRank()!=handPar.get(4).getRank()){
        fullHouse= false;
  }
    return false;
}

public void setImages(){
    for(int i = 0; i<playerHand.size();i++){
    String currentCardPath = playerHand.get(i).toFileName();
    }
}

    public void play() 
    {
    /** The main algorithm for single player poker game 
     *
     * Steps:
     * 		showPayoutTable()
     *
     * 		++	
     * 		show balance, get bet 
     *		verify bet value, update balance
     *		reset deck, shuffle deck, 
     *		deal cards and display cards
     *		ask for positions of cards to keep  
     *          get positions in one input line
     *		update cards
     *		check hands, display proper messages
     *		update balance if there is a payout
     *		if balance = O:
     *			end of program 
     *		else
     *			ask if the player wants to play a new game
     *			if the answer is "no" : end of program
     *			else : showPayoutTable() if user wants to see it
     *			goto ++
     */
boolean proceed = true;
boolean displayPayout = true;

while(proceed){
        if(displayPayout){
            showPayoutTable();
        }
showBalance();
getBet();
oneDeck.reset();
oneDeck.shuffle();
try{
    playerHand = new ArrayList<>(oneDeck.deal(numberOfCards));
    
} catch(PlayingCardException e){
    System.out.println("Der be errerz in der codez and stuff");
    continue;
}


//System.out.println(playerHand);
cardsToKeep();
//System.out.println(playerHand);
checkHands();
showBalance();

if(playerBalance<=0){
    proceed = false;
            break;
}
if(!continuePlaying()){
    proceed = false;
}
}
    }
    /*************************************************
     *   Do not modify methods below
    /*************************************************


    /** testCheckHands() is used to test checkHands() method 
     *  checkHands() should print your current hand type
     */ 

    private void testCheckHands()
    {
      	try {
    		playerHand = new ArrayList<>();

		// set Royal Flush
		playerHand.add(new Card(1,4));
		playerHand.add(new Card(10,4));
		playerHand.add(new Card(12,4));
		playerHand.add(new Card(11,4));
		playerHand.add(new Card(13,4));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// set Straight Flush
		playerHand.set(0,new Card(9,4));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// set Straight
		playerHand.set(4, new Card(8,2));   
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// set Flush 
		playerHand.set(4, new Card(5,4));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// "Royal Pair" , "Two Pairs" , "Three of a Kind", "Straight", "Flush	", 
	 	// "Full House", "Four of a Kind", "Straight Flush", "Royal Flush" };

		// set Four of a Kind
		playerHand.clear();
		playerHand.add(new Card(8,4));
		playerHand.add(new Card(8,1));
		playerHand.add(new Card(12,4));
		playerHand.add(new Card(8,2));
		playerHand.add(new Card(8,3));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// set Three of a Kind
		playerHand.set(4, new Card(11,4));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// set Full House
		playerHand.set(2, new Card(11,2));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// set Two Pairs
		playerHand.set(1, new Card(9,2));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// set Royal Pair
		playerHand.set(0, new Card(11,2));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// non Royal Pair
		playerHand.set(3, new Card(5,4));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");
      	}
      	catch (Exception e)
      	{
		System.out.println(e.getMessage());
      	}
    }


    /* Run testCheckHands() */
    public static void main(String args[]) throws PlayingCardException
    {
	PokerGame pokergame = new PokerGame(100000);
	pokergame.play();
    }
}