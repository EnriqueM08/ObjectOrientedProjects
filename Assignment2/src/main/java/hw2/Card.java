package hw2;

enum Suit{
	Hearts,
	Diamonds,
	Spades,
	Clubs
}

enum FaceValue {
	Ace,
	Two,
	Three,
	Four,
	Five,
	Six,
	Seven,
	Eight,
	Nine,
	Ten,
	Jack,
	Queen,
	King
}

/**
 * This card class is used to store the Card information including the 
 * enum suit and cardValue of the specific card
 */
public class Card {
	private int cardValue;
	private Suit cardSuit;
	private FaceValue cardFaceValue;
	
	public Card(int givenVal, Suit givenSuit) {
		setCardValue(givenVal);
		setCardSuit(givenSuit);
		int spot = 0;
		for (FaceValue value : FaceValue.values()) {
            spot++;
            if(spot == cardValue) {
            	setCardFaceValue(value);
            }
        }
	}

	public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int value) {
		this.cardValue = value;
	}

	public Suit getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(Suit givenSuit) {
		this.cardSuit = givenSuit;
	}
	
	public String toString() {
		return cardFaceValue + " of " + cardSuit;
	}

	public FaceValue getCardFaceValue() {
		return cardFaceValue;
	}

	public void setCardFaceValue(FaceValue cardFaceValue) {
		this.cardFaceValue = cardFaceValue;
	}
}
