package net.tomfoolery.testingmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tomfoolery.testingmod.TomfooleryTestingMod;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TomfooleryTestingMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TESTING_TAB =
            CREATIVE_MODE_TABS.register("testing_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.RUBY.get()))
                            .title(Component.translatable("creativetab.testing_tab"))
                            .displayItems((itemDisplayParameters, output) ->
                            {
                                output.accept(ModItems.RUBY.get());
                                output.accept(ModItems.RAW_RUBY.get());

                                output.accept(Items.DIAMOND);
                            })
                            .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
