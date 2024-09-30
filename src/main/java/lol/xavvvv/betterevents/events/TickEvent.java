package lol.xavvvv.betterevents.events;

import lol.xavvvv.betterevents.event.Event;
import lol.xavvvv.betterevents.listeners.TickListener;

import java.util.ArrayList;

public class TickEvent extends Event<TickListener> {
    @Override
    public void fire(ArrayList<TickListener> listeners) {
        for (TickListener listener : listeners){
            listener.tick(this);
        }
    }

    @Override
    public Class<TickListener> getListenerClass() {
        return TickListener.class;
    }
}
