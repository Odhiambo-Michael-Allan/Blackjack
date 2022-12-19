package org.mantis.BlackjackIteration2.NotificationListeners;

import org.mantis.BlackjackIteration2.Player;
import org.mantis.BlackjackIteration2.PlayerListener;

public class NotifyBustedHelper implements NotificationHelper {
    public void notifyListener( PlayerListener playerListener, Player player ) {
        playerListener.playerBusted( player );
    }
}
