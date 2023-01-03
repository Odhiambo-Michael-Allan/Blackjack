package org.mantis.BlackjackIteration4;

import org.mantis.BlackjackIteration4.NotificationListeners.*;

/**
 * The GUIPlayer represents the human player in the GUI version of the game. The GUIPlayer needs to provide
 * custom Betting and Playing states because the GUIPlayer needs to wait for the user to press a button.
 * @Author Michael Allan Odhiambo.
 */

public class GUIPlayer extends BettingPlayer {

    private Dealer dealer;

    public GUIPlayer( String name, Hand hand, Bank bank ) {
        super( name, hand, bank );
    }

    @Override
    public boolean hit() {
        return true;
    }

    @Override
    protected void bet() {
        // Do nothing. This won't be called instead, the human player
        // presses a GUI button.
    }

    public void play( Dealer dealer ) {
        this.dealer = dealer;
        super.play( dealer );
    }

    public void place10Bet() {
        getBank().place10Bet();
        setCurrentState( getWaitingState() );
        dealer.doneBetting( this );
    }

    public void place50Bet() {
        getBank().place50Bet();
        setCurrentState( getWaitingState() );
        dealer.doneBetting( this );
    }

    public void place100Bet() {
        getBank().place100Bet();
        setCurrentState( getWaitingState() );
        dealer.doneBetting( this );
    }

    public void takeCard() {
        dealer.hit( this );
    }

    public void stand() {
        setCurrentState( getStandingState() );
        notifyListeners( new NotifyStandingHelper() );
        getCurrentState().execute( dealer );
    }

    protected PlayerState getPlayingState() {
        return new PlayingState();
    }

    protected PlayerState getBettingState() {
        return new BettingState();
    }

    private class PlayingState implements PlayerState {

        @Override
        public void handPlayable() {

        }

        @Override
        public void handBlackjack() {
            setCurrentState( getBlackjackState() );
            notifyListeners( new NotifyBlackjackHelper() );
            getCurrentState().execute( dealer );
        }

        @Override
        public void handBusted() {
            setCurrentState( getBustedState() );
            notifyListeners( new NotifyBustedHelper() );
            getCurrentState().execute( dealer );
        }

        @Override
        public void handChanged() {
            notifyListeners( new NotifyChangedHelper() );
        }

        @Override
        public void execute( Dealer dealer ) {
            // Do nothing here. Actions will come from the GUI which is external to the state,
            // but when events do come in, be sure to force state transition right away..
        }
    }

    private class BettingState implements PlayerState {
        public void handChanged() {
            // not possible in betting state
        }
        public void handPlayable() {
            // not possible in betting state
        }
        public void handBlackjack() {
            // not possible in betting state
        }
        public void handBusted() {
            // not possible in betting state
        }
        public void execute( Dealer dealer ) {
            // do nothing here, actions will come from the GUI which is
            // external to the state, since no events come in as part of
            // betting the state will need to be changed externally to this state
        }
    }
}
