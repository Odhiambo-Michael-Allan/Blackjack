package org.mantis.BlackjackIteration1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is the abstract base class for Blackjack players. A player holds a hand, adds cards to the
 * hand, knows how to play, provides state information and provides listener support.
 *
 * @Author Michael Allan Odhiambo.
 */
public abstract class Player {

    private Hand hand;
    private String name;
    private ArrayList<PlayerListener> listeners = new ArrayList<>();

    public Player( String name, Hand hand ) {
        this.name = name;
        this.hand = hand;
    }

    public void addCard( Card card ) {
        hand.addCard( card );
        notifyListeners();
    }

    public void play( Dealer dealer ) {
        // Play until the player either busts or stays.
        while ( !isBusted() && hit() ) {
            dealer.hit( this );
        }
        // Now tell the dealer that the player is done, otherwise nothing will happen.
        stopPlay( dealer );
    }

    public boolean isBusted() {
        return this.hand.bust();
    }

    /**
     * Each concrete player will provide an implementation for this method. Not all player types hit the
     * same way..
     * @return
     */
    protected abstract boolean hit();

    /**
     * The call to passTurn MUST be inside of a protected method. The Dealer needs to override this behavior!
     * Otherwise it will loop forever..
     */
    protected void stopPlay( Dealer dealer ) {
        dealer.passTurn();
    }

    protected void notifyListeners() {
        Iterator i = listeners.iterator();
        while ( i.hasNext() ) {
            PlayerListener playerListener = ( PlayerListener ) i.next();
            playerListener.handChanged( this );
        }
    }

    public String toString() {
        return String.format( "%s: %s", this.name, getHand().toString() );
    }

    protected Hand getHand() {
        return this.hand;
    }

    public void addListener( PlayerListener listener ) {
        listeners.add( listener );
    }

    public void reset() {
        hand.reset();
    }
}
