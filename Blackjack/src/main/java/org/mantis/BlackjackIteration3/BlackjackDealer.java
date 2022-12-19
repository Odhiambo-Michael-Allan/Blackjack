package org.mantis.BlackjackIteration3;

public class BlackjackDealer extends Player implements Dealer {

    private String name;
    private Hand hand;
    private DeckPile pile;

    public BlackjackDealer( String name, Hand hand, DeckPile pile ) {
        super( name, hand );
        this.pile = pile;
    }

    @Override
    public void hit(Player player) {

    }

    @Override
    public void standing(Player player) {

    }

    @Override
    public void busted(Player player) {

    }

    @Override
    public void blackjack(Player player) {
    }

    @Override
    protected boolean hit() {
        return false;
    }
}
