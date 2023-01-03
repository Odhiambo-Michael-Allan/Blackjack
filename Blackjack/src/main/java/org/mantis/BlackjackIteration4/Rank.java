package org.mantis.BlackjackIteration4;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

/**
 * The Rank class defines all the valid Ranks in the game of Blackjack.
 * @author Michael Allan Odhiambo.
 */
public class Rank {

    public static final Rank TWO = new Rank( 2, "2" );
    public static final Rank THREE = new Rank( 3, "3" );
    public static final Rank FOUR = new Rank( 4, "4" );
    public static final Rank FIVE = new Rank( 5, "5" );
    public static final Rank SIX = new Rank( 6, "6" );
    public static final Rank SEVEN = new Rank( 7, "7" );
    public static final Rank EIGHT = new Rank( 8, "8" );
    public static final Rank NINE = new Rank( 9, "9" );
    public static final Rank TEN = new Rank( 10, "10" );
    public static final Rank KING = new Rank( 10, "K" );
    public static final Rank QUEEN = new Rank( 10, "Q" );
    public static final Rank JACK = new Rank( 10, "J" );
    public static final Rank ACE = new Rank( 11, "A" );

    private static final Rank[] VALUES = { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
            KING, QUEEN, JACK, ACE };
    public static final List<Rank> RANKS = Collections.unmodifiableList( Arrays.asList( VALUES ) );
    private final int rank;
    private final String displayValue;

    private Rank( int rank, String displayValue ) {
        this.rank = rank;
        this.displayValue = displayValue;
    }

    public int getRank() {
        return this.rank;
    }

    public String toString() {
        return displayValue;
    }

}
