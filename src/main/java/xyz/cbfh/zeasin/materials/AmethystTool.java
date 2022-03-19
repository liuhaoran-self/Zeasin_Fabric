package xyz.cbfh.zeasin.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AmethystTool implements ToolMaterial {

    public int getDurability() {return 240;}
    public float getAttackDamage() {return 3.0f;}
    public int getEnchantability() {return 100;}
    public Ingredient getRepairIngredient() {return Ingredient.ofItems(Items.AMETHYST_SHARD);}
    public int getMiningLevel() {return 2;}
    public float getMiningSpeedMultiplier() {return 6.0f;}
}
