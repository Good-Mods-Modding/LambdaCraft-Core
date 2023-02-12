package net.goodmodsmodding.core.item;

import net.goodmodsmodding.core.Core;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, Core.MOD_ID);

    public static final RegistryObject<Item> MANA_DIAMOND = ITEMS.register("mana_diamond", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ARCANE_CRYSTAL = ITEMS.register("arcane_crystal", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
