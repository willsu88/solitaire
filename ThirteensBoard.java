import java.util.List;
import java.util.ArrayList;

/*
Hi, welcome to William's Thirteens solitaire game.
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



/**
 * The ThirteensBoard class represents the board in a game of Thirteens.
 */
public class ThirteensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 10;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

	
	/**
	 * Creates a new <code>ThirteensBoard</code> instance.
	 */
	 public ThirteensBoard() {
		super(ThirteensBoard.BOARD_SIZE, ThirteensBoard.RANKS, ThirteensBoard.SUITS, ThirteensBoard.POINT_VALUES);
	 	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 13, and (2) a single King card
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if (selectedCards.size() == 2) {
			return containsPairSum13(selectedCards);
		} else if (selectedCards.size() == 1) {
			return containsK(selectedCards);
		} else {
			return false;
		}
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 13, or (2) a single king card.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		List<Integer> cIndexes = cardIndexes();
		return containsPairSum13(cIndexes) || containsK(cIndexes);
	}

	/**
	 * Check for an 13-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 13-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 13-pair; false otherwise.
	 */
	private boolean containsPairSum13(List<Integer> selectedCards) {
		for (int sk1 = 0; sk1 < selectedCards.size(); sk1++) {
			int k1 = selectedCards.get(sk1).intValue();
			for (int sk2 = sk1 + 1; sk2 < selectedCards.size(); sk2++) {
				int k2 = selectedCards.get(sk2).intValue();
				if (cardAt(k1).getValue() + cardAt(k2).getValue() == 13) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check for a King in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a King group.
	 * @return true if the board entries in selectedCards
	 *              include a king; false otherwise.
	 */
	private boolean containsK(List<Integer> selectedCards) {
		boolean foundKing = false;
		for (Integer kObj : selectedCards) {
			int k = kObj.intValue();
			if (cardAt(k).getRank().equals("king")) {
				foundKing = true;
			} 
		}
		return foundKing;
	}
}
