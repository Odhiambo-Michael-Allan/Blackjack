package org.mantis.BlackjackIteration4.NotificationListeners;

import org.mantis.BlackjackIteration4.Player;
import org.mantis.BlackjackIteration4.PlayerListener;

public class NotifyLostHelper implements NotificationHelper {
    @Override
    public void notifyListener( PlayerListener playerListener, Player player ) {
        playerListener.playerLost( player );
    }
}
