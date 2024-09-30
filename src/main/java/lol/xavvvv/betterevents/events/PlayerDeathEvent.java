package lol.xavvvv.betterevents.events;

import lol.xavvvv.betterevents.event.Event;
import lol.xavvvv.betterevents.listeners.PlayerDeathListener;
import net.minecraft.entity.damage.DamageSource;

import java.util.ArrayList;

public class PlayerDeathEvent extends Event<PlayerDeathListener> {
    private final DamageSource recentDamageSource;

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
