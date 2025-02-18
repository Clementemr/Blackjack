package HW2;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	// initializes the list
	private ArrayList<Card> cards;
	
	public Deck() {
		// constructor that makes 13 cards of ascending rank for each suit
		this.cards= new ArrayList<Card>();
		for(int i=2;i<15;i=i+1) {
			this.cards.add(new Card(i,'h'));
			this.cards.add(new Card(i,'d'));
			this.cards.add(new Card(i,'c'));
			this.cards.add(new Card(i,'s'));
		}
	}
	
	public String toString() {
		// returns the list as a string
		return "Deck: "+cards.toString();
	}
	
	public Card deal() {
		// removes a card and returns its value
		Card myCard = cards.get(0);
		cards.remove(0);
		return myCard;
	}
	
	public void shuffle() {
		for(int i=0;i<100;i++) {
			// randomly swaps 100 cards
			Collections.swap(cards,(int)Math.floor(Math.random()*52),(int)Math.floor(Math.random()*52));
		}
	}
	
	public void stack() {
		// moves the aces to the front of the deck
		int count=0;
		for (int i = 0; i < cards.size(); i++) {
			if(cards.get(i).getRank()==14) {
				Collections.swap(cards,i,0+count);
				count+=1;
			}
		}
	}
	
	
	
}
