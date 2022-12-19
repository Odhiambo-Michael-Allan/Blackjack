package IterationThreeTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mantis.BlackjackIteration3.*;

public class HandTest {

    private static final Card ace = new Card( Suit.CLUBS, Rank.ACE );
    private static final Card cardTwo = new Card( Suit.CLUBS, Rank.TWO );
    private static final Card cardThree = new Card( Suit.CLUBS, Rank.THREE );
    private Hand hand;
    private MockHandListener handListener;

    @BeforeEach
    public void setup() {
        hand = new Hand();
        handListener = new MockHandListener();
        hand.setHolder( handListener );
    }

    @Test
    public void testAddCard() {
        hand.addCard( ace );
        Assertions.assertTrue( handListener.isChanged(), "Listener should have been notified of a hand change" );
        hand.addCard()
    }

    private class MockHandListener implements HandListener {

        private boolean changed, playable, blackjack, busted;

        @Override
        public void handChanged() {
            changed = true;
        }

        @Override
        public void handPlayable() {
            playable = true;
        }

        @Override
        public void handBlackjack() {
            blackjack = true;
        }

        @Override
        public void handBusted() {
            busted = true;
        }

        private boolean isChanged() {
            return changed;
        }

        private boolean isPlayable() {
            return playable;
        }

        private boolean isBlackjack() {
            return blackjack;
        }

        private boolean isBusted() {
            return busted;
        }
    }
}
