package com.redstoneschema42.bladeofperdition.mixin;

import com.redstoneschema42.bladeofperdition.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(method = "spawnAtLocation(Lnet/minecraft/world/item/ItemStack;F)Lnet/minecraft/world/entity/item/ItemEntity;", at = @At("HEAD"), cancellable = true)
    private void onSpawnAtLocation(ItemStack stack, float offset, CallbackInfoReturnable<ItemEntity> cir) {
        if (stack.is(ModItems.BLADE_OF_PERDITION.get())) {
            cir.setReturnValue(null);
            cir.cancel();
        }
    }
}
