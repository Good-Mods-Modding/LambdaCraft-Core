package net.goodmodsmodding.core.item;

import net.goodmodsmodding.core.Core;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Core.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab TUTORIAL_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        TUTORIAL_TAB = event.registerCreativeModeTab(new ResourceLocation(Core.MOD_ID, "tutorial_tab"), builder -> builder.icon(() -> new ItemStack(ModItems.ARCANE_CRYSTAL.get())) // TODO: Change icon to Adamantium Ingot
            .title(Component.translatable("creativemodetab.tutorial_tab")));
    }
}
