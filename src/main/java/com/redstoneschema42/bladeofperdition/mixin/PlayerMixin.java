package com.redstoneschema42.bladeofperdition.mixin;

import com.redstoneschema42.bladeofperdition.ModItems;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerMixin {

    @Inject(method = "tick", at = @At("TAIL"))
    private void onTick(CallbackInfo ci) {
        Player player = (Player)(Object)this;
        
        if (player.level().isClientSide()) return;

        boolean hasBlade = false;
        
        for (ItemStack stack : player.getInventory().items) {
            if (stack.is(ModItems.BLADE_OF_PERDITION.get())) {
                hasBlade = true;
                break;
            }
        }
        if (!hasBlade) {
            for (ItemStack stack : player.getInventory().armor) {
                if (stack.is(ModItems.BLADE_OF_PERDITION.get())) {
                    hasBlade = true;
                    break;
                }
            }
        }
        if (!hasBlade && player.getOffhandItem().is(ModItems.BLADE_OF_PERDITION.get())) {
            hasBlade = true;
        }
        if (!hasBlade && player.containerMenu.getCarried().is(ModItems.BLADE_OF_PERDITION.get())) {
            hasBlade = true;
        }

        if (hasBlade) {
            if (player.getHealth() != 20.0F) {
                player.setHealth(20.0F);
            }
            if (player.getAttribute(Attributes.MAX_HEALTH).getBaseValue() != 20.0) {
                player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0);
            }
        } else {
            player.getInventory().add(new ItemStack(ModItems.BLADE_OF_PERDITION.get()));
        }
    }
}
