package org.mantis.BlackjackIteration3;

public interface Dealer {
    // Used by the player to interact with the dealer..
    void hit( Player player );
    // Used by the player to communicate state to the dealer..
    void blackjack( Player player );
    void busted( Player player );
    void standing( Player player );
    void doneBetting( Player player );
}
