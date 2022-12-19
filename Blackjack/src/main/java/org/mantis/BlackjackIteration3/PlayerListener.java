package org.mantis.BlackjackIteration3;

public interface PlayerListener {

    void playerChanged( Player player );
    void playerBusted( Player player );
    void playerBlackjack( Player player );
    void playerStanding( Player player );
    void playerWon( Player player );
    void playerLost( Player player );
    void playerStandoff( Player player );
}
