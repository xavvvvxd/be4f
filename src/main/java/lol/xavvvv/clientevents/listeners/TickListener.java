package lol.xavvvv.clientevents.listeners;

import lol.xavvvv.clientevents.event.Listener;
import lol.xavvvv.clientevents.events.TickEvent;

public interface TickListener extends Listener {
    void tick(TickEvent event);
}
