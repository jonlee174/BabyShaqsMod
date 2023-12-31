package com.babyshaq.babyshaqsmod;

import com.babyshaq.babyshaqsmod.block.ModBlocks;
import com.babyshaq.babyshaqsmod.datagen.DataGenerators;
import com.babyshaq.babyshaqsmod.datagen.ModWorldGenProvider;
import com.babyshaq.babyshaqsmod.item.ModCreativeModeTabs;
import com.babyshaq.babyshaqsmod.item.ModItems;
import com.babyshaq.babyshaqsmod.villager.ModVillagers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.targets.CommonLaunchHandler;
import net.minecraftforge.fml.loading.targets.FMLDataUserdevLaunchHandler;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BabyShaqsMod.MOD_ID)
public class BabyShaqsMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "babyshaqsmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public BabyShaqsMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });
    }

    public void gatherData(GatherDataEvent event)
    {
        DataGenerators.gatherData(event);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ModCreativeModeTabs.BABYSHAQS_ITEMS_TAB.get()) {
            event.accept(ModItems.RUBY);
            event.accept(ModItems.COCONUT);
            event.accept(ModItems.TOMATO);
            event.accept(ModItems.TOMATO_SEEDS);
        }

        if (event.getTab() == ModCreativeModeTabs.BABYSHAQS_BLOCKS_TAB.get()) {
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
            event.accept(ModBlocks.BLOCK_OF_RUBY);
            event.accept(ModBlocks.ARCHAEOLOGY_STAND);
            event.accept(ModBlocks.COCONUT_LOG);
            event.accept(ModBlocks.COCONUT_WOOD);
            event.accept(ModBlocks.STRIPPED_COCONUT_LOG);
            event.accept(ModBlocks.STRIPPED_COCONUT_WOOD);
            event.accept(ModBlocks.COCONUT_PLANKS);
            event.accept(ModBlocks.COCONUT_LEAVES);
            event.accept(ModBlocks.COCONUT_SAPLING);
        }
    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TOMATO_CROP.get(), RenderType.cutout());
        }
    }
}
