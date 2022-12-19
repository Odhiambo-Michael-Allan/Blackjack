package org.mantis.BlackjackIteration3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * The DeckPile holds onto an arbitrary number of decks. It provides support for dealing and shuffling cards.
 * @author Michael Allan Odhiambo.
 */
public class DeckPile {

    private ArrayList<Card> stack = new ArrayList<>();
    private int index;
    private Random rand = new Random();

    public DeckPile() {}

    public void addCards( Card[] cards ) {
        for ( int i = 0; i < cards.length; i++ )
            stack.add( cards[i] );
    }

    public void shuffle() {
        reset();
        for ( int i = 0; i < 4; i++ )
            randomize();
    }

    public void reset() {
        index = 0;
        Iterator i = stack.iterator();
        while ( i.hasNext() ) {
            Card card = ( Card ) i.next();
            card.setFaceUp( false );
        }
    }

    private void randomize() {
        int numberOfCards = stack.size();
        for ( int i = 0; i < numberOfCards; i++ ) {
            int index = rand.nextInt( numberOfCards );
            Card cardI = stack.get( i );
            Card cardIndex = stack.get( index );
            stack.set( i, cardIndex );
            stack.set( index, cardI );
        }
    }

    public Card dealUp() {
        Card card = deal();
        if ( card != null )
            card.setFaceUp( true );
        return card;
    }

    public Card dealDown() {
        Card card = deal();
        if ( card != null )
            card.setFaceUp( false );
        return card;
    }


    /**
     * When a card is dealt from the DeckPile, the card is not actually removed from the DeckPile.
     * An index is incremented to reflect the current position in the DeckPile. This allows for
     * quick retrieval of all the cards and resetting the deck.
     * @return
     */
    private Card deal() {
        if ( index != stack.size() ) {
            Card card = stack.get( index );
            index++;
            return card;
        }
        return null;
    }
}
