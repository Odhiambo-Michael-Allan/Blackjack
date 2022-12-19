package IterationOneTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mantis.BlackjackIteration1.Card;
import org.mantis.BlackjackIteration1.Hand;
import org.mantis.BlackjackIteration1.Rank;
import org.mantis.BlackjackIteration1.Suit;

/**
 * @author Michael Allan Odhiambo.
 */

public class HandTest {

    private Hand hand = new Hand();

    private static final Card cardTwo = new Card( Suit.HEARTS, Rank.TWO );
    private static final Card cardThree = new Card( Suit.HEARTS, Rank.THREE );
    private static final Card cardFour = new Card( Suit.HEARTS, Rank.FOUR );
    private static final Card cardFive = new Card( Suit.HEARTS, Rank.FIVE );
    private static final Card cardSix = new Card( Suit.HEARTS, Rank.SIX );
    private static final Card cardSeven = new Card( Suit.HEARTS, Rank.SEVEN );
    private static final Card cardEight = new Card( Suit.HEARTS, Rank.EIGHT );
    private static final Card cardNine = new Card( Suit.HEARTS, Rank.NINE );
    private static final Card cardTen = new Card( Suit.HEARTS, Rank.TEN );
    private static final Card jack = new Card( Suit.HEARTS, Rank.JACK );
    private static final Card queen = new Card( Suit.HEARTS, Rank.QUEEN );
    private static final Card king = new Card( Suit.HEARTS, Rank.KING );
    private static final Card ace = new Card( Suit.HEARTS, Rank.ACE );

    @Test
    public void testTotal() {
        int total = cardTwo.getRank().getRank();
        hand.addCard( cardTwo );
        Assertions.assertTrue( hand.getTotal() == total );

        total += cardThree.getRank().getRank();
        hand.addCard( cardThree );
        Assertions.assertTrue( hand.getTotal() == total );

        total += jack.getRank().getRank();
        hand.addCard( jack );
        Assertions.assertTrue( hand.getTotal() == total );

        hand.reset();
        total = 0;
        Assertions.assertTrue( hand.getTotal() == 0 );

        total += queen.getRank().getRank();
        hand.addCard( queen );
        Assertions.assertTrue( hand.getTotal() == total );
    }

    @Test
    public void testBust() {
        hand.addCard( cardTwo );
        Assertions.assertTrue( !hand.bust(), "Hand should not be busted" );
        hand.addCard( cardThree );
        Assertions.assertTrue( !hand.bust(), "Hand should not be busted" );
        hand.addCard( cardFour );
        Assertions.assertTrue( !hand.bust(), "Hand should not be busted" );
        hand.addCard( cardFive );
        Assertions.assertTrue( !hand.bust(), "Hand should not be busted" );
        hand.addCard( cardSix );
        Assertions.assertTrue( !hand.bust(), "Hand should not be busted" );
        hand.addCard( cardSeven );
        Assertions.assertTrue( hand.bust(), "Hand should be busted" );
        hand.reset();
        Assertions.assertTrue( !hand.bust(), "Hand should not be busted after reset" );
    }

}
