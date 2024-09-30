package lol.xavvvv.betterevents;

import lol.xavvvv.betterevents.events.client.ClientWorldTickEvents;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class BetterEventsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            EventManager.fire(new lol.xavvvv.betterevents.events.client.ClientTickEvents.ClientTickStartEvent(client));
        });
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            EventManager.fire(new lol.xavvvv.betterevents.events.client.ClientTickEvents.ClientTickEndEvent(client));
        });
        ClientTickEvents.START_WORLD_TICK.register(clientWorld -> {
            EventManager.fire(new ClientWorldTickEvents.ClientWorldTickStartEvent(clientWorld));
        });
        ClientTickEvents.END_WORLD_TICK.register(clientWorld -> {
            EventManager.fire(new ClientWorldTickEvents.ClientWorldTickEndEvent(clientWorld));
        });
    }
}
