package org.mantis.BlackjackIteration3.NotificationListeners;

import org.mantis.BlackjackIteration3.Player;
import org.mantis.BlackjackIteration3.PlayerListener;

public class NotifyStandingHelper implements NotificationHelper {
    @Override
    public void notifyListener( PlayerListener playerListener, Player player ) {
        playerListener.playerStanding( player );
    }
}
