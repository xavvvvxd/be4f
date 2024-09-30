package lol.xavvvv.betterevents.listeners.client;

import lol.xavvvv.betterevents.event.Listener;
import lol.xavvvv.betterevents.events.client.ClientWorldTickEvents;

@FunctionalInterface
public interface ClientWorldTickStartListener extends Listener {
    void startClientWorldTick(ClientWorldTickEvents.ClientWorldTickStartEvent event);
}
