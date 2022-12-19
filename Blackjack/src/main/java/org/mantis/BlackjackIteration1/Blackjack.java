package org.mantis.BlackjackIteration1;

public class Blackjack {

    public static void main( String[] args ) {
        DeckPile pile = new DeckPile();
        for ( int i = 0; i < 4; i++ ) {
            pile.shuffle();
            Deck deck = new Deck();
            deck.addToStack( pile );
            pile.shuffle();
        }

        Hand dealerHand = new Hand();
        BlackjackDealer dealer = new BlackjackDealer( "Dealer", dealerHand, pile );
        Hand humanHand = new Hand();
        Player player = new HumanPlayer( "Human", humanHand );
        dealer.addListener( Console.INSTANCE );
        player.addListener( Console.INSTANCE );
        dealer.addPlayer( player );
        dealer.newGame();
    }
}
