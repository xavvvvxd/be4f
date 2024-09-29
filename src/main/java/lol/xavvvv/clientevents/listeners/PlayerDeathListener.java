package lol.xavvvv.clientevents.listeners;

import lol.xavvvv.clientevents.event.Listener;
import lol.xavvvv.clientevents.events.PlayerDeathEvent;
import net.minecraft.entity.damage.DamageSource;

public interface PlayerDeathListener extends Listener {
    void onPlayerDeath(PlayerDeathEvent event);
}
