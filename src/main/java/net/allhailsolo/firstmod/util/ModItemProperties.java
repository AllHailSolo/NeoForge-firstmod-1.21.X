package net.allhailsolo.firstmod.util;

import net.allhailsolo.firstmod.FirstMod;
import net.allhailsolo.firstmod.component.ModDataComponentTypes;
import net.allhailsolo.firstmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.DATA_TABLET.get(), ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "on"),
                (itemStack, clientLevel, livingEntity, i) -> itemStack.get(ModDataComponentTypes.FOUND_BLOCK) != null ? 1f : 0f);

        makeCustomBow(ModItems.OPAL_BOW.get());
    }

    private static void makeCustomBow(Item item) {
         ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"), (p_344163_, p_344164_, p_344165_, p_344166_) -> {
            if (p_344165_ == null) {
                return 0.0F;
            } else {
                return p_344165_.getUseItem() != p_344163_ ? 0.0F : (float)(p_344163_.getUseDuration(p_344165_) - p_344165_.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
            return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F;
        });
    }
}
