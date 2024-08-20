package net.allhailsolo.firstmod.datagen;

import net.allhailsolo.firstmod.FirstMod;
import net.allhailsolo.firstmod.block.ModBlocks;
import net.allhailsolo.firstmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> BLACK_OPAL_SMELTABLES = List.of(ModItems.RAW_BLACK_OPAL,
                ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE, ModBlocks.BLACK_OPAL_END_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_OPAL_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 9)
                .requires(ModBlocks.BLACK_OPAL_BLOCK.get())
                .unlockedBy("has_black_opal_block", has(ModBlocks.BLACK_OPAL_BLOCK.get())).save(recipeOutput, "firstmod:black_opal_1");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.BLACK_OPAL_BLOCK.get(), 9)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK.get())).save(recipeOutput, "firstmod:black_opal_2");

        stairBuilder(ModBlocks.BLACK_OPAL_STAIRS.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                        .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_OPAL_SLAB.get(), ModItems.BLACK_OPAL.get());
        buttonBuilder(ModBlocks.BLACK_OPAL_BUTTON.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                        .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.BLACK_OPAL_PRESSURE_PLATE.get(), ModItems.BLACK_OPAL);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_BLOCK);
        fenceBuilder(ModBlocks.BLACK_OPAL_FENCE.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.BLACK_OPAL_FENCE_GATE.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        doorBuilder(ModBlocks.BLACK_OPAL_DOOR.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.BLACK_OPAL_TRAPDOOR.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLACK_OPAL_SWORD.get())
                .pattern("B")
                .pattern("B")
                .pattern("A")
                .define('B', ModItems.BLACK_OPAL.get())
                .define('A', Items.STICK)
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLACK_OPAL_PICKAXE.get())
                .pattern("BBB")
                .pattern(" A ")
                .pattern(" A ")
                .define('B', ModItems.BLACK_OPAL.get())
                .define('A', Items.STICK)
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLACK_OPAL_AXE.get())
                .pattern("BB")
                .pattern("BA")
                .pattern(" A")
                .define('B', ModItems.BLACK_OPAL.get())
                .define('A', Items.STICK)
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLACK_OPAL_SHOVEL.get())
                .pattern("B")
                .pattern("A")
                .pattern("A")
                .define('B', ModItems.BLACK_OPAL.get())
                .define('A', Items.STICK)
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLACK_OPAL_HOE.get())
                .pattern("BB")
                .pattern(" A")
                .pattern(" A")
                .define('B', ModItems.BLACK_OPAL.get())
                .define('A', Items.STICK)
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);


        oreSmelting(recipeOutput, BLACK_OPAL_SMELTABLES, RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 0.25f, 200, "black_opal");
        oreBlasting(recipeOutput, BLACK_OPAL_SMELTABLES, RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 0.25f, 200, "black_opal");


    }


    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, FirstMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
