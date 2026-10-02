package com.redstoneschema42.bladeofperdition.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class BladeOfPerditionItem extends SwordItem {
    public BladeOfPerditionItem() {
        super(Tiers.NETHERITE, 5, -2.4F, new Properties().stacksTo(1));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setSecondsOnFire(5);
        return super.hurtEnemy(stack, target, attacker);
    }
}