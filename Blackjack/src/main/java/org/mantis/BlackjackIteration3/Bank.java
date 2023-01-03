package org.mantis.BlackjackIteration3;

/**
 * This is a simple implementation of a betting bank. This bank also has an unlimited
 * credit line. You can bet yourself into oblivion. - Lucky You :)
 * @Author Michael Allan Odhiambo.
 */
public class Bank {

    private int total;
    private int bet;

    public Bank( int amount ) {
        total = amount;
    }

    public void place100Bet() {
        placeBet( 100 );
    }

    public void place50Bet() {
        placeBet( 50 );
    }

    public void place10Bet() {
        placeBet( 10 );
    }

    private void placeBet( int bet ) {
        this.bet = bet;
        this.total -= bet;
    }

    public void win() {
        total += ( 2 * this.bet );
        this.bet = 0;
    }

    public void lose() {
        this.bet = 0;
    }

    public void blackjack() {
        this.total += ( ( ( 3 * this.bet ) / 2 ) + bet );
        this.bet = 0;
    }

    public void standoff() {
        this.total += this.bet;
        this.bet = 0;
    }

    public String toString() {
        return ( "$" + this.total + ".00" );
    }
}
