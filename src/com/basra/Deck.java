package com.basra;

import java.util.*;

public class Deck {
    private ArrayList<Card> deck;

    /**
     * create an empty deck
     */
    public Deck() {
        this.deck = new ArrayList<>();
    }

    /**
     * creates a deck of specified size
     * <p>
     * the number of unique cards added to this deck
     */
    public Deck(int deckSize) {
        this.deck = new ArrayList<>(deckSize);

    }

    /**
     * @returns the number of cards in this deck.
     */
    public int size() {
        return this.deck.size();
    }

    /**
     * @return true if and only if this deck has one or more cards.
     */
    public boolean hasCards() {
        return !this.deck.isEmpty();
    }

    public Card get(int pos) {
        return this.deck.get(pos);
    }

    public void add(Card card) {
        this.deck.add(card);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void addAll(Deck other) {
        this.deck.addAll(other.getDeck());
        other.removeAll(other);
    }

    public void addAllWithoutRemove(Deck other) {
        this.deck.addAll(other.getDeck());
    }

    public Card removeLast() throws Exception {
        if (deck.isEmpty())
            throw new Exception("deck is empty");
        Card card = this.deck.get(size() - 1);
        this.deck.remove(size() - 1);
        return card;
    }

    public Card removeFirst() throws Exception {
        if (deck.isEmpty())
            throw new Exception("deck is empty");
        Card card = this.deck.get(0);
        this.deck.remove(0);
        return card;
    }

    public boolean remove(Card card) {
        return this.deck.remove(card);
    }

    public void removeAll(Deck other) {
        this.deck.removeAll(other.getDeck());
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = size() - 1; i > 0; i--) {
            int j = random.nextInt(i);
            Collections.swap(deck, i, j);
        }
    }

    public Deck deal(int n) throws Exception {
        Deck newDeck = new Deck();
        for (int i = 0; i < n; i++) {
            newDeck.add(removeLast());
        }
        return newDeck;
    }

    public boolean contains(Card card) {
        return this.deck.contains(card);
    }

    public boolean containsAll(Deck other) {
        return this.deck.containsAll(other.getDeck());
    }

    public void sortBySuit() {
        Collections.sort(this.deck, new Card.SortbySuit());


    }

    public void sortByRank() {
        Collections.sort(this.deck, new Card.SortbyRank());
    }

    public void print() {
        System.out.println(this);

    }

    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + deck +
                '}';
    }
}

