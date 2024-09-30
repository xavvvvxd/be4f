package lol.xavvvv.betterevents.mixin;

import lol.xavvvv.betterevents.EventManager;
import lol.xavvvv.betterevents.events.client.ClientPlayerDeathEvent;
import lol.xavvvv.betterevents.events.client.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends LivingEntity {
    @Unique
    private boolean dontFireDeathEvent = false;

    @Shadow
    @Final
    protected MinecraftClient client;

    protected ClientPlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci){
        if (this.isDead()){
            if (!dontFireDeathEvent) {
                dontFireDeathEvent = true;

                ClientPlayerDeathEvent event = new ClientPlayerDeathEvent(this.getRecentDamageSource()); // getRecentDamageSource is nullable...
                EventManager.fire(event);
            }
        } else {
            dontFireDeathEvent = false;
        }
        ClientTickEvents.ClientTickStartEvent event = new ClientTickEvents.ClientTickStartEvent(this.client);
        EventManager.fire(event);
    }
}
