package org.mantis.BlackjackIteration4.NotificationListeners;

import org.mantis.BlackjackIteration4.Player;
import org.mantis.BlackjackIteration4.PlayerListener;

public class NotifyStandOffHelper implements NotificationHelper {
    @Override
    public void notifyListener( PlayerListener playerListener, Player player ) {
        playerListener.playerStandOff( player );
    }
}
