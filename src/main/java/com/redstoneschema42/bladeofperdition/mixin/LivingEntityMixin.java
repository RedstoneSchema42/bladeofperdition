package com.redstoneschema42.bladeofperdition.mixin;

import com.redstoneschema42.bladeofperdition.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void onHurt(net.minecraft.world.damagesource.DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity)(Object)this;
        if (entity instanceof Player player && hasBlade(player)) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }

    @Inject(method = "die", at = @At("HEAD"), cancellable = true)
    private void onDie(net.minecraft.world.damagesource.DamageSource source, CallbackInfo ci) {
        LivingEntity entity = (LivingEntity)(Object)this;
        if (entity instanceof Player player && hasBlade(player)) {
            player.setHealth(20.0F);
            ci.cancel();
        }
    }

    private boolean hasBlade(Player player) {
        for (ItemStack stack : player.getInventory().items) {
            if (stack.is(ModItems.BLADE_OF_PERDITION.get())) return true;
        }
        if (player.getOffhandItem().is(ModItems.BLADE_OF_PERDITION.get())) return true;
        for (ItemStack stack : player.getInventory().armor) {
            if (stack.is(ModItems.BLADE_OF_PERDITION.get())) return true;
        }
        return false;
    }
}
