package com.redstoneschema42.bladeofperdition.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

import java.util.UUID;

public class BladeOfPerditionItem extends SwordItem {

    private static final UUID ATTACK_DAMAGE_UUID =
            UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
    private static final UUID ATTACK_SPEED_UUID =
            UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3");

    public BladeOfPerditionItem() {
        super(Tiers.NETHERITE, 5, -2.4F, new Properties().stacksTo(1));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();

            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(
                    ATTACK_DAMAGE_UUID,
                    "Weapon modifier",
                    Float.MAX_VALUE,
                    AttributeModifier.Operation.ADDITION
            ));

            builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(
                    ATTACK_SPEED_UUID,
                    "Weapon modifier",
                    Float.MAX_VALUE,
                    AttributeModifier.Operation.ADDITION
            ));

            return builder.build();
        }
        return super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setSecondsOnFire(5);
        if (!target.level().isClientSide()) {
            target.kill();
        }

        return true;
    }
}
