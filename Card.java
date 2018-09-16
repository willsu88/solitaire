/*
Document:
	1. private String rank keeps track of the rank of the card
	2. private String suit keeps track of the suit of the card
	3. private int value keeps track of the pointValue for each card
	4. public Card (String cRank, String cSuit, int cValue) constructs the Card; has 3 parameters
	5. public String getRank() allows access to the rank
	6. public String getSuit() allows access to the suit
	7. public int getValue() allows access to the value
	8. public boolean testEquality (Card a) tests whether two cards have the same pointvalue
	9. public String toString helps print the rank, suit, and point values of each card



*/


class Card {
	
	
	private String rank;
	private String suit;
	private int value;
	
	public Card (String cRank, String cSuit, int cValue){
		rank = cRank;
		suit = cSuit;
		value = cValue;
	}
	
	public String getRank (){
		return rank;
	}
	
	public String getSuit (){
		return suit;
	}
	
	public int getValue (){
		return value;
	}
	
	public boolean testEquality (Card a){
		if (a.getValue() == this.getValue()) return true;
		else return false;
	}
	
	public String toString (){
		return rank + " of " + suit + "(point value = " + value + ")";
	}
}