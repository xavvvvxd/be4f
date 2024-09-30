package lol.xavvvv.betterevents.listeners;

import lol.xavvvv.betterevents.event.Listener;
import lol.xavvvv.betterevents.events.PlayerDeathEvent;

public interface PlayerDeathListener extends Listener {
    void onPlayerDeath(PlayerDeathEvent event);
}
