package IterationThreeTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mantis.BlackjackIteration3.*;

public class HandTest {

    private static final Card ace = new Card( Suit.CLUBS, Rank.ACE );
    private static final Card cardTwo = new Card( Suit.CLUBS, Rank.TWO );
    private static final Card cardThree = new Card( Suit.CLUBS, Rank.THREE );
    private static final Card cardSeven = new Card( Suit.CLUBS, Rank.SEVEN );
    private static final Card jack = new Card( Suit.CLUBS, Rank.JACK );
    private static final Card cardFive = new Card( Suit.CLUBS, Rank.FIVE );
    private static final Card cardSix = new Card( Suit.CLUBS, Rank.SIX );
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
        hand.addCard( jack );
        Assertions.assertTrue( handListener.isPlayable(), "Hand should be playable" );
        Assertions.assertTrue( handListener.isBlackjack(), "Hand should have a blackjack" );
        hand.reset();
        hand.addCard( cardSeven );
        hand.addCard( cardThree );
        hand.addCard( jack );
        hand.addCard( cardTwo );
        Assertions.assertTrue( handListener.isBusted(), "Hand should be busted" );
    }

    @Test
    public void testGetTotal() {
        hand.addCard( ace );
        hand.addCard( ace );
        hand.addCard( jack );
        Assertions.assertTrue( hand.getTotal() == 12, "Hand total is incorrect" );
    }

    @Test
    public void testReset() {
        hand.addCard( ace );
        hand.addCard( jack );
        Assertions.assertTrue( handListener.isBlackjack(), "Hand should have a blackjack" );
        hand.reset();
        Assertions.assertTrue( !hand.isBlackjack(), "Hand should not have a blackjack after reset" );
    }

    @Test
    public void testIsEqual() {
        Hand hand1 = new Hand();
        hand.addCard( cardFive );
        hand.addCard( cardTwo );
        hand.addCard( jack );
        hand1.addCard( ace );
        hand1.addCard( cardSix );
        Assertions.assertTrue( hand.isEqualTo( hand1 ), "Hands should be equal" );
    }

    @Test
    public void testGreaterThan() {
        Hand hand1 = new Hand();
        hand1.addCard( jack );
        hand1.addCard( ace );
        hand.addCard( cardSeven );
        Assertions.assertTrue( !hand.isGreaterThan( hand1 ), "Hand should be less than hand1" );
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
