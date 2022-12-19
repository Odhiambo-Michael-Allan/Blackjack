package org.mantis.BlackjackIteration1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A Hand holds onto, provides access to, and provides information about a Blackjack hand of cards.
 * @author Michael Allan Odhiambo.
 */
public class Hand {

    private static final int BLACKJACK = 21;
    private ArrayList<Card> cards = new ArrayList<>();

    public Hand() {}

    public void addCard( Card card ) {
        cards.add( card );
    }

    public boolean bust() {
        if ( getTotal() > BLACKJACK )
            return true;
        return false;
    }

    public int getTotal() {
        int total = 0;
        Iterator i = cards.iterator();
        while ( i.hasNext() ) {
            Card card = ( Card ) i.next();
            total += card.getRank().getRank();
        }
        return total;
    }

    public void reset() {
        cards.clear();
    }

    public void turnOver() {
        Iterator i = cards.iterator();
        while ( i.hasNext() ) {
            Card card = ( Card ) i.next();
            card.setFaceUp( true );
        }
    }

    public String toString() {
        String string = "";
        Iterator i = cards.iterator();
        while ( i.hasNext() ) {
            Card card = ( Card ) i.next();
            string = string + " " + card.toString();
        }
        return string;
    }
}
