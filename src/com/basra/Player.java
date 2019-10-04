package com.basra;

import java.util.Objects;

public class Player {
    private String name;
    private boolean turn;
    private Deck hand;
    private Deck bank;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.hand = new Deck(4);
        this.bank = new Deck();
    }

    public String getName() {
        return name;
    }

    public Deck getHand() {
        return hand;
    }

    public Deck getBank() {
        return bank;
    }

    public int getPoints() {
        return points;
    }

    public void startTurn() {
        this.turn = true;
    }

    public void endTurn() {
        this.turn = false;
    }

    private int cardPoints(int rank) {
        switch (rank) {
            case 11:
            case 12:
            case 13:
                return 10;
            default:
                return rank;
        }
    }

    private Card getCardToPlay(Ground ground, int size) throws Exception {
        switch (size) {
            case 0:
                ground.add(this.hand.get(this.hand.size() - 1));
                return this.hand.get(this.hand.size() - 1);
            case 1:
                Card groundCard = ground.get(0);
                for (Card playerCard : this.hand.getDeck()) {
                    if (playerCard.getRank() == groundCard.getRank()) {
                        this.bank.add(playerCard);
                        this.bank.add(groundCard);
                        ground.remove(groundCard);
                        this.points += 10 +
                                this.cardPoints(playerCard.getRank()) +
                                this.cardPoints(groundCard.getRank());
                        return playerCard;
                    }
                }
                for (Card playerCard : this.hand.getDeck()) {
                    if (playerCard.getRank() == 11) {
                        this.bank.add(playerCard);
                        this.bank.add(groundCard);
                        ground.remove(groundCard);
                        this.points += 30 +
                                this.cardPoints(playerCard.getRank()) +
                                this.cardPoints(groundCard.getRank());
                        return playerCard;
                    }
                }
                ground.add(this.hand.get(this.hand.size() - 1));
                return this.hand.get(this.hand.size() - 1);
            default:
                for (Card playerCard : this.hand.getDeck()) {
                    if (playerCard.getRank() == 11) {
                        this.points += 10;
                        this.bank.add(playerCard);
                        for (Card card : ground.getDeck())
                            this.points += this.cardPoints(card.getRank());
                        this.bank.addAll(ground);
                        return playerCard;
                    }
                }
                //
                Card chosenPC = null;
                Card matchingGC = null;
                boolean found = false;
                for (Card pc : this.hand.getDeck()) {
                    for (Card gc : ground.getDeck()) {
                        if (pc.getRank() == gc.getRank()) {
                            found = true;
                            chosenPC = pc;
                            matchingGC = gc;
                            this.bank.add(pc);
                            this.bank.add(gc);
                            this.points += this.cardPoints(pc.getRank()) +
                                    this.cardPoints(gc.getRank());
                            break;
                        }
                    }
                }
                if (found) {
                    this.hand.remove(chosenPC);
                    ground.remove(matchingGC);
                    return chosenPC;
                } else {
                    ground.add(this.hand.get(this.hand.size() - 1));
                    return this.hand.get(this.hand.size() - 1);
                }
        }
    }

    public void play(Ground ground) throws Exception {
        Card pCard = getCardToPlay(ground, ground.size());
        this.hand.remove(pCard);
    }

}
