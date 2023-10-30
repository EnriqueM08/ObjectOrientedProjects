package hw2;

/**
 * This class is used for the second and third versions of War to play the game.
 */
public class WarVersionTwoAndThree extends WarVersionOne{
	
	public WarVersionTwoAndThree(int numOfPlayers, int seed, int version) {
		super(numOfPlayers, seed, version);
	}
	
	/**
	* Plays a round of war and breaks any necessary ties.
	* @return boolean that is true when a winner is possible and false otherwise
	*/
	@Override
	public boolean playRound() {
		if(players[0].getHeldDeckSize() == 0)
			return true;
		
		for(int i = 0; i < players.length; i++)
			players[i].playCard(Integer.toString(i+1));
		
		findRoundWinner();
		
		return false;
	}
	
	/**
	* Breaks ties resulting in war and determines who round and number of cards to play.
	*/
	@Override
	public void breakTie(){	
		int cardsToPlay = 3;
		
		System.out.println("*** WAR! ***");
	
		if (players[0].getHeldDeckSize() < 3) {
			cardsToPlay = players[0].getHeldDeckSize();
			if(cardsToPlay == 0)
			{
				tieWar();
				return;
			}
		}
		
		for(int i = 0; i < players.length; i++) {
			updatePlayDeck(players[i], cardsToPlay);
		}
		
		playRound();
	}
	
	private void tieWar() {
		for(int i = 0; i < players.length; i++) {
			players[i].addToWonDeck(players[i].getPlayDeck());
			players[i].clearPlayDeck();
		}
	}
	
	@Override
	public void findWinner() {
		game.determineWinnerVersionTwoAndThree(this);
	}
}
