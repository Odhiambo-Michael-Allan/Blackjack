package org.mantis.BlackjackIteration3;

import java.util.ArrayList;

public class Hand {

    private static final int BLACKJACK = 21;
    private HandListener holder;
    private ArrayList<Card> cards = new ArrayList<>();

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
        this.holder.handChanged();
    }
}
