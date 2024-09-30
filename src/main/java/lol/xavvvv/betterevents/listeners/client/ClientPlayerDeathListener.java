package lol.xavvvv.betterevents.listeners.client;

import lol.xavvvv.betterevents.event.Listener;
import lol.xavvvv.betterevents.events.client.ClientPlayerDeathEvent;

@Deprecated
@FunctionalInterface
public interface ClientPlayerDeathListener extends Listener {
    void onPlayerDeath(ClientPlayerDeathEvent event);
}
