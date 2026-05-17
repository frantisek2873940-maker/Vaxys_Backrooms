package com.vaxy.backroomsmod.item;

import com.vaxy.backroomsmod.VaxysBackrooms;
import com.vaxy.backroomsmod.block.ModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VaxysBackrooms.MODID);

    public static final Supplier<CreativeModeTab> BACKROOMS_TAB =
            CREATIVE_MODE_TABS.register("backrooms_tab", () ->
                    CreativeModeTab.builder()
                            .title(Component.literal("Vaxy's Backrooms"))
                            .icon(() -> new ItemStack(ModBlocks.LEVEL_0_WALLPAPER.get()))
                            .displayItems((parameters, output) -> {

                                output.accept(ModBlocks.LEVEL_0_WALLPAPER);
                                output.accept(ModBlocks.LEVEL_0_WALLPAPER_SLAB);
                                output.accept(ModBlocks.LEVEL_0_CARPET);
                                output.accept(ModBlocks.LEVEL_0_CEALING);
                                output.accept(ModBlocks.LEVEL_0_LAMP);

                            })
                            .build()
            );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}