package com.babyshaq.babyshaqsmod.villager;

import com.babyshaq.babyshaqsmod.BabyShaqsMod;
import com.babyshaq.babyshaqsmod.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, BabyShaqsMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, BabyShaqsMod.MOD_ID);

    public static final RegistryObject<PoiType> ARCHAEOLOGY_POI = POI_TYPES.register("archaeology_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.ARCHAEOLOGY_STAND.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> ARCHAEOLOGIST = VILLAGER_PROFESSIONS.register("archaeologist",
            () -> new VillagerProfession("archaeologist", x -> x.get() == ARCHAEOLOGY_POI.get(),
                    x -> x.get() == ARCHAEOLOGY_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_FLETCHER));

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiTypes.class,
                        "registerBlockStates", PoiTypes.class).invoke(null, ARCHAEOLOGY_POI.get());
        } catch (InvocationTargetException | IllegalAccessException | ObfuscationReflectionHelper.UnableToFindMethodException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}