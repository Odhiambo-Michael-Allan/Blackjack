package org.mantis.BlackjackIteration3;

public interface Dealer {
    void hit( Player player );
    void standing( Player player );
    void busted( Player player );
    void blackjack( Player player );
}
