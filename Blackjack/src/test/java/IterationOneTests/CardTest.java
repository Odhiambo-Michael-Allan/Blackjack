package IterationOneTests;

import org.junit.jupiter.api.Test;
import org.mantis.BlackjackIteration1.Card;
import org.mantis.BlackjackIteration1.Rank;
import org.mantis.BlackjackIteration1.Suit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Michael Allan Odhiambo.
 */
public class CardTest {

    private Card myCard = new Card( Suit.CLUBS, Rank.ACE );

    @Test
    public void testRank() {
        assertEquals( 11, myCard.getRank().getRank() );
    }
}
