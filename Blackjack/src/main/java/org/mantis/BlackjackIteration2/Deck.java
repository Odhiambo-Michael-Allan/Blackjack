package org.mantis.BlackjackIteration2;

import java.util.Iterator;
import java.util.Random;

/**
 * The Deck is responsible for building a deck of cards and adding them to a stack of cards.
 * This deck builds a standard 52 card deck.
 * @author Michael Allan Odhiambo.
 */
public class Deck {

    private Card[] deck;
    private int index;

    public Deck() {
        buildCards();
    }

    private void buildCards() {
        deck = new Card[52];
        Iterator suitsIterator = Suit.SUITS.iterator();
        int counter = 0;
        while ( suitsIterator.hasNext() ) {
            Suit suit = ( Suit ) suitsIterator.next();
            Iterator ranksIterator = Rank.RANKS.iterator();
            while ( ranksIterator.hasNext() ) {
                Rank rank = ( Rank ) ranksIterator.next();
                deck[ counter ] = new Card( suit, rank );
                counter++;
            }
        }
    }

    public void addToStack( DeckPile stack ) {
        stack.addCards( deck );
    }
}
