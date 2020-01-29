package DeckOfCards;

import java.util.ArrayList;
import java.util.Random;

import DeckOfCards.Card.Suit;

public class CardsShuffle {
	public static void main(String[] args) {
		ArrayList<Card> deck = new ArrayList<Card>();
		deck.add(new Card("A", Suit.HEARTH));
		deck.add(new Card("2", Suit.SPADE));
		deck.add(new Card("5", Suit.CLUB));
		deck.add(new Card("J", Suit.DIAMOND));
		deck.add(new Card("K", Suit.CLUB));
		deck.add(new Card("10", Suit.DIAMOND));

		printCards(deck);
		
		shuffleDeck(deck);
		
		System.out.println("After shuffling the cards: ");
		printCards(deck);

	}

	private static void performSingleExchange(ArrayList<Card> deck) {
		Random rand = new Random();
		int randomIndex = 1 + rand.nextInt(deck.size() - 1);
		Card firstCard = deck.get(0);
		Card randomCard = deck.get(randomIndex);
		deck.set(0, randomCard);
		deck.set(randomIndex, firstCard);
	}

	private static void shuffleDeck(ArrayList<Card> deck) {
		for (int i = 0; i < deck.size(); i++) {
			performSingleExchange(deck);
		}
	}

	private static void printCards(ArrayList<Card> deck) {
		for (Card card : deck) {
			System.out.println(card);
		}

	}

}
