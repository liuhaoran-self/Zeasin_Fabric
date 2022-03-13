package xyz.cbfh.zeasin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class AmethystMaterial implements ArmorMaterial, ToolMaterial {

    public static final int[] BASE_DURABILITY = new int[]{13,15,16,11};//定义护甲的耐久，此处数据按照从头到脚的顺序
    public static final int[] BASE_PROTECTION_AMOUNT = new int[]{2,5,6,3};//定义护甲的保护值，顺序同上

    public int getDurability(EquipmentSlot arg0) {return BASE_DURABILITY[arg0.getEntitySlotId()]*14;}
    public int getProtectionAmount(EquipmentSlot arg0) {return BASE_PROTECTION_AMOUNT[arg0.getEntitySlotId()];}
    public int getEnchantability() {return 100;}
    public SoundEvent getEquipSound() {return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN;}
    public Ingredient getRepairIngredient() {return Ingredient.ofItems(Items.AMETHYST_SHARD);}
    public String getName() {return "amethyst";}
    public float getToughness() {return 0.0F;}
    public float getKnockbackResistance() {return 0.0F;}

    public int getDurability() {return 240;}
    public float getAttackDamage() {return 3.0f;}
    public int getMiningLevel() {return 2;}
    public float getMiningSpeedMultiplier() {return 6.0f;}

}
