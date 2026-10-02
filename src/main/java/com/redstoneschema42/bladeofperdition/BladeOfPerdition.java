package com.redstoneschema42.bladeofperdition;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BladeOfPerdition.MOD_ID)
public class BladeOfPerdition {
    public static final String MOD_ID = "bladeofperdition";

    public BladeOfPerdition() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModTabs.CREATIVE_MODE_TABS.register(bus);
    }
}
