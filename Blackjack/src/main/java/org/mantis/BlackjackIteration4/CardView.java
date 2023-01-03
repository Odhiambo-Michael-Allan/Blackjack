package org.mantis.BlackjackIteration4;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The CardView visualizes VCards. This is purely a visual view. It does not
 * allow interaction, thus their is no controller.
 * @Author Michael Allan Odhiambo.
 */

public class CardView extends ImageView {

    private Image image;

    public CardView( VCard card ) {
        getImageUrl( card.getImageUrl() );
        setImage( image );
        setFitWidth( 100 );
        setFitHeight( 150 );
    }

    private void getImageUrl( String imageUrl ) {
        image = new Image( imageUrl );
    }
}
