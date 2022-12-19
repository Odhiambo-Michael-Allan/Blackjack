package org.mantis.BlackjackIteration2.NotificationListeners;

import org.mantis.BlackjackIteration2.Player;
import org.mantis.BlackjackIteration2.PlayerListener;

public class NotifyWonHelper implements NotificationHelper {
    @Override
    public void notifyListener( PlayerListener playerListener, Player player ) {
        playerListener.playerWon( player );
    }
}
