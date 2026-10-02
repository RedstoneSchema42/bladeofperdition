package com.redstoneschema42.bladeofperdition;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BladeOfPerdition.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BLADE_OF_PERDITION_TAB =
            CREATIVE_MODE_TABS.register("blade_of_perdition_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + BladeOfPerdition.MOD_ID + ".blade_of_perdition"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.BLADE_OF_PERDITION.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        for (RegistryObject<Item> entry : ModItems.ITEMS.getEntries()) {
                            output.accept(entry.get());
                        }
                    })
                    .build());
}
