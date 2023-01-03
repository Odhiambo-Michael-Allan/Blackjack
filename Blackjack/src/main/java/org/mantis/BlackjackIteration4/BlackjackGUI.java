package org.mantis.BlackjackIteration4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BlackjackGUI extends Application {

    private BlackjackDealer dealer;
    private GUIPlayer humanPlayer;

    @Override
    public void start( Stage stage ) {
        PlayerView dealerView = getPlayerView( getDealer() );
        humanPlayer = new GUIPlayer( "Michael", new Hand(), new Bank( 100000 ) );
        dealer.addPlayer( humanPlayer );
        PlayerView humanPlayerView = getPlayerView( humanPlayer );
        VBox playerViews = new VBox();
        playerViews.getChildren().add( dealerView );
        playerViews.getChildren().add( humanPlayerView );
        playerViews.getChildren().add( getOptionView( humanPlayer, dealer ) );
        stage.setScene( new Scene( playerViews ) );
        stage.setResizable( false );
        stage.setWidth( 600 );
        stage.setHeight( 600 );
        stage.setTitle( "Blackjack" );
        stage.show();
    }

    private BlackjackDealer getDealer() {
        if ( dealer == null ) {
            Hand dealerHand = new Hand();
            DeckPile cards = getCards();
            dealer = new BlackjackDealer( "Dealer", dealerHand, cards );
        }
        return dealer;
    }

    private DeckPile getCards() {
        DeckPile cards = new DeckPile();
        for ( int i = 0; i < 4; i++ ) {
            cards.shuffle();
            Deck deck = new VDeck();
            deck.addToStack( cards );
            cards.shuffle();
        }
        return cards;
    }

    private PlayerView getPlayerView( Player player ) {
        PlayerView view = new PlayerView( player );
        return view;
    }

    private OptionView getOptionView( GUIPlayer player, BlackjackDealer dealer ) {
        return new OptionView( player, dealer );

    }



}
