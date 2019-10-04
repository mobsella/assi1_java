package com.basra;

/* Mohamed Ads 900142564 Assigment number 1
    Instructions: all you have to do is running the code and you will see what player A and player B have in their hands
    and what cards are on the ground, also what A and B played and then the deck after the end of the turn then after
    4 turns and both players have 0 cards they both take 4 cards again until deck is empty and on each turn both players
    gain points so that the winner in the end is the one with the highest points
    extra info (Rank:11 stands fo the jack, 12 is for the King, 13 is for the queen and each of their values worth
    10 points)
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Deck deck = buildMainDeck();
        //deck.print();
        Player A = new Player("Mobs");
        Player B = new Player("Khaled");
        Ground G = new Ground();
        deck.shuffle();
        G.addAll(deck.deal(4));
        int hand = 1;
        while (deck.size() > 0) {
            System.out.println("Hand #" + hand);
            A.getHand().addAll(deck.deal(4));
            System.out.println("a's deck");
            A.getHand().print();
            B.getHand().addAll(deck.deal(4));
            System.out.println("b's deck");
            B.getHand().print();

            for (int i = 0; i < 4; i++) {
                System.out.println("abl may2osh");
                G.print();
                A.play(G);
                B.play(G);
                System.out.println("Turn #" + (i + 1));
                System.out.println("a");
                A.getHand().print();
                System.out.println("A Points:" + A.getPoints());
                System.out.println("b");
                B.getHand().print();
                System.out.println("B Points:" + B.getPoints());
                System.out.println("ba3d may2osh");
                G.print();


            }
            hand++;
        }
        System.out.println("AND THE WINNER IS: " + (A.getPoints() >= B.getPoints() ? A.getName() : B.getName()));
        if (A.getPoints() == B.getPoints())
            System.out.println("DRAW");
    }


    private static Deck buildMainDeck() {
        Deck deck = new Deck();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                deck.add(new Card(i, j));
            }
        }
        return deck;
    }
}
