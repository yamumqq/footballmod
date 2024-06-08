package net.Filimonov.footballmod.block;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.BambooBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.DropperBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.Filimonov.footballmod.FootballMod;
import net.Filimonov.footballmod.item.Moditems;
import net.minecraft.world.item.CreativeModeTab;
import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FootballMod.MOD_ID);
    public  static final  RegistryObject<Block> GOLDBALL = registryBlock("gold_ball",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
                    .of(Material.GLASS).strength(3f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), CreativeModeTab.TAB_MISC);
    public  static final  RegistryObject<Block> WORLDCUP = registryBlock("worldcup",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
                    .of(Material.AMETHYST).instabreak().lightLevel(state -> 5).explosionResistance(10f)
                    , UniformInt.of(2,4)), CreativeModeTab.TAB_MISC);
    public  static final  RegistryObject<Block> LIGAEUROPE = registryBlock("liga_europe",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
                    .of(Material.METAL).strength(10f)
                    .requiresCorrectToolForDrops().instabreak(), UniformInt.of(3,7)), CreativeModeTab.TAB_MISC);
    public  static final  RegistryObject<Block> LIGACHAMP = registryBlock("liga_champ",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
                    .of(Material.SPONGE).strength(3f)
                    .requiresCorrectToolForDrops().explosionResistance(2f),
                    UniformInt.of(1,3)), CreativeModeTab.TAB_MISC);
    public static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturns = BLOCKS.register(name, block);
        registryBlockItem(name, toReturns, tab);
        return toReturns;
    }

    private static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}