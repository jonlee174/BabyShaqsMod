package com.babyshaq.babyshaqsmod.datagen;

import com.babyshaq.babyshaqsmod.BabyShaqsMod;
import com.babyshaq.babyshaqsmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BabyShaqsMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLOCK_OF_RUBY);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);

        logBlock(((RotatedPillarBlock) ModBlocks.COCONUT_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.COCONUT_WOOD.get(), blockTexture(ModBlocks.COCONUT_LOG.get()), blockTexture(ModBlocks.COCONUT_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_COCONUT_LOG.get(), new ResourceLocation(BabyShaqsMod.MOD_ID, "block/stripped_coconut_log"),
                new ResourceLocation(BabyShaqsMod.MOD_ID, "block/stripped_coconut_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_COCONUT_WOOD.get(), new ResourceLocation(BabyShaqsMod.MOD_ID, "block/stripped_coconut_log"),
                new ResourceLocation(BabyShaqsMod.MOD_ID, "block/stripped_coconut_log"));

        blockWithItem(ModBlocks.COCONUT_PLANKS);
        blockWithItem(ModBlocks.COCONUT_LEAVES);
        saplingBlock(ModBlocks.COCONUT_SAPLING);

        simpleBlockItem(ModBlocks.COCONUT_LOG.get(), models().withExistingParent("babyshaqsmod:coconut_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.COCONUT_WOOD.get(), models().withExistingParent("babyshaqsmod:coconut_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_COCONUT_LOG.get(), models().withExistingParent("babyshaqsmod:stripped_coconut_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_COCONUT_WOOD.get(), models().withExistingParent("babyshaqsmod:stripped_coconut_wood", "minecraft:block/cube_column"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}