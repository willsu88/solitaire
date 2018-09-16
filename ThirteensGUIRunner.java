/*
 * This is a class that plays the GUI version of the Thirteens game.
 * See below for a description of how Thirteens is played.

Hi, welcome to William's Thirteens game.
To play this game, you have to know a few rules. 
Here they are:
	Rule 1: The initial board size is 10, which means that 10 cards are initially dealt on the board. 
	Rule 2: The number of cards will remain at 10, until there are no more undealt cards. Then it will start decreasing toward 0.
	Rule 3: To win, you must get rid of all the cards on the board. You have two ways:
		1. Find a pair of cards that add up to 13.
		2. Find a single King Card.
		When you replace all 52 cards, you win!
		
Above are the basic rules. The computer will handle the card shuffling and dealing.
Please enjoy!
If you ever feel like restarting a game, simply press restart. 

 */
public class ThirteensGUIRunner {

	/**
	 * Plays the GUI version of Thirteens.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		Board board = new ThirteensBoard();
		CardGameGUI gui = new CardGameGUI(board);
		gui.displayGame();
	}
}
