package com.babyshaq.babyshaqsmod.datagen;

import com.babyshaq.babyshaqsmod.block.ModBlocks;
import com.babyshaq.babyshaqsmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.BLOCK_OF_RUBY.get());

        add(ModBlocks.RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));
        add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RUBY.get()));

        dropSelf(ModBlocks.COCONUT_LOG.get());
        dropSelf(ModBlocks.COCONUT_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_COCONUT_LOG.get());
        dropSelf(ModBlocks.STRIPPED_COCONUT_WOOD.get());
        dropSelf(ModBlocks.COCONUT_PLANKS.get());
        dropSelf(ModBlocks.COCONUT_SAPLING.get());

        this.add(ModBlocks.COCONUT_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.COCONUT_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}