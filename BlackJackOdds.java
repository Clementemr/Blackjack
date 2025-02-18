package HW2;

public class BlackJackOdds {

	public static void main(String[] args) {
		
		
		int trials = 5000;
		
		// loops for the soft/hard stands
		for(int z=0;z<2;z++) {
			for(int y=0;y<2;y++) {
		
		// loops for the stand values of the player and dealer
		for(int d=16;d<19;d++) {
			for(int p=16;p<19;p++) {
		
				// all of the variables to set up the loops for all of the simulations
				double playerWins = 0;
				double dealerWins = 0;
				double ties = 0;	
				boolean playerSoftStand=false;
				String playerStand = "hard";
				boolean dealerSoftStand=false;
				String dealerStand = "hard";
				
				// statements to change from hard to soft stands
				if(z==1) {
					playerSoftStand=true;
					playerStand="soft";
				}
				
				if(y==1) {
					dealerSoftStand=true;
					dealerStand="soft";
				}
		
		// loops the runs 5000 times to calculate the odds
		for(int i=0;i<trials;i++) {
			
		Deck deck = new Deck();
		// initializing the players
		Player player = new Player(p,playerSoftStand);
		
		Player dealer = new Player(d,dealerSoftStand);
		
		
		
		// code that plays the game
		deck.shuffle();
		player.Play(deck);
		dealer.Play(deck);
		
		//System.out.println("player "+player.getScore()+" vs dealer "+dealer.getScore());
		
		// code that figures out who wins or if its a tie
		if(player.isBust()) {
			dealerWins+=1;
			//System.out.println("dealer wins");
		}else if(dealer.isBust()) {
			playerWins+=1;	
			//System.out.println("player wins");
		}else if(player.getScore()>dealer.getScore()) {
			playerWins+=1;
			//System.out.println("player wins");
		}else if(player.getScore()<dealer.getScore()) {
			dealerWins+=1;
			//System.out.println("dealer wins");
		}else if(player.getScore()==dealer.getScore()) {
			ties+=1;
			//System.out.println("tie");
		}else {
			System.out.println("unexpected outcome");
		}
		}
		
		// statements that print out the results of each simulation
		System.out.println("dealer "+d+" ("+dealerStand+") vs player "+p+" ("+playerStand+"):");
		System.out.println("dealer won: "+dealerWins/(trials/100));
		System.out.println("player won: "+playerWins/(trials/100));
		System.out.println("No winner: "+ties/(trials/100));
		
			}
		}
	}
	}
	}
}
