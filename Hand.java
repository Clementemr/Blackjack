package HW2;

import java.util.ArrayList;

public class Hand {
	
	// initializing variables/ the list of cards
	private ArrayList<Card> cards;
	private int score;
	private int soft;
	

	public Hand() {
		// constructor that takes no parameters and makes a new list
		this.cards= new ArrayList<Card>();
		this.score=0;
		this.soft=0;
	}
	
	public String toString() {
		// makes a printout depending on if the hand is soft or hard 
		if(soft>0) {
			return "Hand: "+cards.toString()+" score: "+score+" soft";
		}else {
			return "Hand: "+cards.toString()+" score: "+score+" hard";
		}
	}
	
	public void addCard(Card card) {
		// adds a card and updates the score
		cards.add(card);
		updateScore(card);
	}
	
	public void removeCard(Card card) {
		// checks if the list contains the card and removes it if it does
		if(cards.contains(card)) {
			cards.remove(card);
		}
	}
	
	public int getScore() {
		// returns the score
		return score;
	}

	public void updateScore(Card card) {
		// if the card is an ace it makes the score soft if it has less than 11 score
		// if its not an ace then it checks if the score is soft and adds the card accordingly
		if(card.getRank()==14) {
			if(this.score>10) {
				this.score=score+1;
			}else {
				this.score=score+11;
				this.soft=soft+1;
			}
		}else if(soft>0){
			if(score+card.getScore()>21) {
			this.score=score+card.getScore();
			this.score=this.score-10;
			this.soft=this.soft-1;
			}else {
				this.score=score+card.getScore();
			}
		}else {
		this.score=score+card.getScore();
		}

	}	
	
	public int getSoft() {
		// returns the number of aces in the hand
		return soft;
	}
	

}
