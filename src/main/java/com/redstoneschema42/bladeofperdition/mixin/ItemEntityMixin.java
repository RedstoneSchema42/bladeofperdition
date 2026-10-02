package com.redstoneschema42.bladeofperdition.mixin;

import com.redstoneschema42.bladeofperdition.ModItems;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        ItemEntity entity = (ItemEntity)(Object)this;
        if (entity.getItem().is(ModItems.BLADE_OF_PERDITION.get())) {
            entity.discard();
        }
    }
}
