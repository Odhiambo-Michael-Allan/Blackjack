package org.mantis.BlackjackIteration1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Dealer deals cards and directs the course of play. In the game of Blackjack, a dealer
 * is also a player.
 * @Author Michael Allan Odhiambo.
 */

public class BlackjackDealer extends Player implements Dealer {

    private DeckPile cards;
    private ArrayList<Player> players = new ArrayList<>();
    private int playerIndex;

    public BlackjackDealer( String name, Hand hand, DeckPile cards ) {
        super( name, hand );
        this.cards = cards;
    }

    @Override
    public void hit( Player player ) {
        player.addCard( cards.dealUp() );
    }

    @Override
    public void passTurn() {
        if ( playerIndex != players.size() ) {
            Player player = players.get( playerIndex );
            playerIndex++;
            player.play( this );
        } else
            this.play( this );
    }

    // Override so that the dealer shows his cards before he starts play..
    @Override
    public void play( Dealer dealer ) {
        exposeCards();
        super.play( dealer );
    }

    private void exposeCards() {
        this.getHand().turnOver();
        notifyListeners();
    }

    @Override
    protected boolean hit() {
        if ( this.getHand().getTotal() <= 16 )
            return true;
        return false;
    }

    public void addPlayer( Player player ) {
        players.add( player );
    }

    public void newGame() {
        deal();
        passTurn();
    }

    public void deal() {
        cards.shuffle();
        // Reset each player and deal one card up to each and self..
        Player[] playerArray = new Player[ players.size() ];
        players.toArray( playerArray );
        for ( int i = 0; i < playerArray.length; i++ ) {
            playerArray[i].reset();
            playerArray[i].addCard( cards.dealUp() );
        }
        this.addCard( cards.dealUp() );
        // Deal one more card to each player and one down to self..
        for ( int i = 0; i < playerArray.length; i++ )
            playerArray[i].addCard( cards.dealUp() );
        this.addCard( cards.dealDown() );
    }

    protected void stopPlay( Dealer dealer ) {
        /**
         * Do nothing here in the dealer, simply let the game stop. If this were not overridden, it would
         * call passTurn() and loop forever..
         */
    }
}
