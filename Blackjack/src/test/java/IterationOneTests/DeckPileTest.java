package IterationOneTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mantis.BlackjackIteration1.Card;
import org.mantis.BlackjackIteration1.Deck;
import org.mantis.BlackjackIteration1.DeckPile;

/**
 * @Author Michael Allan Odhiambo.
 */
public class DeckPileTest {

    private Deck deck = new Deck();
    private DeckPile pile = new DeckPile();

    @BeforeEach
    public void setup() {
        deck = new Deck();
        deck.addToStack( pile );
    }

    @Test
    public void testShuffle() {
        Card card = pile.dealUp();
        pile.reset();
        pile.shuffle();
        Assertions.assertTrue( card != pile.dealUp(), "After shuffle, the first" +
                " card should be random" );
    }

    @Test
    public void testReset() {
        Card card = pile.dealUp();
        pile.reset();
        Assertions.assertTrue( card == pile.dealUp(), "A reset with no shuffle should return the deck" +
                " to its original status." );
    }

    @Test
    public void testAddToStack() {
        deck.addToStack( pile );
        // The pile should now contain 104 cards..
        for ( int i = 0; i < 104; i++ )
            Assertions.assertTrue( pile.dealDown() != null, "Card should not be null." );
    }

    @Test
    public void testDealUp() {
        Card card = pile.dealUp();
        Assertions.assertTrue( card.isFaceUp(), "Card dealt up should be face up." );
    }

    @Test
    public void testDealDown() {
        Card card = pile.dealDown();
        Assertions.assertTrue( !card.isFaceUp(), "Card deal down should be face down." );
    }
}
