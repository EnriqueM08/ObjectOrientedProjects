package hw2;

import java.util.Random;

/**
 * This class Deck is used to store the deck information of cards and can be used to
 *  store both full and partial decks. Can shuffle deck and remove cards.
 */
public class Deck {
	private static int SIZEOFDECK = 52;
	private int CardsInDeck;
	private int curSizeOfDeck;
	private int seed;
	private Card[] cards;
	
	public Deck() {
		cards = new Card[SIZEOFDECK];
		curSizeOfDeck = 0;
		seed = 0;
	}
	
	public Deck(int seed) {
		cards = new Card[SIZEOFDECK];
		curSizeOfDeck = 0;
		this.seed = seed;
	}
	
	public int getCardsInDeck() {
		return CardsInDeck;
	}

	public void setCardsInDeck(int cardsInDeck) {
		CardsInDeck = cardsInDeck;
	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
		curSizeOfDeck = cards.length;
	}
	
	public int getCurSizeOfDeck() {
		return curSizeOfDeck;
	}
	
	public void setCurSizeOfDeck(int sizeOfDeck) {
		this.curSizeOfDeck = sizeOfDeck;
	}
	
	public int getSeed() {
		return seed;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}
	
	/**
	* Generates default cards and then calls shuffle to shuffle them
	*/
	public void setDefaultCards() {
		int spotInDeck = 0;
		
		for(Suit tempSuit : Suit.values()) {
			for(int j = 1; j < 14; j++) {
				cards[spotInDeck] = new Card(j, tempSuit);
				spotInDeck++;
			}
		}
		
		curSizeOfDeck = SIZEOFDECK;
		shuffle();
	}
	
	/**
	* Shuffles card in a random order and updates the deck
	*/
	private void shuffle() {
		Card temp[] = new Card[SIZEOFDECK];
		Random rand = new Random(seed);
		
		for(int i = 0; i < SIZEOFDECK; i++) {
			temp[i] = removeCard(rand.nextInt(SIZEOFDECK-i));
		}
		setCards(temp);
	}
	
	/**
	* Removes a card from the deck in the given location 
	* @param location the spot where the card will be removed from
	* @return returns the card at the given location
	*/
	public Card removeCard(int location) {
		if(location < 0 || location > cards.length || curSizeOfDeck == 0)
			return null;
		if(curSizeOfDeck == 1) {
			curSizeOfDeck--;
			return cards[location];
		}
		
		Card temp = cards[location];
		cards[location] = cards[curSizeOfDeck-1];
		curSizeOfDeck--;
		
		return temp;
	}
	
	/**
	* Removes the top card from the deck and returns it
	* @return returns the card from the top of the deck
	*/
	public Card removeTopCard() {
		if(curSizeOfDeck == 0)
			return null;
		
		curSizeOfDeck--;
		return cards[curSizeOfDeck];
	}
	
	/**
	* Generates a new deck for the given player given the total number of players
	* @param player int representing player number numOfPlayers total number of players
	* @return Deck split from this deck for the given player
	*/
	public Deck getSplitFromDeck(int player, int numOfPlayers) {
		Deck temp = new Deck();
		int numOfCardsToGive = SIZEOFDECK / numOfPlayers;
		
		for(int i = player * numOfCardsToGive; i < numOfCardsToGive * (player + 1); i++) {
			temp.getCards()[i - (player * numOfCardsToGive)] = cards[i];
		}
		
		temp.setCurSizeOfDeck(numOfCardsToGive);
		return temp;
	}
	
	/**
	* Adds a card to this deck given the card to add
	* @param cardToAdd the card that will be added to the deck
	*/
	public void addCard(Card cardToAdd) {
		if(curSizeOfDeck < 52) {
			cards[curSizeOfDeck] = cardToAdd;
			curSizeOfDeck++;
		}
	}
}