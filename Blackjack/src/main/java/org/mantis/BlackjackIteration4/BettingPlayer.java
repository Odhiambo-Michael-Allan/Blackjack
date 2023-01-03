package org.mantis.BlackjackIteration4;

/**
 * This is the abstract BettingPlayer class. All players that bet should inherit from this player type. This
 * player type adds support for betting.
 * @Author Michael Allan Odhiambo
 */
public abstract class BettingPlayer extends Player {

    private Bank bank;

    public BettingPlayer( String name, Hand hand, Bank bank ) {
        super( name, hand );
        this.bank = bank;
    }

    @Override
    protected boolean hit() {
        return false;
    }

    @Override
    public String toString() {
        return ( getName() + "" + "\n" + bank.toString() );
    }

    @Override
    public void win() {
        bank.win();
        super.win();
    }

    @Override
    public void lose() {
        bank.lose();
        super.lose();
    }

    @Override
    public void standoff() {
        bank.standoff();
        super.standoff();
    }

    @Override
    public void blackjack() {
        bank.blackjack();
        super.blackjack();
    }

    @Override
    protected PlayerState getInitialState() {
        return getBettingState();
    }

    protected PlayerState getBettingState() {
        return new BettingState();
    }

    protected final Bank getBank() {
        return this.bank;
    }

    protected abstract void bet();

    private class BettingState implements PlayerState {

        @Override
        public void handPlayable() {
            // Not possible in betting state.
        }

        @Override
        public void handBlackjack() {
            // Not possible in betting state.
        }

        @Override
        public void handBusted() {
            // Not possible in betting state.
        }

        @Override
        public void handChanged() {
            // Not possible in betting state.
        }

        @Override
        public void execute( Dealer dealer ) {
            bet();
            setCurrentState( getWaitingState() );
            dealer.doneBetting( BettingPlayer.this );
        }
    }


}
