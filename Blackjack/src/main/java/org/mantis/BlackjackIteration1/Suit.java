package org.mantis.BlackjackIteration1;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

/**
 * The Suit class defines the valid card suits.
 * @author Michael Allan Odhiambo
 */
public class Suit {

    public static final Suit DIAMONDS = new Suit( ( char ) 4 );
    public static final Suit HEARTS = new Suit( ( char ) 3 );
    public static final Suit SPADES = new Suit( ( char ) 6 );
    public static final Suit CLUBS = new Suit( ( char ) 5 );

    private static final Suit[] VALUES = { DIAMONDS, HEARTS, SPADES, CLUBS };
    public static final List SUITS = Collections.unmodifiableList( Arrays.asList( VALUES ) );
    private final char displayValue;

    // Do not allow instantiation by outside objects.
    private Suit( char displayValue ) {
        this.displayValue = displayValue;
    }

    public String toString() {
        return String.valueOf( displayValue );
    }
}
