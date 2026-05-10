package com.vaxy.backroomsmod.datagen;

import com.vaxy.backroomsmod.VaxysBackrooms;
import com.vaxy.backroomsmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VaxysBackrooms.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //basicItem(ModItems.EXAMPLE.get());
    }
}
