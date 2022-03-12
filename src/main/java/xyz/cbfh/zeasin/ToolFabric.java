package xyz.cbfh.zeasin;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ToolFabric implements ToolMaterial {

    @Override
    public int getDurability() {
        return 200;//耐久值200
    }

    @Override
    public float getAttackDamage() {
        return 4.0f;//伤害值4
    }

    @Override
    public int getMiningLevel() {
        return 4;//挖掘级别4
    }

    @Override
    public int getEnchantability() {
        return 30;//附魔等级30
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Main.FABRIC_ITEM);
    }

}