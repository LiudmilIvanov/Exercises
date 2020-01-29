package DeckOfCards;

public class Card {

	private String face;
	private Suit suit;

	public Card(String face, Suit suit) {
		this.face = face;
		this.suit = suit;
	}
	
	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}


	@Override
	public String toString() {
		return "Card [face=" + face + ", suit=" + suit + "]";
	}

	enum Suit {
		CLUB, DIAMOND, HEARTH, SPADE
	}

}
