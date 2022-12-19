package org.mantis.BlackjackIteration1;

/**
 * This is the class representation of a card.
 * @author Michael Allan Odhiambo.
 */
public class Card {

    private Suit suit;
    private Rank rank;
    private boolean faceUp;

    public Card( Suit suit, Rank rank ) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public void setFaceUp( boolean faceUp ) {
        this.faceUp = faceUp;
    }

    public boolean isFaceUp() {
        return this.faceUp;
    }

    public String toString() {
        if ( !this.isFaceUp() )
            return "Hidden";
        return rank.toString() + suit.toString();
    }
}
