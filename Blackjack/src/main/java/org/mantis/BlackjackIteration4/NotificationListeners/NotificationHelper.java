package org.mantis.BlackjackIteration4.NotificationListeners;

import org.mantis.BlackjackIteration4.Player;
import org.mantis.BlackjackIteration4.PlayerListener;

public interface NotificationHelper {
    void notifyListener( PlayerListener playerListener, Player player );
}
