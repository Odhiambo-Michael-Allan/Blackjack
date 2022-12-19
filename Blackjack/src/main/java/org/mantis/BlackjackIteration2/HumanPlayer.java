package org.mantis.BlackjackIteration2;

/**
 * The HumanPlayer determines whether or not to hit based on input from the command line.
 * The details of when to hit and when not to hit is encapsulated within the entity
 * entering data on the command line.
 * @Author Michael Allan Odhiambo.
 */

public class HumanPlayer extends Player {

    private static final String HIT = "H";
    private static final String STAND = "S";
    private static final String MESSAGE = "[H]it or [S]tand";
    private static final String DEFAULT = "invalid";

    public HumanPlayer( String name, Hand hand ) {
        super( name, hand );
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
}
