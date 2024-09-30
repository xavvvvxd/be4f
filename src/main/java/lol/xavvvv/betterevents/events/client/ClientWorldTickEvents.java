package lol.xavvvv.betterevents.events.client;

import lol.xavvvv.betterevents.event.Event;
import lol.xavvvv.betterevents.listeners.client.ClientWorldTickEndListener;
import lol.xavvvv.betterevents.listeners.client.ClientWorldTickStartListener;
import net.minecraft.client.world.ClientWorld;

import java.util.ArrayList;

/**
 * Collection of events that are fired at the beginning and end of a ClientWorld tick.
 */
public class ClientWorldTickEvents {
    /**
     * Fired at the beginning of a {@link ClientWorld} tick.
     */
    public static class ClientWorldTickStartEvent extends Event<ClientWorldTickStartListener> {
        private final ClientWorld clientWorld;

        public ClientWorldTickStartEvent(ClientWorld clientWorld) {
            this.clientWorld = clientWorld;
        }

        @Override
        public void fire(ArrayList<ClientWorldTickStartListener> listeners) {
            for (ClientWorldTickStartListener listener : listeners) {
                listener.startClientWorldTick(this);
            }
        }

        @Override
        public Class<ClientWorldTickStartListener> getListenerClass() {
            return ClientWorldTickStartListener.class;
        }

        public ClientWorld getClientWorld() {
            return clientWorld;
        }
    }

    /**
     * Fired at the end of a {@link ClientWorld} tick.
     */
    public static class ClientWorldTickEndEvent extends Event<ClientWorldTickEndListener> {
        private final ClientWorld clientWorld;

        public ClientWorldTickEndEvent(ClientWorld clientWorld) {
            this.clientWorld = clientWorld;
        }


        @Override
        public void fire(ArrayList<ClientWorldTickEndListener> listeners) {
            for (ClientWorldTickEndListener listener : listeners) {
                listener.endClientWorldTick(this);
            }
        }

        @Override
        public Class<ClientWorldTickEndListener> getListenerClass() {
            return ClientWorldTickEndListener.class;
        }

        public ClientWorld getClientWorld() {
            return clientWorld;
        }
    }
}
