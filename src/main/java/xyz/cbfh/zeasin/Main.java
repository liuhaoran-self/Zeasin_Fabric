package xyz.cbfh.zeasin;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MODID = "zeasin";
	public static BlockEntityType<AmethystContainerEntity> AMETHYST_CONTAINER_ENTITY;
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	public static final Block AMETHYST_CONTAINER = new AmethystContainer(FabricBlockSettings.of(Material.AMETHYST));
	public static final ItemGroup AMETHYST_TECH_GROUP = FabricItemGroupBuilder.build(new Identifier("amethyst", "tech"), () -> new ItemStack(Items.AMETHYST_SHARD));
	public static final ArmorMaterial AMETHYST_ARMOR = new AmethystMaterial();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		AMETHYST_CONTAINER_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "zeasin:amethyst_container_entity", FabricBlockEntityTypeBuilder.create(AmethystContainerEntity::new, AMETHYST_CONTAINER).build(null));
		Registry.register(Registry.BLOCK, new Identifier(MODID, "amethyst_container"), AMETHYST_CONTAINER);//注册方块
		Registry.register(Registry.ITEM, new Identifier(MODID, "amethyst_container"), new BlockItem(AMETHYST_CONTAINER, new Item.Settings().group(AMETHYST_TECH_GROUP)));//将方块注册到ItemGroup中
		Registry.register(Registry.ITEM, new Identifier(MODID, "amethyst_sword"), new SwordItem(new AmethystMaterial(), 3, -2.5f, new Item.Settings().group(Main.AMETHYST_TECH_GROUP)));
		Registry.register(Registry.ITEM, new Identifier(MODID, "amethyst_helmet"), new BaseArmor(AMETHYST_ARMOR, EquipmentSlot.HEAD));
		Registry.register(Registry.ITEM, new Identifier(MODID, "amethyst_chestplate"), new BaseArmor(AMETHYST_ARMOR, EquipmentSlot.CHEST));
		Registry.register(Registry.ITEM, new Identifier(MODID, "amethyst_leggings"), new BaseArmor(AMETHYST_ARMOR, EquipmentSlot.LEGS));
		Registry.register(Registry.ITEM, new Identifier(MODID, "amethyst_boots"), new BaseArmor(AMETHYST_ARMOR, EquipmentSlot.FEET));


	}
}
