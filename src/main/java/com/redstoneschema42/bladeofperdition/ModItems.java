package com.redstoneschema42.bladeofperdition;

import com.redstoneschema42.bladeofperdition.item.BladeOfPerditionItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BladeOfPerdition.MOD_ID);

    public static final RegistryObject<Item> BLADE_OF_PERDITION =
            ITEMS.register("blade_of_perdition", BladeOfPerditionItem::new);
}
