package org.mantis.BlackjackIteration3.NotificationListeners;

import org.mantis.BlackjackIteration3.Player;
import org.mantis.BlackjackIteration3.PlayerListener;

public interface NotificationHelper {
    void notifyListener( PlayerListener playerListener, Player player );
}
