package com.vaxy.backroomsmod.datagen;

import com.vaxy.backroomsmod.VaxysBackrooms;
import com.vaxy.backroomsmod.block.ModBlocks;
import com.vaxy.backroomsmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.IronBarsBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.minecraft.core.registries.BuiltInRegistries;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VaxysBackrooms.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleCubeBlock(ModBlocks.LEVEL_0_WALLPAPER);
        simpleCubeBlock(ModBlocks.LEVEL_0_CARPET);
        simpleCubeBlock(ModBlocks.LEVEL_0_CEALING);

        paneBlock((IronBarsBlock) ModBlocks.LEVEL_0_CARPET_WALL.get(), modLoc("block/level_0_carpet"), modLoc("block/level_0_carpet_edge"));

        slabBlock(ModBlocks.LEVEL_0_WALLPAPER_SLAB.get(), blockTexture(ModBlocks.LEVEL_0_WALLPAPER.get()),blockTexture(ModBlocks.LEVEL_0_WALLPAPER.get()));

        blockItem(ModBlocks.LEVEL_0_WALLPAPER);
        blockItem(ModBlocks.LEVEL_0_CARPET);
        blockItem(ModBlocks.LEVEL_0_WALLPAPER_SLAB);
        blockItem(ModBlocks.LEVEL_0_CEALING);
        simpleBlockItem(ModBlocks.LEVEL_0_CARPET_WALL.get(), models().getExistingFile(modLoc("block/level_0_carpet_wall_post")));
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
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("vaxysbackrooms:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("vaxysbackrooms:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
