package com.basra;

public class Main {

	public static void main(String[] args) {
		Card a = new Card(2, 7);
		Card b = new Card(2, 7);
		Card c = new Card(0, 9);
//            System.out.println(a);
//            System.out.println(a.equals(b));
//            System.out.println(a.equals(c));

		Deck deck = new Deck();
		deck.add(a);
		deck.add(b);
		deck.add(c);
		deck.print();
		deck.sortByRank();
		deck.print();
		deck.sortBySuit();
		deck.print();


	}
}
