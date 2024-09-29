package lol.xavvvv.clientevents;

import lol.xavvvv.clientevents.event.Event;
import lol.xavvvv.clientevents.event.Listener;

import java.lang.reflect.Array;
import java.util.*;

public final class EventManager {
    private static final HashMap<Class<? extends Listener>, ArrayList<? extends Listener>> listeners = new HashMap<>();

    public static <T extends Listener, S extends Event<T>> void fire(S event){
        Class<T> clazz = event.getListenerClass();

        @SuppressWarnings("unchecked")
        ArrayList<T> listenersList = (ArrayList<T>)listeners.get(clazz);

        if (listenersList == null || listenersList.isEmpty()) return;

        listenersList.removeIf(Objects::isNull);

        event.fire(listenersList);
    }

    public static <T extends Listener> void register(Class<T> clazz, T listener){
        @SuppressWarnings("unchecked")
        ArrayList<T> listenerList = (ArrayList<T>)listeners.get(clazz);

        if (listenerList == null){
            listenerList = new ArrayList<>(Collections.singletonList(listener));
            listeners.put(clazz, listenerList);
            return;
        }

        listenerList.add(listener);
    }

    public static <T extends Listener> void remove(Class<T> clazz, T listener){
        @SuppressWarnings("unchecked")
        ArrayList<T> listenerList = (ArrayList<T>)listeners.get(clazz);

        if (listenerList != null) listenerList.remove(listener);
    }
}
