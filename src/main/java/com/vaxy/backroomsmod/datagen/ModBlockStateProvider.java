package com.vaxy.backroomsmod.datagen;

import com.vaxy.backroomsmod.VaxysBackrooms;
import com.vaxy.backroomsmod.block.ModBlocks;
import com.vaxy.backroomsmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VaxysBackrooms.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithDifferentSides(ModBlocks.LEVEL_0_WALLPAPER);
        simpleBlock(ModBlocks.LEVEL_0_CARPET);
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

}
