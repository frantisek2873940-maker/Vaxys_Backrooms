package com.vaxy.backroomsmod.item;

import com.vaxy.backroomsmod.VaxysBackrooms;
import com.vaxy.backroomsmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VaxysBackrooms.MODID);

    public static final Supplier<CreativeModeTab> BACKROOMS_TAB = CREATIVE_MODE_TAB.register("backrooms_tab",
            ()-> new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 0).icon(()-> new ItemStack(ModBlocks.LEVEL_0_WALLPAPER)).title(Component.translatable("Vaxy's backrooms"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.LEVEL_0_WALLPAPER);
                        output.accept(ModBlocks.LEVEL_0_CARPET);
                        //output.accept(ModBlocks.LEVEL_0_WALLPAPER_SLAB);

                    }).build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
