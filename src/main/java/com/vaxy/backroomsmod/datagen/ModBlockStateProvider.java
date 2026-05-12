package com.vaxy.backroomsmod.datagen;

import com.vaxy.backroomsmod.VaxysBackrooms;
import com.vaxy.backroomsmod.block.ModBlocks;
import com.vaxy.backroomsmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.WallBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.WallBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VaxysBackrooms.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleCubeBlock(ModBlocks.LEVEL_0_WALLPAPER);
        simpleCubeBlock(ModBlocks.LEVEL_0_CARPET);
        simpleCubeBlock(ModBlocks.LEVEL_0_CEALING);

        slabBlock(ModBlocks.LEVEL_0_WALLPAPER_SLAB.get(), blockTexture(ModBlocks.LEVEL_0_WALLPAPER.get()),blockTexture(ModBlocks.LEVEL_0_WALLPAPER.get()));

        wallBlock((WallBlock) ModBlocks.LEVEL_0_CARPET_WALL.get(), blockTexture(ModBlocks.LEVEL_0_CARPET_WALL.get()));

        blockItem(ModBlocks.LEVEL_0_WALLPAPER);
        blockItem(ModBlocks.LEVEL_0_CARPET);
        blockItem(ModBlocks.LEVEL_0_WALLPAPER_SLAB);
        blockItem(ModBlocks.LEVEL_0_CEALING);
        blockItem(ModBlocks.LEVEL_0_CARPET_WALL);
        simpleBlockItem(ModBlocks.LEVEL_0_CARPET_WALL.get(), models().wallInventory("level_0_carpet_wall_inventory", modLoc("block/level_0_carpet")));

    }

    private void simpleCubeBlock(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private void blockWithDifferentSides(DeferredBlock<?> deferredBlock) {

        simpleBlockWithItem(
                deferredBlock.get(),

                models().cubeBottomTop(
                        deferredBlock.getId().getPath(),

                        modLoc("block/" + deferredBlock.getId().getPath() + "_side"),

                        modLoc("block/" + deferredBlock.getId().getPath() + "_bottom"),

                        modLoc("block/" + deferredBlock.getId().getPath() + "_top")
                )
        );
    }
    private void blockItem(DeferredBlock<?> deferredBlock) {

        String name = BuiltInRegistries.BLOCK
                .getKey(deferredBlock.get())
                .getPath();

        simpleBlockItem(
                deferredBlock.get(),
                new ModelFile.UncheckedModelFile(
                        modLoc("block/" + name)
                )
        );
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {

        String name = BuiltInRegistries.BLOCK
                .getKey(deferredBlock.get())
                .getPath();

        simpleBlockItem(
                deferredBlock.get(),
                new ModelFile.UncheckedModelFile(
                        modLoc("block/" + name + appendix)
                )
        );
    }
}
