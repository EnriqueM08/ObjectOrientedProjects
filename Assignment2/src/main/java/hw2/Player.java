package hw2;

/**
 * This class player contains multiple decks for their held cards, the cards they
 *  are currently using to play, and the cards they have won as well as some deck sizes.
 */
public class Player {
	private Deck heldDeck;
	private Deck playDeck;
	private Deck wonDeck;
	private int heldDeckSize;
	private int wonDeckSize;
	
	public Player(int deckSizeToSet) {
		heldDeck = new Deck();
		playDeck = new Deck();
		wonDeck = new Deck();
		heldDeckSize = deckSizeToSet;
		wonDeckSize = 0;
	}

	public Deck getHeldDeck() {
		return heldDeck;
	}

	public void setHeldDeck(Deck heldDeck) {
		this.heldDeck = heldDeck;
	}

	public int getHeldDeckSize() {
		return heldDeckSize;
	}

	public void setHeldDeckSize(int deckSize) {
		this.heldDeckSize = deckSize;
	}
	
	public Deck getPlayDeck() {
		return playDeck;
	}

	public void setPlayDeck(Deck playDeck) {
		this.playDeck = playDeck;
	}
	
	public Deck getWonDeck() {
		return wonDeck;
	}

	public void setWonDeck(Deck wonDeck) {
		this.wonDeck = wonDeck;
	}

	public int getWonDeckSize() {
		return wonDeckSize;
	}

	public void setWonDeckSize(int wonDeckSize) {
		this.wonDeckSize = wonDeckSize;
	}
	
	/**
	* Returns a card representing the top card in the held deck card deck
	* @return Card that is the top card of the held deck deck
	*/
	public Card removeTopHeldCard() {
		heldDeckSize--;
		
		return heldDeck.removeTopCard();
	}
	
	/**
	* Adds the given deck to the held deck of the player
	* @param deckToAdd the deck that will be added to held deck
	*/
	public void addToHeldDeck(Deck deckToAdd) {
		int numCardsToAdd = deckToAdd.getCurSizeOfDeck();
		
		for(int i = 0; i < numCardsToAdd; i++) {
			heldDeck.addCard(deckToAdd.removeTopCard());
			heldDeckSize++;
		}
	}
	
	/**
	* Adds the given deck to the won deck of the player
	* @param deckToAdd the deck that will be added to won deck
	*/
	public void addToWonDeck(Deck deckToAdd) {
		int numCardsToAdd = deckToAdd.getCurSizeOfDeck();
		
		for(int i = 0; i < numCardsToAdd; i++) {
			wonDeck.addCard(deckToAdd.removeCard(0));
			wonDeckSize++;
		}
	}
	
	/**
	* Clears the players play deck after round is played.
	*/
	public void clearPlayDeck() {
		while(playDeck.getCurSizeOfDeck() != 0)
			playDeck.removeCard(0);
	}
	
	/**
	* Plays the card and adds it to the play deck
	* @param playNum the player number in string form for printing played card
	*/
	public void playCard(String playNum) {
		playDeck.addCard(removeTopHeldCard());
		System.out.println("Player " + playNum + " plays: " + getTopPlayCard());
	}
	
	private Card getTopPlayCard() {
		return playDeck.getCards()[playDeck.getCurSizeOfDeck()-1];
	}
	
	/**
	* Plays a round of war and breaks any necessary ties.
	* @param playerTwo the player whose top playDeck Card will be compared too
	* @return boolean returns false if this card is bigger than playerTwo card
	*/
	public boolean comparePlayedCard(Player playerTwo) {
		if(playDeck.getCurSizeOfDeck() == 0 || 
				playerTwo.getPlayDeck().getCurSizeOfDeck() == 0)
			return false;
		
		if(playDeck.getCards()[playDeck.getCurSizeOfDeck()-1].getCardValue() >
				playerTwo.getPlayDeck().getCards()
				[playerTwo.getPlayDeck().getCurSizeOfDeck()-1].getCardValue())
		{
			return true;
		}
		
		return false;
	}
}
