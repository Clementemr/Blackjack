package HW2;

public class Player {
	
	// initializes the instance variables
	private Hand hand;
	private int standValue;
	private boolean softStand;


	public Player(int standValue, boolean softStand) {
		// constructor that takes the stand value and soft/hard stand
		this.standValue=standValue;
		this.hand = new Hand();
		this.softStand=softStand;
	}
	
	public String toString() {
		// returns the same function for hand
		return hand.toString();
	}
	
	public void Play(Deck deck) {
		// decides how to play based on if its a soft or hard stand
		// adds a card if the score is below the stand value
		if(softStand) {
		while(hand.getScore()<standValue) {
			hand.addCard(deck.deal());
		}
		}else {
			while((hand.getScore()<standValue) || (hand.getScore()<=standValue && hand.getSoft()>0) ) {
					hand.addCard(deck.deal());
				
		}
		}
	
	}
	
	public boolean isBust() {
		// returns if the score is a bust
		return hand.getScore()>21;
	}
	
	public int compareScores(Player other) {
		// takes the difference between scores
		return other.hand.getScore()-this.hand.getScore();
	}
	
	public int getScore() {
		// returns the score
		return hand.getScore();
	}
	
	public void setSoftStand(boolean softStand) {
		// changes the stand from soft to hard and vice versa
		this.softStand = softStand;
	}
}
