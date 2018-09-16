import java.util.*;
/*
This is my Deck class.
Document:
	1. private ArrayList<Card> createdCardDeck is an arraylist of 52 cards I created to stimulate real life card decks.
	2. private ArrayList<Card> discardedDeck is an arraylist that keeps track of the cards that got dealt already
	3. private int size handles the number of cards left undealt in a deck
	4. public Deck (String[] rank, String[] suit, int[] value) is my constructor; it needs 3 parameters
	5. public boolean isEmpty checks if the number of cards left is 0
	6. public int size() allows other class to get the value for size
	7. public Card deal() returns the last card in the createdCardDeck; subtracts size by 1 after it deals the card
	8. public void shuffle() generates a random number "r" between 1 to k (last card of the deck); 
						 - it swaps the card at "r" with the card at "k" from the created CardDeck arraylist

*/
class Deck {
	
	private ArrayList<Card> createdCardDeck = new ArrayList <Card>(52);
	private ArrayList<Card> discardedDeck = new ArrayList <Card> ();
	private int size;
	
	
	public Deck (String[] rank, String[] suit, int[] value){
		
	
		for (int i=0; i<suit.length; i++){			
			for (int k=0; k<rank.length;k++){
					Card create = new Card (rank[k],suit[i],value[k]);
					createdCardDeck.add(create);
					size++;
			}
		}		
		
		shuffle();
	}
	
	public boolean isEmpty(){
		if (size==0) return true;
		else return false;
	}	
	
	
	public int size(){
		return size;
	}
	
	
	public Card deal(){ //algorithm 2
		//size --;
		//return createdCardDeck.get(size);
		
		
		if (size==0){
			return null;
		}
		else {
			size--;
			return createdCardDeck.get(size);
		}
		
	
	}
	
	/*public int size(){ //algorithm 1

		return size;
	}
	
	public Card deal(){ 		
		Card a = createdCardDeck.get(createdCardDeck.size()-1);
		discardedDeck.add(a);
		createdCardDeck.remove(createdCardDeck.size()-1);
		size--;
		return a; 
	} */
	
	public void shuffle(){

				System.out.println(size);
		
			for (int k=createdCardDeck.size()-1; k>=0; k--){
				int r = (int)(Math.random()*k)+0;
		
				
				Card temp = createdCardDeck.get(r);
				createdCardDeck.set(r,createdCardDeck.get(k));
				createdCardDeck.set(k,temp);
			
				
			}
			
			size = 52;
	}
	
	
	
	
	
	
	
	
	
}