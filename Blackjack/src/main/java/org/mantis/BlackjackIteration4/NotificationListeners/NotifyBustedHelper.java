package org.mantis.BlackjackIteration4.NotificationListeners;

import org.mantis.BlackjackIteration4.Player;
import org.mantis.BlackjackIteration4.PlayerListener;

public class NotifyBustedHelper implements NotificationHelper {
    public void notifyListener( PlayerListener playerListener, Player player ) {
        playerListener.playerBusted( player );
    }
}
