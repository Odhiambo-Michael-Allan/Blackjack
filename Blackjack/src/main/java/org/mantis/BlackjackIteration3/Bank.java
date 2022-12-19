package org.mantis.BlackjackIteration3;


public class Bank {

    protected double balance;
    protected double bet;

    public Bank() {
        balance = 1000;
        bet = 0;
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

    public void win() {
        this.balance += bet*2;
        bet = 0;
    }

    public void lose() {
        bet = 0;
    }

    public void blackjack() {
        double profit = ( 3 / 2 ) * bet;
        balance += profit;
        bet = 0;
    }

    public void standOff() {
        balance += bet;
        bet = 0;
    }

    private void placeBet( double bet ) {
        this.bet = bet;
        balance -= bet;
    }

    public String toString() {
        return String.format( "$%.2f", balance );
    }
}
