package org.mantis.BlackjackIteration3;

/**
 * This is the interface a class should implement if it needs to listen to a player..
 * @Author Michael Allan Odhiambo.
 */

public interface PlayerListener {
    void playerChanged( Player player );
    void playerBusted( Player player );
    void playerBlackjack( Player player );
    void playerStanding( Player player );
    void playerWon( Player player );
    void playerLost( Player player );
    void playerStandOff( Player player );
}
