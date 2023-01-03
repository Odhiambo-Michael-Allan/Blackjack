package org.mantis.BlackjackIteration3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * The Console singleton provides access to the command line.
 * @Author Michael Allan Odhiambo.
 */
public class Console implements PlayerListener {

    public static final Console INSTANCE = new Console();
    private BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );

    private Console() {}

    public void printMessage( String message ) {
        System.out.println( message );
    }

    public String readInput( String defaultValue ) {
        try {
            return in.readLine();
        } catch ( IOException e ) {
            return defaultValue;
        }
    }

    @Override
    public void playerChanged( Player player ) {
        printMessage( player.toString() );
    }

    @Override
    public void playerBusted( Player player ) {
        printMessage( player.toString() + " BUSTED!" );
    }

    @Override
    public void playerBlackjack( Player player ) {
        printMessage( player.toString() + " BLACKJACK!!" );
    }

    @Override
    public void playerStanding( Player player ) {
        printMessage( player.toString() + " STANDING!" );
    }

    @Override
    public void playerWon( Player player ) {
        printMessage( player.toString() + " WINNER!!" );
    }

    @Override
    public void playerLost( Player player ) {
        printMessage( player.toString() + " LOSER!" );
    }

    @Override
    public void playerStandOff( Player player ) {
        printMessage( player.toString() + " STANDOFF!" );
    }
}
