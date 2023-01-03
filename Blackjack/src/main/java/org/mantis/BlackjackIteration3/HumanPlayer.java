package org.mantis.BlackjackIteration3;

/**
 * The HumanPlayer determines whether or not to hit based on input from the command line.
 * The details of when to hit and when not to hit is encapsulated within the entity
 * entering data on the command line.
 * @Author Michael Allan Odhiambo.
 */

public class HumanPlayer extends BettingPlayer {

    private static final String HIT = "H";
    private static final String STAND = "S";
    private static final String MESSAGE = "[H]it or [S]tand";
    private final static String BET_MESSAGE = "Place Bet: [10] [50] or [100]";
    private final static String BET_10  = "10";
    private final static String BET_50  = "50";
    private final static String BET_100 = "100";
    private static final String DEFAULT = "invalid";

    public HumanPlayer( String name, Hand hand, Bank bank ) {
        super( name, hand, bank );
    }
    @Override
    protected boolean hit() {
        while ( true ) {
            Console.INSTANCE.printMessage( MESSAGE );
            String response = Console.INSTANCE.readInput( DEFAULT );
            if ( response.equalsIgnoreCase( HIT ) )
                return true;
            else if ( response.equalsIgnoreCase( STAND ) )
                return false;
            // If we get here, loop until we get meaningful input..
        }
    }

    @Override
    protected void bet() {
        while ( true ) {
            Console.INSTANCE.printMessage( BET_MESSAGE );
            String response = Console.INSTANCE.readInput( DEFAULT );
            if ( response.equals( BET_10 ) ) {
                getBank().place10Bet();
                return;
            }
            if ( response.equals( BET_50 ) ) {
                getBank().place50Bet();
                return;
            }
            if ( response.equals( BET_100 ) ) {
                getBank().place100Bet();
                return;
            }
            // If we get here, loop until we get meaningful input.

        }
    }


}
