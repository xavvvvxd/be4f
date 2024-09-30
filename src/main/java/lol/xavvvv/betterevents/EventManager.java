package lol.xavvvv.betterevents;

import lol.xavvvv.betterevents.event.Event;
import lol.xavvvv.betterevents.event.Listener;

import java.util.*;

public final class EventManager {
    private static final HashMap<Class<? extends Listener>, ArrayList<? extends Listener>> listenerMap = new HashMap<>();

    public static <T extends Listener, S extends Event<T>> void fire(S event){
        Class<T> clazz = event.getListenerClass();

        @SuppressWarnings("unchecked")
        ArrayList<T> listeners = (ArrayList<T>)listenerMap.get(clazz);

        if (listeners == null || listeners.isEmpty()) return;

        listeners.removeIf(Objects::isNull);

        event.fire(listeners);
    }

    public static <T extends Listener> void register(Class<T> clazz, T listener){
        @SuppressWarnings("unchecked")
        ArrayList<T> listeners = (ArrayList<T>)listenerMap.get(clazz);

        if (listeners == null){
            listeners = new ArrayList<>();
        }

        listeners.add(listener);
        listenerMap.put(clazz, listeners);
    }

    public static <T extends Listener> void unregister(Class<T> clazz, T listener){
        @SuppressWarnings("unchecked")
        ArrayList<T> listeners = (ArrayList<T>)listenerMap.get(clazz);

        if (listeners != null) listeners.remove(listener);
    }
}
