package IterationOneTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mantis.BlackjackIteration1.Card;
import org.mantis.BlackjackIteration1.Deck;
import org.mantis.BlackjackIteration1.DeckPile;

/**
 * @Author Michael Allan Odhiambo.
 */
public class DeckTest {

    private static final DeckPile pile = new MockPile();
    private Deck deck = new Deck();

    @Test
    public void testDeck() {
        deck.addToStack( pile );
    }


    private static class MockPile extends DeckPile {

        public void addCards( Card[] cards ) {
            Assertions.assertTrue( cards.length == 52, "The pile should" +
                    " have been passed 52 cards" );
            for ( int i = 0; i < 52; i++ )
                Assertions.assertTrue( cards[i] != null, "Card should not be null." );
        }
    }

}
