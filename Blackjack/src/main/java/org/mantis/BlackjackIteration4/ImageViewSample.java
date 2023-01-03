package org.mantis.BlackjackIteration4;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageViewSample extends Application {

    @Override
    public void start( Stage stage ) {
        Image image = new Image( "CardImages/SevenOfDiamonds.png" );
        ImageView imageView1 = new ImageView();
        imageView1.setImage( image );

        Group root = new Group();
        Scene scene = new Scene( root );
        scene.setFill( Color.BLACK );

        VCard card = new VCard( Suit.HEARTS, Rank.ACE, "CardImages/AceOfHearts.png" );
        card.setFaceUp( true );
        ImageView imageView2 = new CardView( card );
        Player humanPlayer = new HumanPlayer( "Michael", new Hand(), new Bank( 1000 ) );

        PlayerView playerView = new PlayerView( humanPlayer );


        HBox box = new HBox();
        box.getChildren().add( imageView1 );
        box.getChildren().add( imageView2 );
        root.getChildren().add( box );

        stage.setTitle( "ImageView" );
        stage.setWidth( 415 );
        stage.setHeight( 200 );
        stage.setScene( scene );
        stage.sizeToScene();
        stage.show();
    }

    public static void main( String[] args ) {
        Application.launch( args );
    }
}
