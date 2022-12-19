package org.mantis.BlackjackIteration2.NotificationListeners;

import org.mantis.BlackjackIteration2.Player;
import org.mantis.BlackjackIteration2.PlayerListener;

public class NotifyStandOffHelper implements NotificationHelper {
    @Override
    public void notifyListener( PlayerListener playerListener, Player player ) {
        playerListener.playerStandOff( player );
    }
}
