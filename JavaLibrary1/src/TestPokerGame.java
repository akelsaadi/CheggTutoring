public class TestPokerGame {

    public static void main(String args[]) 
    {
	PokerGame pokergame;
	if (args.length > 0)
		pokergame = new PokerGame(Integer.parseInt(args[0]));
	else
		pokergame = new PokerGame();
	pokergame.play();
    }
}