package lol.xavvvv.betterevents.listeners;

import lol.xavvvv.betterevents.event.Listener;
import lol.xavvvv.betterevents.events.TickEvent;

public interface TickListener extends Listener {
    void tick(TickEvent event);
}
