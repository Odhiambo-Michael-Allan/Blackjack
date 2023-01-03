package org.mantis.BlackjackIteration4;

import org.mantis.BlackjackIteration4.NotificationListeners.*;

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
    private PlayerState currentState;

    public Player( String name, Hand hand ) {
        this.name = name;
        this.hand = hand;
        setCurrentState( getInitialState() );
    }

    protected final void setCurrentState( PlayerState currentState ) {
        this.currentState = currentState;
        this.hand.setHolder( this.currentState );
    }

    protected final PlayerState getCurrentState() {
        return this.currentState;
    }

    protected PlayerState getInitialState() {
        return new WaitingState();
    }

    public void addCard( Card card ) {
        this.hand.addCard( card );
    }

    public void play( Dealer dealer ) {
        currentState.execute( dealer );
    }

    public void reset() {
        this.hand.reset();
        setCurrentState( getInitialState() );
    }

    public void addListener( PlayerListener listener ) {
        listeners.add( listener );
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return ( getName() + ": " + hand.toString() );
    }

    public void win() {
        notifyListeners( new NotifyWonHelper() );
    }

    public void lose() {
        notifyListeners( new NotifyLostHelper() );
    }

    public void standoff() {
        notifyListeners( new NotifyStandOffHelper() );
    }

    public void blackjack() {
        notifyListeners( new NotifyBlackjackHelper() );
    }

    protected Hand getHand() {
        return hand;
    }

    protected void notifyListeners( NotificationHelper notificationHelper ) {
        Iterator i = listeners.iterator();
        while ( i.hasNext() ) {
            PlayerListener playerListener = ( PlayerListener ) i.next();
            notificationHelper.notifyListener( playerListener , this );
        }
    }

    protected abstract boolean hit();

    private class WaitingState implements PlayerState {

        @Override
        public void handPlayable() {
            // Transition..
            setCurrentState( getPlayingState() );
        }

        @Override
        public void handBlackjack() {
            // Transition..
            setCurrentState( getBlackjackState() );
            notifyListeners( new NotifyBlackjackHelper() );
        }

        @Override
        public void handBusted() {
            // Not possible in waiting state..
        }

        @Override
        public void handChanged() {
            notifyListeners( new NotifyChangedHelper() );
        }

        @Override
        public void execute( Dealer dealer ) {
            // Do nothing in waiting state..
        }
    }

    private class BustedState implements PlayerState {

        @Override
        public void handPlayable() {
            // Not possible in busted state..
        }

        @Override
        public void handBlackjack() {
            // Not possible in busted state..
        }

        @Override
        public void handBusted() {
            // Not possible in busted state..
        }

        @Override
        public void handChanged() {
            // Not possible in busted state..
        }

        @Override
        public void execute( Dealer dealer ) {
            dealer.busted( Player.this );
        }
    }

    private class BlackjackState implements PlayerState {

        @Override
        public void handPlayable() {
            // Not possible in blackjack state..
        }

        @Override
        public void handBlackjack() {
            // Not possible in blackjack state..
        }

        @Override
        public void handBusted() {
            // Not possible in blackjack state..
        }

        @Override
        public void handChanged() {
            // Not possible in blackjack state..
        }

        @Override
        public void execute( Dealer dealer ) {
            dealer.blackjack( Player.this );
        }
    }

    private class StandingState implements PlayerState {

        @Override
        public void handPlayable() {
            // Not possible in standing state..
        }

        @Override
        public void handBlackjack() {
            // Not possible in standing state..
        }

        @Override
        public void handBusted() {
            // Not possible in standing state..
        }

        @Override
        public void handChanged() {
            // Not possible in standing state..
        }

        @Override
        public void execute( Dealer dealer ) {
            dealer.standing( Player.this );
        }
    }

    private class PlayingState implements PlayerState {

        @Override
        public void handPlayable() {
            // Not possible in playing state..
        }

        @Override
        public void handBlackjack() {
            // Not possible in playing state..
        }

        @Override
        public void handBusted() {
            setCurrentState( getBustedState() );
            notifyListeners( new NotifyBustedHelper() );
        }

        @Override
        public void handChanged() {
            notifyListeners( new NotifyChangedHelper() );
        }

        @Override
        public void execute( Dealer dealer ) {
            if ( hit() )
                dealer.hit( Player.this );
            else {
                setCurrentState( getStandingState() );
                notifyListeners( new NotifyStandingHelper() );
            }
            currentState.execute( dealer );
        }
    }

    protected PlayerState getPlayingState() {
        return new PlayingState();
    }

    protected PlayerState getBlackjackState() {
        return new BlackjackState();
    }

    protected PlayerState getStandingState() {
        return new StandingState();
    }

    protected PlayerState getWaitingState() {
        return new WaitingState();
    }

    protected PlayerState getBustedState() {
        return new BustedState();
    }
}
