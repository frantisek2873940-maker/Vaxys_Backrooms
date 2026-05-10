package com.vaxy.backroomsmod.block;

import com.vaxy.backroomsmod.VaxysBackrooms;
import com.vaxy.backroomsmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(VaxysBackrooms.MODID);


    public static final DeferredBlock<Block> LEVEL_0_WALLPAPER = registerBlock("level_0_wallpaper",
            ()-> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1f).explosionResistance(360000).noLootTable()));

    public static final DeferredBlock<Block> LEVEL_0_CARPET = registerBlock("level_0_carpet",
            ()-> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1f).explosionResistance(360000).noLootTable()));

    public static final DeferredBlock<SlabBlock> LEVEL_0_WALLPAPER_SLAB = registerBlock("level_0_wallpaper_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1f).explosionResistance(360000).noLootTable()));


    private static <T extends Block> DeferredBlock<T> registerBlock (String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
