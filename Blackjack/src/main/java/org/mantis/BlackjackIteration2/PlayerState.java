package org.mantis.BlackjackIteration2;

/**
 * This is the interface that all player states must implements. A PlayerState listens to the
 * Hand and provides an activity in its execute method.
 * @Author Michael Allan Odhiambo
 */

public interface PlayerState extends HandListener {
    void execute( Dealer dealer );
}
