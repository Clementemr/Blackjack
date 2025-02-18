package HW2;

public class Card {

	// initializes the variables
	private int rank;
	private char suit;
	private int score;
	
	public Card(int rank, char suit) {
		// constructor that takes rank and suit as parameters
		this.rank=rank;
		this.suit=suit;
		if(rank<11) {
			score=rank;
		}else if(rank<14) {
			score=10;
		}else {
			score=11;
		}
		
	}
	
	public Card(Card that) {
		// copy constructor
		this.rank=that.rank;
		this.suit=that.suit;
		this.score=that.score;
	}
	
	public boolean equals(Object that) {
		// checks if parameter is a card and is equal to this card
		if(that instanceof Card) {
			if(((Card) that).rank == this.rank && ((Card) that).suit == this.suit){
				return true;
			}
		}
		return  false;
	}
	
	
	public String toString() {
		// makes a printout of the card including the rank and suit
		String tempSuit = Character.toString(this.suit);
		String tempRank;
		
		if(rank==11) {
			tempRank="J";
		}else if(rank==12){
			tempRank="Q";
		}else if(rank==13) {
			tempRank="K";
		}else if(rank==14) {
			tempRank="A";
		}else {
			tempRank = Integer.toString(this.rank);
		}
		
		
		return "Card: "+tempRank+tempSuit;
		
	}

	public int getRank() {
		// getter for rank
		return rank;
	}
	
	public int getScore() {
		// getter for score
		return this.score;
	}
	
	}
