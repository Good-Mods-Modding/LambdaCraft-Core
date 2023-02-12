package net.goodmodsmodding.core.block;

import net.goodmodsmodding.core.Core;
import net.goodmodsmodding.core.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.DIAMOND_BLOCK;
import static net.minecraft.world.level.block.Blocks.DIAMOND_ORE;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Core.MOD_ID);

    /*
    public static final RegistryObject<Block> MANA_DIAMOND_BLOCK = registerBlock("mana_diamond_block", () -> new Block(BlockBehaviour
        .Properties.of(Material.METAL)
        .requiresCorrectToolForDrops()
        .strength(5.0F, 6.0F)
        .sound(SoundType.METAL)));
    public static final RegistryObject<Block> ARCANE_CRYSTAL_BLOCK = registerBlock("arcane_crystal_block", () -> new Block(BlockBehaviour.Properties
        .of(Material.METAL)
        .requiresCorrectToolForDrops()
        .strength(5.0F, 6.0F)
        .sound(SoundType.METAL)));
    public static final RegistryObject<Block> ARCANE_CRYSTAL_ORE = registerBlock("arcane_crystal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties
        .of(Material.STONE)
        .requiresCorrectToolForDrops()
        .strength(3.0F, 3.0F),
        UniformInt.of(3, 7)));
*/

    // STORAGE BLOCKS

    public static final RegistryObject<Block> MANA_DIAMOND_BLOCK = registerBlock("mana_diamond_block", () -> new Block(BlockBehaviour.Properties
        .copy(DIAMOND_BLOCK)));
    public static final RegistryObject<Block> ARCANE_CRYSTAL_BLOCK = registerBlock("arcane_crystal_block", () -> new Block(BlockBehaviour.Properties
        .copy(DIAMOND_BLOCK)));

    // ORES

    public static final RegistryObject<Block> ARCANE_CRYSTAL_ORE = registerBlock("arcane_crystal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties
        .copy(DIAMOND_ORE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
            new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
