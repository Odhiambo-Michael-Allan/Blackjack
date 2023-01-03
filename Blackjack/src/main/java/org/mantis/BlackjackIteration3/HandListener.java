package org.mantis.BlackjackIteration3;

/**
 * An object can implement this interface if it is interested in receiving
 * updates from a hand.
 * @Author Michael Allan Odhiambo.
 */

public interface HandListener {

    void handPlayable();
    void handBlackjack();
    void handBusted();
    void handChanged();
}
