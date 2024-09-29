package lol.xavvvv.clientevents.events;

import lol.xavvvv.clientevents.event.Event;
import lol.xavvvv.clientevents.listeners.PlayerDeathListener;
import net.minecraft.entity.damage.DamageSource;

import java.util.ArrayList;

public class PlayerDeathEvent extends Event<PlayerDeathListener> {
    private DamageSource recentDamageSource;

    public PlayerDeathEvent(DamageSource recentDamageSource) {
        this.recentDamageSource = recentDamageSource;
    }

    @Override
    public void fire(ArrayList<PlayerDeathListener> listeners) {
        for (PlayerDeathListener listener : listeners){
            listener.onPlayerDeath(this);
        }
    }

    @Override
    public Class<PlayerDeathListener> getListenerClass() {
        return PlayerDeathListener.class;
    }

    public DamageSource getRecentDamageSource(){
        return recentDamageSource;
    }
}
