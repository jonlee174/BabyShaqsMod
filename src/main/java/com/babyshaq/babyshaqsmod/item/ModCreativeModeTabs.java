package com.babyshaq.babyshaqsmod.item;

import com.babyshaq.babyshaqsmod.BabyShaqsMod;
import com.babyshaq.babyshaqsmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BabyShaqsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BABYSHAQS_ITEMS_TAB = CREATIVE_MODE_TABS.register("babyshaqs_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.get())).title(Component.translatable("creativemodetab.babyshaqs_items_tab")).build());

    public static final RegistryObject<CreativeModeTab> BABYSHAQS_BLOCKS_TAB = CREATIVE_MODE_TABS.register("babyshaqs_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BLOCK_OF_RUBY.get())).title(Component.translatable("creativemodetab.babyshaqs_blocks_tab")).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
