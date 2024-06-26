package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.inventory.TWMasterSmithingMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class TWMenuTypes {
    public static final DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.MENU, TheWitcher.MOD_ID);

    public static final Supplier<MenuType<TWMasterSmithingMenu>> MASTER_SMITHING_TABLE_MENU = register("master_smithing_table_menu", TWMasterSmithingMenu::new);

    private static <T extends AbstractContainerMenu> Supplier<MenuType<T>> register(String name, IContainerFactory<T> factory) {
        return REGISTER.register(name, () -> IMenuTypeExtension.create(factory));
    }
}