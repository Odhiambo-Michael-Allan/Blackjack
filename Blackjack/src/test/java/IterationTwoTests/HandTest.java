package IterationTwoTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mantis.BlackjackIteration2.*;

public class HandTest {

    private Hand hand;
    private MockHandListener handListener;
    private static final Card cardTwo = new Card( Suit.HEARTS, Rank.TWO );
    private static final Card cardThree = new Card( Suit.HEARTS, Rank.THREE );
    private static final Card cardFour = new Card( Suit.HEARTS, Rank.FOUR );
    private static final Card cardFive = new Card( Suit.HEARTS, Rank.FIVE );
    private static final Card cardSix = new Card( Suit.HEARTS, Rank.SIX );
    private static final Card cardSeven = new Card( Suit.HEARTS, Rank.SEVEN );
    private static final Card cardEight = new Card( Suit.HEARTS, Rank.EIGHT );
    private static final Card cardNine = new Card( Suit.HEARTS, Rank.NINE );
    private static final Card king = new Card( Suit.HEARTS, Rank.KING );
    private static final Card queen = new Card( Suit.HEARTS, Rank.QUEEN );
    private static final Card jack = new Card( Suit.HEARTS, Rank.JACK );
    private static final Card ace = new Card( Suit.HEARTS, Rank.ACE );

    @BeforeEach
    public void setup() {
        hand = new Hand();
        handListener = new MockHandListener();
        hand.setHolder( handListener );
    }

    @Test
    public void testEqual() {
        Hand hand1 = new Hand();
        hand.addCard( cardTwo );
        hand.addCard( king );
        hand.addCard( cardNine );
        hand1.addCard( ace );
        hand1.addCard( queen );
        Assertions.assertTrue( hand.isEqualTo( hand1 ), "Hands should be equal" );
    }

    @Test
    public void testTotal() {
        hand.addCard( cardTwo );
        hand.addCard( cardThree );
        hand.addCard( ace );
        Assertions.assertTrue( hand.getTotal() == 16, "Hand total should be 16" );
        hand.addCard( ace );
        Assertions.assertTrue( hand.getTotal() == 17, "Hand total should be 17" );
    }

    @Test
    public void testAddCard() {
        hand.addCard( king );
        Assertions.assertTrue( handListener.isChanged(), "Hand should have changed" );
        Assertions.assertTrue( !handListener.isPlayable(), "Hand should not be playable" );
        hand.addCard( queen );
        Assertions.assertTrue( handListener.isPlayable(), "Hand should be playable" );
    }

    @Test
    public void testBust() {
        hand.addCard( king );
        hand.addCard( queen );
        Assertions.assertTrue( !handListener.isBusted(), "Hand should not be busted" );
        hand.addCard( cardFive );
        Assertions.assertTrue( handListener.isBusted(), "Hand should be busted" );
    }

    @Test
    public void testBlackjack() {
        hand.addCard( king );
        Assertions.assertTrue( !handListener.isBlackjack(), "Hand should not have a blackjack" );
        hand.addCard( ace );
        Assertions.assertTrue( handListener.isBlackjack(), "Hand should have a blackjack" );
    }

    @Test
    public void testIsGreaterThan() {
        Hand hand1 = new Hand();
        hand.addCard( king );
        hand.addCard( queen );
        hand1.addCard( cardTwo );
        hand1.addCard( cardThree );
        Assertions.assertTrue( !hand1.isGreaterThan( hand ), "Hand 1 is less than hand" );
    }

    @Test
    public void testReset() {
        hand.addCard( king );
        hand.addCard( cardSeven );
        hand.reset();
        Assertions.assertTrue( hand.getTotal() == 0, "Total should be 0 after reset." );
    }

    public class MockHandListener implements HandListener {

        private boolean playable, blackjack, busted, changed;

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

        @Override
        public void handChanged() {
            changed = true;
        }

        public boolean isPlayable() {
            return playable;
        }

        public boolean isBlackjack() {
            return blackjack;
        }

        public boolean isBusted() {
            return busted;
        }

        public boolean isChanged() {
            return changed;
        }
    }

}
