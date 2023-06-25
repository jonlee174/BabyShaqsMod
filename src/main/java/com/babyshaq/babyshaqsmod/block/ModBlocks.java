package com.babyshaq.babyshaqsmod.block;

import com.babyshaq.babyshaqsmod.BabyShaqsMod;
import com.babyshaq.babyshaqsmod.block.custom.TomatoCropBlock;
import com.babyshaq.babyshaqsmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BabyShaqsMod.MOD_ID);

    public static final RegistryObject<Block> BLOCK_OF_RUBY = registerBlock("block_of_ruby",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)));

    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_EMERALD_ORE)));

    public static final RegistryObject<Block> TOMATO_CROP = registerBlock("tomato_crop",
            () -> new TomatoCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> ARCHAEOLOGY_STAND = registerBlock("archaeology_stand",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus event) {
        BLOCKS.register(event);
    }
}
