package org.mantis.BlackjackIteration3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A Hand holds onto, provides access to, and provides information about a Blackjack hand of cards.
 * @author Michael Allan Odhiambo.
 */
public class Hand {

    private static final int BLACKJACK = 21;
    private ArrayList<Card> cards = new ArrayList<>();
    private HandListener holder;
    private int numberOfAces;

    public Hand() {
        // Set the holder to a blank listener so it will not be null if not
        // externally set.
        this.setHolder(
                new HandListener() {
                    @Override
                    public void handPlayable() {}

                    @Override
                    public void handBlackjack() {}

                    @Override
                    public void handBusted() {}

                    @Override
                    public void handChanged() {}
                }
        );
    }

    public void setHolder( HandListener holder ) {
        this.holder = holder;
    }

    public void addCard( Card card ) {
        cards.add( card );
        holder.handChanged();
        if ( card.getRank() == Rank.ACE )
            numberOfAces++;
        if ( this.bust() )
            holder.handBusted();
        else if ( this.blackjack() )
            holder.handBlackjack();
        else if ( cards.size() >= 2 )
            holder.handPlayable();
    }

    public boolean bust() {
        if ( getTotal() > BLACKJACK )
            return true;
        return false;
    }

    public boolean blackjack() {
        if ( cards.size() == 2 && this.getTotal() == BLACKJACK )
            return true;
        return false;
    }

    public boolean isEqualTo( Hand hand ) {
        return this.getTotal() == hand.getTotal();
    }

    public boolean isGreaterThan( Hand hand ) {
        return this.getTotal() > hand.getTotal();
    }

    public int getTotal() {
        int total = 0;
        Iterator i = cards.iterator();
        while ( i.hasNext() ) {
            Card card = ( Card ) i.next();
            total += card.getRank().getRank();
        }
        int tempAces = numberOfAces;
        while ( total > BLACKJACK && tempAces > 0 ) {
            total -= 10;
            tempAces--;
        }
        return total;
    }

    public void reset() {
        cards.clear();
        numberOfAces = 0;
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
