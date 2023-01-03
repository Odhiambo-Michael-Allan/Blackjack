package org.mantis.BlackjackIteration4;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;

/**
 * The OptionView contains all of the buttons available to the user. These buttons
 * allow the user to quit, start a new game, bet, hit and stand.
 * @Author Michael Allan Odhiambo.
 */

public class OptionView extends VBox {

    private Button bet10Button = new Button( "$10" );
    private Button bet50Button = new Button( "$50" );
    private Button bet100Button = new Button( "$100" );
    private Button newGameButton = new Button( "New Game" );
    private Button quitButton = new Button( "Quit" );
    private Button hitButton = new Button( "Hit" );
    private Button standButton = new Button( "Stand" );
    private BlackjackDealer dealer;
    private GUIPlayer player;

    public OptionView( GUIPlayer player, BlackjackDealer dealer ) {
        this.player = player;
        this.dealer = dealer;
        attachController( makeController() );
        buildGUI();
    }

    public void attachController( OptionViewController controller ) {
        newGameButton.setOnAction( event -> {
            controller.newGame();
        } );
        quitButton.setOnAction( event -> {
            controller.quit();
        } );
        hitButton.setOnAction( event -> {
            controller.hit();
        } );
        standButton.setOnAction( event -> {
            controller.stand();
        } );
        bet10Button.setOnAction( event -> {
            controller.bet10();
        } );
        bet50Button.setOnAction( event -> {
            controller.bet50();
        } );
        bet100Button.setOnAction( event -> {
            controller.bet100();
        } );
    }

    protected OptionViewController makeController() {
        return new OptionViewController( player, dealer, this );
    }

    private void buildGUI() {
        setSpacing( 10 );
        setPadding( new Insets( 10, 10, 10, 10 ) );
        HBox bettingControls = new HBox();
        bettingControls.setAlignment( Pos.CENTER );
        bettingControls.setSpacing( 10 );
        HBox gameControls = new HBox();
        gameControls.setAlignment( Pos.CENTER );
        gameControls.setSpacing( 10 );
        getChildren().add( bettingControls );
        getChildren().add( gameControls );
        bettingControls.getChildren().add( bet10Button );
        bettingControls.getChildren().add( bet50Button );
        bettingControls.getChildren().add( bet100Button );
        gameControls.getChildren().add( hitButton );
        gameControls.getChildren().add( standButton );
        gameControls.getChildren().add( quitButton );
        gameControls.getChildren().add( newGameButton );
        disableBettingControls( true );
        disablePlayerControls( true );
    }

    public void disableBettingControls( boolean disable ) {
        bet10Button.setDisable( disable );
        bet50Button.setDisable( disable );
        bet100Button.setDisable( disable );
    }

    public void disablePlayerControls( boolean disable ) {
        hitButton.setDisable( disable );
        standButton.setDisable( disable );
    }

    public void disableGameControls( boolean disable ) {
        newGameButton.setDisable( disable );
        quitButton.setDisable( disable );
    }

}
