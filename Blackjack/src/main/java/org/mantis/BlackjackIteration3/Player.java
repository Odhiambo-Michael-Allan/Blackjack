package org.mantis.BlackjackIteration3;

public abstract class Player {

    private String name;
    private Hand hand;
    private PlayerState currentState;


    public Player( String name, Hand hand ) {
        this.name = name;
        this.hand = hand;
        setCurrentState( getInitialState() );
    }

    private void setCurrentState( PlayerState currentState ) {
        this.currentState = currentState;
        this.hand.setHolder( this.currentState );
    }

    protected PlayerState getInitialState() {
        return new WaitingState();
    }

    public void play( Dealer dealer ) {
        getCurrentState().execute( dealer );
    }

    public void addCard( Card card ) {
        this.hand.addCard( card );
    }

    public Hand getHand() {
        return this.hand;
    }

    private PlayerState getCurrentState() {
        return this.currentState;
    }

    protected PlayerState getPlayingState() {
        return new PlayingState();
    }

    protected PlayerState getStandingState() {
        return new StandingState();
    }

    protected PlayerState getBustedState() {
        return new BustedState();
    }

    protected PlayerState getBlackjackState() {
        return new BlackjackState();
    }

    protected abstract boolean hit();

    private class WaitingState implements PlayerState {

        @Override
        public void handChanged() {
        }

        @Override
        public void handPlayable() {
            setCurrentState( getPlayingState() );
        }

        @Override
        public void handBlackjack() {
            setCurrentState( getBlackjackState() );
        }

        @Override
        public void handBusted() {
            // Not possible in waiting state..
        }

        @Override
        public void execute( Dealer dealer ) {
            // Do nothing in the waiting state
        }
    }

    private class PlayingState implements PlayerState {

        @Override
        public void handChanged() {

        }

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
        }

        @Override
        public void execute( Dealer dealer ) {
            if ( hit() )
                dealer.hit( Player.this );
            else {
                // The player is standing..
                setCurrentState(getStandingState());
            }
            getCurrentState().execute( dealer );
        }
    }

    private class StandingState implements PlayerState {

        @Override
        public void handChanged() {

        }

        @Override
        public void handPlayable() {

        }

        @Override
        public void handBlackjack() {

        }

        @Override
        public void handBusted() {

        }

        @Override
        public void execute( Dealer dealer ) {
            dealer.standing( Player.this );
        }
    }

    private class BustedState implements PlayerState {

        @Override
        public void handChanged() {

        }

        @Override
        public void handPlayable() {

        }

        @Override
        public void handBlackjack() {

        }

        @Override
        public void handBusted() {

        }

        @Override
        public void execute(Dealer dealer) {
            dealer.busted( Player.this );
        }
    }

    private class BlackjackState implements PlayerState {

        @Override
        public void handChanged() {

        }

        @Override
        public void handPlayable() {

        }

        @Override
        public void handBlackjack() {

        }

        @Override
        public void handBusted() {

        }

        @Override
        public void execute( Dealer dealer ) {
            dealer.blackjack( Player.this );
        }
    }

}
