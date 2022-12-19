package IterationThreeTests;

import org.mantis.BlackjackIteration3.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class PlayerTest {

    private static final Card ace = new Card( Suit.CLUBS, Rank.ACE );
    private static final Card cardTwo = new Card( Suit.CLUBS, Rank.TWO );
    private static final Card cardThree = new Card( Suit.CLUBS, Rank.THREE );
    private static final Card cardSeven = new Card( Suit.CLUBS, Rank.SEVEN );
    private static final Card jack = new Card( Suit.CLUBS, Rank.JACK );
    private static final Card cardFive = new Card( Suit.CLUBS, Rank.FIVE );
    private static final Card cardSix = new Card( Suit.CLUBS, Rank.SIX );
    public TestPlayer player;
    public MockDealer dealer;
    public Hand playerHand, dealerHand;
    public DeckPile pile;

    @BeforeEach
    public void setup() {
        playerHand = new Hand();
        dealerHand = new Hand();
        pile = new DeckPile();
        player = new TestPlayer( "Test Player", playerHand );
        dealer = new MockDealer( "Mock Dealer", dealerHand, pile );
    }

    @Test
    public void testAddCard() {
        player.addCard( ace );
        Assertions.assertTrue( player.getHand().getTotal() == 11, "Card not added properly" );
        player.addCard( jack );
        Assertions.assertTrue( player.getHand().getTotal() == 21, "Card not added properly" );
    }

    @Test
    public void testWaitingState() {
        player.addCard( cardSeven );
        player.play( dealer );
        Assertions.assertTrue( !dealer.wasHit(), "Dealer should not have been hit since player is still " +
                "in waiting state" );
    }

    @Test
    public void testPlayingState() {
        player.addCard( cardSeven );
        player.addCard( ace );
        player.setHit( true );
        player.play( dealer );
        Assertions.assertTrue( dealer.wasHit(), "Dealer should have been hit since the player is in the " +
                "playing state" );
    }

    @Test
    public void testBustedState() {
        player.addCard( cardFive );
        player.addCard( jack );
        player.setHit( true );
        player.play( dealer );
        Assertions.assertTrue( dealer.isBusted(), "Player should have busted" );
    }

    @Test
    public void testStandingState() {
        player.addCard( cardSeven );
        player.addCard( cardSix );
        player.setHit( false );
        player.play( dealer );
        Assertions.assertTrue( dealer.playerStanding(), "Player should have stood" );
    }

    @Test
    public void testBlackjackState() {
        player.addCard( jack );
        player.addCard( ace );
        Assertions.assertTrue( player.getHand().isBlackjack(), "Hand should have a blackjack" );
        player.setHit( true );
        player.play( dealer );
        Assertions.assertTrue( dealer.playerHasBlackjack(), "Player should have a blackjack" );
    }

    private class TestPlayer extends Player {

        private boolean hit;
        public TestPlayer( String name, Hand hand ) {
            super( name, hand );
        }

        public void setHit( boolean hit ) {
            this.hit = hit;
        }

        @Override
        protected boolean hit() {
            return this.hit;
        }
    }

    private class MockDealer extends BlackjackDealer  {
        private boolean hit, busted, standing, blackjack;

        public MockDealer( String name, Hand hand, DeckPile pile ) {
            super( name, hand, pile );
        }

        @Override
        public void hit( Player player ) {
            setHit( true );
            player.addCard( cardSeven );
        }

        @Override
        public void standing( Player player ) {
            standing = true;
        }

        @Override
        public void blackjack( Player player ) {
            blackjack = true;
        }

        public boolean playerHasBlackjack() {
            return blackjack;
        }

        public boolean playerStanding() {
            return standing;
        }

        public void setHit( boolean hit ) {
            this.hit = hit;
        }

        public boolean wasHit() {
            return this.hit;
        }

        @Override
        public void busted( Player player ) {
            busted = true;
        }

        public boolean isBusted() {
            return busted;
        }
    }

    private class MockPlayerListener implements PlayerListener {
        private boolean won;

        @Override
        public void playerChanged( Player player ) {

        }

        @Override
        public void playerBusted(Player player) {

        }

        @Override
        public void playerBlackjack(Player player) {

        }

        @Override
        public void playerStanding(Player player) {

        }

        @Override
        public void playerWon( Player player ) {
            won = true;
        }

        @Override
        public void playerLost(Player player) {

        }

        @Override
        public void playerStandoff(Player player) {

        }

        public boolean hasWon() {
            return won;
        }
    }
}
