package com.vaxy.backroomsmod.item;

import com.vaxy.backroomsmod.VaxysBackrooms;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VaxysBackrooms.MODID);

    public static final DeferredItem<Item> EXAMPLE = ITEMS.register("example",
            ()-> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
