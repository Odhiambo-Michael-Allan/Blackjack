package org.mantis.BlackjackIteration3;

import java.util.ArrayList;
import java.util.Iterator;

public class Hand {

    private static final int BLACKJACK = 21;
    private HandListener holder;
    private ArrayList<Card> cards = new ArrayList<>();
    private int numberOfAces;

    public Hand() {
        setHolder( new HandListener() {

            @Override
            public void handChanged() {}

            @Override
            public void handPlayable() {}

            @Override
            public void handBlackjack() {}

            @Override
            public void handBusted() {}
        } );
    }

    public void setHolder( HandListener holder ) {
        this.holder = holder;
    }

    public void addCard( Card card ) {
        cards.add( card );
        if ( card.getRank() == Rank.ACE )
            numberOfAces++;
        this.holder.handChanged();
        if ( this.isBlackjack() )
            this.holder.handBlackjack();
        if ( cards.size() == 2 )
            this.holder.handPlayable();
        else if ( this.getTotal() > 21 )
            holder.handBusted();
    }

    public boolean isBlackjack() {
        return this.cards.size() == 2 && this.getTotal() == BLACKJACK;
    }

    public void reset() {
        cards.clear();
        numberOfAces = 0;
    }

    public boolean isEqualTo( Hand otherHand ) {
        return this.getTotal() == otherHand.getTotal();
    }

    public boolean isGreaterThan( Hand otherHand ) {
        return this.getTotal() > otherHand.getTotal();
    }

    public int getTotal() {
        int tempNumberOfAces = numberOfAces;
        int total = 0;
        Iterator i = cards.iterator();
        while ( i.hasNext() ) {
            Card card = ( Card ) i.next();
            total += card.getRank().getRank();
        }
        while ( total > 21 && tempNumberOfAces > 0 ) {
            total -= 10;
            tempNumberOfAces--;
        }
        return total;
    }
}
