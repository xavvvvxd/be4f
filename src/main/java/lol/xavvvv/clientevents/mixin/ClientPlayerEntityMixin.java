package lol.xavvvv.clientevents.mixin;

import lol.xavvvv.clientevents.EventManager;
import lol.xavvvv.clientevents.events.PlayerDeathEvent;
import lol.xavvvv.clientevents.events.TickEvent;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends LivingEntity {
    @Unique
    private boolean dontFireDeathEvent = false;

    protected ClientPlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci){
        if (this.isDead()){
            if (!dontFireDeathEvent) {
                dontFireDeathEvent = true;

                PlayerDeathEvent event = new PlayerDeathEvent(this.getRecentDamageSource());
                EventManager.fire(event);
            }
        } else {
            dontFireDeathEvent = false;
        }
        TickEvent event = new TickEvent();
        EventManager.fire(event);
    }
}
