package com.basra;

import java.util.Comparator;

public class Card {
	private int suit;
	private int rank;
	private final int DIAMOND = 0;
	private final int CLUB = 1;
	private final int HEART = 2;
	private final int SPADE = 3;


	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}

	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public boolean equals(Object object) {
		if (!(object instanceof Card))
			return false;
		Card other;
		other = (Card) object;
		return (other.getSuit() == this.suit && other.getRank() == this.rank);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Suit: ");
		str.append(this.suit);
		str.append(" Rank: ");
		str.append(this.rank);
		str.append(" ");
		return str.toString();
	}

	static class SortbySuit implements Comparator<Card> {
		// Used for sorting in ascending order of
		// card number
		public int compare(Card a, Card b) {
			return a.getSuit() - b.getSuit();
		}
	}

	static class SortbyRank implements Comparator<Card> {
		// Used for sorting in ascending order of
		// card number
		public int compare(Card a, Card b) {
			return a.getRank() - b.getRank();
		}
	}


}

