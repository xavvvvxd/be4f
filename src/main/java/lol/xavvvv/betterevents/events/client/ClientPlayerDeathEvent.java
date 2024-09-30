package lol.xavvvv.betterevents.events.client;

import lol.xavvvv.betterevents.event.Event;
import lol.xavvvv.betterevents.listeners.client.ClientPlayerDeathListener;
import net.minecraft.entity.damage.DamageSource;

import java.util.ArrayList;

@Deprecated
public class ClientPlayerDeathEvent extends Event<ClientPlayerDeathListener> {
    private final DamageSource recentDamageSource;

    public ClientPlayerDeathEvent(DamageSource recentDamageSource) {
        this.recentDamageSource = recentDamageSource;
    }

    @Override
    public void fire(ArrayList<ClientPlayerDeathListener> listeners) {
        for (ClientPlayerDeathListener listener : listeners){
            listener.onPlayerDeath(this);
        }
    }

    @Override
    public Class<ClientPlayerDeathListener> getListenerClass() {
        return ClientPlayerDeathListener.class;
    }

    public DamageSource getRecentDamageSource(){
        return recentDamageSource;
    }
}
