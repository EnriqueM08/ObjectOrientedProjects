package hw2;

import warInterface.War;

/**
 * This class is used for the first original version of War to play the game.
 */
public class WarVersionOne implements War{
	protected Player[] players;
	protected int version;
	protected ScoreTracker game;
	
	public WarVersionOne(int numPlayers, int seed, int version) {
		players = new Player[numPlayers];
		Deck mainDeck = new Deck(seed);
        mainDeck.setDefaultCards();
		for(int i = 0; i < players.length; i++) {
			players[i] = new Player(52 / players.length);
			players[i].setHeldDeck(mainDeck.getSplitFromDeck(i, players.length));
		}
		this.version = version;
        game = new ScoreTracker();
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	/**
	* Plays a round of war and breaks any necessary ties.
	* @return boolean that is true when a winner is possible and false otherwise
	*/
	@Override
	public boolean playRound() {
		checkDecks();
		if(players[0].getHeldDeckSize() == 0 || players[1].getHeldDeckSize() == 0) {
			return true;
		}
		for(int i = 0; i < players.length; i++)
			players[i].playCard(Integer.toString(i+1));
		findRoundWinner();
		
		return false;
	}
	
	protected void findRoundWinner() {
		boolean won;
		for(int i = 0; i < players.length; i++) {
			won = true;
			for(int j = 0; j < players.length; j++) {
				if(players[i] != players[j] && 
						!players[i].comparePlayedCard(players[j]))
					won = false;
			}
			if(won) {
				addWinningDeck(players[i]);
				System.out.println("Player " + (i + 1) + " wins the round!");
				game.printScores(this);
				return;
			}
			else if(i == players.length-1)
				breakTie();
		}
	}
	
	private void addWinningDeck(Player winner) {
		for(int i = 0; i < players.length; i++) {
			winner.addToWonDeck(players[i].getPlayDeck());
			players[i].clearPlayDeck();
		}
	}

	/**
	* Breaks ties resulting in war and determines who round and number of cards to play.
	*/
	@Override
	public void breakTie() {
		int cardsToPlay = 3;
		checkDecks();
		System.out.println("*** WAR! ***");
		cardsToPlay = checkPlayersCanPlay();
		for(int i = 0; i < players.length; i++) {
			updatePlayDeck(players[i], cardsToPlay);
		}
		playRound();
	}
	
	private int checkPlayersCanPlay() {
		int cardsToPlay = 3;
		boolean canPlay = true;
		for(int i = 0; i < players.length; i++) {
			canPlay = true;
			for(int j = 0; j < players.length; j++) {
				if(i != j && players[i].getHeldDeckSize() < 3 && 
				players[j].getHeldDeckSize() > players[i].getHeldDeckSize()) {
					players[j].addToWonDeck(players[i].getHeldDeck());
					players[i].setHeldDeckSize(0);
					cardsToPlay = 0;
					canPlay = false;
					i = players.length;
					j = players.length;
				}
			}
		}
		checkEqaulHeldPiles(canPlay);
		return cardsToPlay;
	}
	
	private int checkEqaulHeldPiles(boolean canPlay) {
		int cardsToPlay = 3;	
		if(players[0].getHeldDeckSize() < 3 && 
			players[0].getHeldDeckSize() == players[1].getHeldDeckSize() 
			&& canPlay) {
			cardsToPlay = players[0].getHeldDeckSize();
			if(cardsToPlay == 0) {
				players[0].addToWonDeck(players[0].getPlayDeck());
				players[0].clearPlayDeck();
				players[1].addToWonDeck(players[1].getPlayDeck());
				players[1].clearPlayDeck();
			}
		}		
		return cardsToPlay;
	}
	
	protected void updatePlayDeck(Player toUpdate, int cardsToPlay) {
		for(int i = 0; i < cardsToPlay-1; i++)
			toUpdate.getPlayDeck().addCard(toUpdate.removeTopHeldCard());
	}

	private void checkDecks() {
		for(int i = 0; i < players.length; i++) {
			if(players[i].getHeldDeckSize() < 3 && players[i].getWonDeckSize() != 0) {
				players[i].addToHeldDeck(players[i].getWonDeck());
				players[i].setWonDeckSize(0);
			}
		}
	}

	/**
	* Determines who won the game with two players.
	*/
	@Override
	public void findWinner() {
		game.determineWinnerVersionOne(this);
	}
}