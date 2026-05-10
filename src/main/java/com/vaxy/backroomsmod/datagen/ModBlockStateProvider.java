package com.vaxy.backroomsmod.datagen;

import com.vaxy.backroomsmod.VaxysBackrooms;
import com.vaxy.backroomsmod.block.ModBlocks;
import com.vaxy.backroomsmod.item.ModItems;
import net.minecraft.data.PackOutput;
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
        simpleBlock(ModBlocks.LEVEL_0_WALLPAPER);
        simpleBlock(ModBlocks.LEVEL_0_CARPET);
        slabBlock(ModBlocks.LEVEL_0_WALLPAPER_SLAB.get(), blockTexture(ModBlocks.LEVEL_0_WALLPAPER.get()),blockTexture(ModBlocks.LEVEL_0_WALLPAPER.get()));

        blockItem(ModBlocks.LEVEL_0_WALLPAPER);
        blockItem(ModBlocks.LEVEL_0_CARPET);
        blockItem(ModBlocks.LEVEL_0_WALLPAPER_SLAB);

    }

    private void simpleBlock(DeferredBlock<?> deferredBlock) {
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
