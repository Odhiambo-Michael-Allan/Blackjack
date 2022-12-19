package org.mantis.BlackjackIteration1;

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

    public void handChanged( Player player ) {
        printMessage( player.toString() );
    }
}
