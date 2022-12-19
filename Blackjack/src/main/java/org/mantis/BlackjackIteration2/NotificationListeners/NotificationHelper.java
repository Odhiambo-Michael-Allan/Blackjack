package org.mantis.BlackjackIteration2.NotificationListeners;

import org.mantis.BlackjackIteration2.Player;
import org.mantis.BlackjackIteration2.PlayerListener;

public interface NotificationHelper {
    void notifyListener( PlayerListener playerListener, Player player );
}
