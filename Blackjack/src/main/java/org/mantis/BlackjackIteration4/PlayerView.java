package org.mantis.BlackjackIteration4;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.util.Iterator;


/**
 * The PlayerView knows how to represent a player. This is purely a visual view. It does not allow
 * interaction, thus there is no controller.
 * @Author Michael Allan Odhiambo.
 */

public class PlayerView extends BorderPane implements PlayerListener {

    private HBox cards;
    private TextArea playerStatistics;

    public PlayerView( Player player ) {
        buildUI( player );
        player.addListener( this );
    }

    private void buildUI( Player player ) {
        cards = new HBox();
        cards.setSpacing( 15 );
        cards.setPadding( new Insets( 10, 10, 10, 10 ) );
        cards.setPrefSize( 500, 200 );
        setCenter( cards );
        playerStatistics = new TextArea();
        playerStatistics.setPrefRowCount( 1 );
        setTop( playerStatistics );
        playerStatistics.setEditable( false );
        playerStatistics.setText( player.toString() );
    }

    @Override
    public void playerChanged( Player player ) {
        playerStatistics.setText( String.format( "%s", player.toString() ) );
        cards.getChildren().clear();
        Hand hand = player.getHand();
        Iterator i = hand.iterator();
        while ( i.hasNext() ) {
            VCard vcard = ( VCard ) i.next();
            ImageView cardView = new CardView( vcard );
            cards.getChildren().add( cardView );
        }
    }

    @Override
    public void playerBusted( Player player ) {
        playerStatistics.setText( player.toString() + "\n" + "BUSTED!" + "\n" );
    }

    @Override
    public void playerBlackjack( Player player ) {
        playerStatistics.setText( player.toString() + "\n" + "BLACKJACK!" );
    }

    @Override
    public void playerStanding( Player player ) {
        playerStatistics.setText( player.toString() + "\n" + "STANDING" );
    }

    @Override
    public void playerWon( Player player ) {
        playerStatistics.setText( player.toString() + "\n" + "WINNER!!" );
    }

    @Override
    public void playerLost( Player player ) {
        playerStatistics.setText( player.toString() + "\n" + "LOSER!!" );
    }

    @Override
    public void playerStandOff( Player player ) {
        playerStatistics.setText( player.getName() + "\n" + " STANDOFF!!" );
    }
}
