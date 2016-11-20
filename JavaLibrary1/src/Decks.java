/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Decks {

    /* this is used to keep track of original n*52 cards */
    private List<Card> resetDecks;   
    
    /* this starts by copying all cards from resetDecks    */
    /* it holds remaining cards in played decks            */
    private List<Card> playedDecks;
    static String[][] image = new String[13][4];
    
   
            
    private int numberDecks;


    /**
     * Constructor: Creates default one deck of 52 playing cards in resetDecks and
     * 		    copy them to playedDecks.
     *              initialize numberDecks=n
     * Note: You need to catch PlayingCardException from Card constructor
     *	     Use ArrayList for both resetDecks & playedDecks
     */
    public Decks()            
    {
       
        resetDecks = new ArrayList(52);
        for (int i=1; i<=13; i++){
        for (int j =1; j<=4; j++){
            try{
             resetDecks.add(new Card(i,j));
             
            
            }catch(PlayingCardException e){
                System.out.println("oh Java...");
        }
    }
        }
        playedDecks = new ArrayList(52);
        playedDecks.addAll(resetDecks);
        for(int i = 0; i<playedDecks.size();i++){
            int tempI = playedDecks.get(i).getRank()-1;
            int tempJ = playedDecks.get(i).getSuit()-1;
            image[tempI][tempJ]= playedDecks.get(i).toFileName();
            
        }
       
    }


    /**
     * Constructor: Creates n decks (52 cards each deck) of playing cards in
     *              resetDecks and copy them to playedDecks.
     *              initialize numberDecks=n
     * Note: You need to catch PlayingCardException from Card constructor
     *	     Use ArrayList for both resetDecks & playedDecks
     */
    public Decks(int n)
    {
        
        numberDecks = n;
        int arrayCapacity = n *52;
         resetDecks = new ArrayList(arrayCapacity);
        playedDecks = new ArrayList(arrayCapacity);
        for (int k=0; k<n;k++){
        for ( int i=1;i<=13;i++){
            for(int j=1;j<=4;j++){
                try{
                resetDecks.add (new Card(i,j));
                }catch(PlayingCardException e){
                        System.out.println("ERROR");
                        }
                }
        }
        }
       
        playedDecks.addAll(resetDecks);
        }
    

    /**
     * Task: Shuffles cards in playedDecks.
     * Hint: Look at java.util.Collections
     */
    public void shuffle()
    {
        Collections.shuffle(playedDecks);
    }

    private void sort(){
        Collections.sort(playedDecks, new CompareCard());
    }

    /**
     * Task: Deals cards from the playedDeck.
     *
     * @param numberCards number of cards to deal
     * @return a list containing cards that were dealt
     * @throw PlayingCardException if numberCard > number of remaining cards
     *
     * Note: You need to create ArrayList to stored dealt cards
     *       and should removed dealt cards from playedDecks
     *
     */
    public List<Card> deal(int numberCards) throws PlayingCardException
    {
        
        List<Card> dealtCards = new ArrayList(numberCards);
        if (numberCards>playedDecks.size()){
            throw new PlayingCardException();
        }
        for (int i=0;i<numberCards;i++){
        dealtCards.add(playedDecks.get(0));
        playedDecks.remove(0);
    }
        
        
        return dealtCards;
    }


    /**
     * Task: Resets playedDeck by copying all cards from the resetDeck.
     */
    public void reset()
    {
        this.playedDecks.clear();
        playedDecks.addAll(resetDecks);
        
        

    }


    /**
     * Task: Return number of remaining cards in the playedDeck.
     */
    public int remain()
    {
	return playedDecks.size();
    }

    /**
     * Task: Returns a string representing cards in the playedDeck 
     */
    public String toString()
    {
	return ""+playedDecks;
    }


    /* Quick test                   */
    /*                              */
    /* Do not modify these tests    */
    /* Generate 2 decks of cards    */
    /* Loop 2 times:                */
    /*   Deal 30 cards for 4 times  */
    /*   Expect exception last time */
    /*   reset()                    */

    public static void main(String args[]) throws PlayingCardException {
        
        Decks newDeck = new Decks();
        for (int i =0; i<13; i++){
            for( int j = 0; j<4;j++){
                System.out.println(image[i][j]);
            }
        }
        

    }
      
}