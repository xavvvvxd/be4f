package lol.xavvvv.betterevents.listeners.client;

import lol.xavvvv.betterevents.event.Listener;
import lol.xavvvv.betterevents.events.client.ClientTickEvents;

@FunctionalInterface
public interface ClientTickEndListener extends Listener {
    void endClientTick(ClientTickEvents.ClientTickEndEvent event);
}
