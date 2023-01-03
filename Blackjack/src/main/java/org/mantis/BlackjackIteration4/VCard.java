package org.mantis.BlackjackIteration4;

/**
 * The VCard holds onto an extra String attribute. This string references
 * an image file.
 * @Author Michael Allan Odhiambo.
 */

public class VCard extends Card {

    private String imageUrl;

    public VCard( Suit suit, Rank rank, String imageUrl ) {
        super( suit, rank );
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        if ( isFaceUp() )
            return imageUrl;
        return "CardImages/faceDownCard.png";
    }
}
