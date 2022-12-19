package IterationTwoTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import org.mantis.BlackjackIteration2.*;

public class PlayerTest {

    public Player player;
    private Hand hand;
    private static final Card ace = new Card( Suit.HEARTS, Rank.ACE );
    private static final Card cardTen = new Card( Suit.HEARTS, Rank.TEN );
    private static final Card cardFive = new Card( Suit.HEARTS, Rank.FIVE );
    private static final Card cardTwo = new Card( Suit.HEARTS, Rank.TWO );

    @BeforeEach
    public void setup() {
        hand = new Hand();
    }
}
