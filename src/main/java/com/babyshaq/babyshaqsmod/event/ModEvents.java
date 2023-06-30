package com.babyshaq.babyshaqsmod.event;

import com.babyshaq.babyshaqsmod.BabyShaqsMod;
import com.babyshaq.babyshaqsmod.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.advancements.critereon.EnchantedItemTrigger;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = BabyShaqsMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.ARCHAEOLOGIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing >> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.BRUSH, 1);
            ItemStack stack1 = new ItemStack(Items.EMERALD, 1);
            ItemStack stack2 = new ItemStack(Items.RAW_IRON_BLOCK, 1);
            ItemStack stack3 = new ItemStack(Items.FRIEND_POTTERY_SHERD, 1);
            ItemStack stack4 = new ItemStack(Items.SHELTER_POTTERY_SHERD, 1);
            //ItemStack stack5 = new ItemStack(, 1);
            ItemStack stack6 = new ItemStack(Items.SUSPICIOUS_SAND, 8);
            ItemStack stack7 = new ItemStack(Items.SUSPICIOUS_GRAVEL, 8);

            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack,10,8,0.02F));

            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.GRAVEL, 32),
                    stack1,10,8,0.02F));

            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.SAND, 32),
                    stack1,10,8,0.02F));

            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    stack2,10,8,0.02F));

            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    stack6,10,8,0.02F));

            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    stack7,10,8,0.02F));

            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 25),
                    stack3,10,8,0.02F));

            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 25),
                    stack4,10,8,0.02F));

            //trades.get(5).add((trader, rand) -> new MerchantOffer(
            //        new ItemStack(Items.EMERALD, 64),
            //        stack5,10,8,0.02F));
        }
    }
}
