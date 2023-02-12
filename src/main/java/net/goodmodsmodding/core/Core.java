package net.goodmodsmodding.core;

import com.mojang.logging.LogUtils;
import net.goodmodsmodding.core.block.ModBlocks;
import net.goodmodsmodding.core.item.ModCreativeModeTabs;
import net.goodmodsmodding.core.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Core.MOD_ID)
public class Core {
    public static final String MOD_ID = "core";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Core() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ARCANE_CRYSTAL);
            event.accept(ModItems.MANA_DIAMOND);
            event.accept(ModItems.RAW_ADAMANTIUM);
        }

        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.ADAMANTIUM_BLOCK);
            event.accept(ModBlocks.ARCANE_CRYSTAL_BLOCK);
            event.accept(ModBlocks.MANA_DIAMOND_BLOCK);
        }

        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.ADAMANTIUM_ORE);
            event.accept(ModBlocks.ARCANE_CRYSTAL_ORE);
            event.accept(ModBlocks.RAW_ADAMANTIUM_BLOCK);
        }

        if(event.getTab() == ModCreativeModeTabs.TUTORIAL_TAB) {
            event.accept(ModItems.ADAMANTIUM_INGOT);
            event.accept(ModItems.ARCANE_CRYSTAL);
            event.accept(ModItems.MANA_DIAMOND);
            event.accept(ModItems.RAW_ADAMANTIUM);
            event.accept(ModBlocks.ADAMANTIUM_ORE);
            event.accept(ModBlocks.ADAMANTIUM_BLOCK);
            event.accept(ModBlocks.ARCANE_CRYSTAL_BLOCK);
            event.accept(ModBlocks.ARCANE_CRYSTAL_ORE);
            event.accept(ModBlocks.MANA_DIAMOND_BLOCK);
            event.accept(ModBlocks.RAW_ADAMANTIUM_BLOCK);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}
