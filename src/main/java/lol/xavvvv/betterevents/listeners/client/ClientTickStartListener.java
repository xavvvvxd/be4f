package lol.xavvvv.betterevents.listeners.client;

import lol.xavvvv.betterevents.event.Listener;
import lol.xavvvv.betterevents.events.client.ClientTickEvents;

@FunctionalInterface
public interface ClientTickStartListener extends Listener {
    void startClientTick(ClientTickEvents.ClientTickStartEvent event);
}
