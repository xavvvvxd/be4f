package lol.xavvvv.betterevents.events.client;

import lol.xavvvv.betterevents.event.Event;
import lol.xavvvv.betterevents.listeners.client.ClientTickEndListener;
import lol.xavvvv.betterevents.listeners.client.ClientTickStartListener;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;

/**
 * Collection of events that are fired at the beginning and end of a client tick.
 */
public class ClientTickEvents {
    /**
     * Fired at the start of a client tick.
     */
    public static class ClientTickStartEvent extends Event<ClientTickStartListener> {
        private final MinecraftClient client;

        public ClientTickStartEvent(MinecraftClient client) {
            this.client = client;
        }

        @Override
        public void fire(ArrayList<ClientTickStartListener> listeners) {
            for (ClientTickStartListener listener : listeners) {
                listener.startClientTick(this);
            }
        }

        @Override
        public Class<ClientTickStartListener> getListenerClass() {
            return ClientTickStartListener.class;
        }

        public MinecraftClient getClient() {
            return client;
        }
    }

    /**
     * Fired at the end of a client tick.
     */
    public static class ClientTickEndEvent extends Event<ClientTickEndListener> {
        private final MinecraftClient client;

        public ClientTickEndEvent(MinecraftClient client) {
            this.client = client;
        }

        @Override
        public void fire(ArrayList<ClientTickEndListener> listeners) {
            for (ClientTickEndListener listener : listeners) {
                listener.endClientTick(this);
            }
        }

        @Override
        public Class<ClientTickEndListener> getListenerClass() {
            return ClientTickEndListener.class;
        }

        public MinecraftClient getClient() {
            return client;
        }
    }
}
