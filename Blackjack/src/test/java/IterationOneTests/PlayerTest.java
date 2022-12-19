package IterationOneTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mantis.BlackjackIteration1.*;

/**
 * @Author Michael Allan Odhiambo.
 */

public class PlayerTest {

    private MockPlayer player;
    private Hand hand;
    private MockPlayerListener listener1;
    private MockPlayerListener listener2;
    private MockPlayerListener listener3;
    private MockPlayerListener listener4;
    private MockDealer dealer;

    private static final Card cardTen = new Card( Suit.HEARTS, Rank.TEN );
    private static final Card cardFive = new Card( Suit.HEARTS, Rank.FIVE );
    private static final Card cardTwo = new Card( Suit.HEARTS, Rank.TWO );

    @BeforeEach
    public void setUp() {
        hand = new Hand();
        player = new MockPlayer( "mp", hand );
        listener1 = new MockPlayerListener();
        listener2 = new MockPlayerListener();
        listener3 = new MockPlayerListener();
        listener4 = new MockPlayerListener();
        dealer = new MockDealer();
    }

    @Test
    public void testAddCard() {
        player.addCard( cardTen );
        Assertions.assertTrue( player.getHand().getTotal() == 10, "Card not added properly" );
        player.addCard( cardFive );
        Assertions.assertTrue( player.getHand().getTotal() == 15, "Card not added properly" );
        player.addCard( cardTwo );
        Assertions.assertTrue( player.getHand().getTotal() == 17, "Card not added properly" );
    }

    @Test
    public void testPlayerHit() {
        player.setHit( true );
        player.play( dealer );
        Assertions.assertTrue( dealer.wasHit(), "While playing the player should have hit" );
    }

    @Test
    public void testPlayerNoHit() {
        player.setHit( false );
        player.play( dealer );
        Assertions.assertTrue( !dealer.wasHit(), "While playing player should not have hit" );
    }

    @Test
    public void testPlayerIsBusted() {
        player.addCard( cardTen );
        Assertions.assertTrue( !player.isBusted(), "Player should not be busted" );
        player.addCard( cardFive );
        Assertions.assertTrue( !player.isBusted(), "Player should not be busted" );
        player.addCard( cardTen );
        Assertions.assertTrue( player.isBusted(), "Player should be busted" );
    }

    @Test
    public void testReset() {
        player.addCard( cardTen );
        player.addCard( cardFive );
        player.addCard( cardTen );
        player.reset();
        Assertions.assertTrue( !player.isBusted(), "After reset, player should not be busted" );
    }

    @Test
    public void testStopPlay() {
        player.stopPlay( dealer );
        Assertions.assertTrue( dealer.passedTurn(), "Stop play should call dealer.passTurn()" );
    }

    public void testNotifyListeners() {
        player.addListener( listener1 );
        player.addListener( listener2 );
        Assertions.assertTrue( !listener1.hasChanged(), "Listener was called in error" );
        Assertions.assertTrue( !listener2.hasChanged(), "Listener was called in error" );
        player.notifyListeners();
        Assertions.assertTrue( listener1.hasChanged(), "Listener was not called" );
        Assertions.assertTrue( listener2.hasChanged(), "Listener was not called" );
    }

    private class MockPlayer extends Player {
        private boolean hit;

        public MockPlayer( String name, Hand hand ) {
            super( name, hand );
        }

        public void setHit( boolean hit ) {
            this.hit = hit;
        }

        public void stopPlay( Dealer dealer ) {
            super.stopPlay( dealer );
        }

        public void notifyListeners() {
            super.notifyListeners();
        }

        public Hand getHand() {
            return super.getHand();
        }

        public boolean hit() {
            return this.hit;
        }
    }

    private class MockDealer implements Dealer {

        private boolean wasHit = false;
        private boolean passTurn = false;

        public boolean wasHit() {
            return wasHit;
        }

        public void hit( Player player ) {
            wasHit = true;
            player.addCard( cardTen );
        }

        public boolean passedTurn() {
            return passTurn;
        }

        public void passTurn() {
            passTurn = true;
        }
    }

    private class MockPlayerListener implements PlayerListener {
        private boolean changed;
        public void handChanged( Player player ) {
            changed = true;
        }

        public boolean hasChanged() {
            return changed;
        }
    }
}
