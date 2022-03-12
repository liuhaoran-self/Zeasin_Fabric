package xyz.cbfh.zeasin;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.cbfh.zeasin.Tools.TheSword;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MODID = "zeasin";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	public static final ItemGroup FABRIC_EXAMPLE_GROUP = FabricItemGroupBuilder.build(new Identifier("fabric", "example"), () -> new ItemStack(Main.FABRIC_ITEM));
	public static final Item FABRIC_ITEM = new Item(new Item.Settings().group(Main.FABRIC_EXAMPLE_GROUP));
	public static final Block FABRIC_BLOCK = new Block(FabricBlockSettings.of(Material.METAL));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.ITEM, new Identifier(MODID, "fabric_item"),FABRIC_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MODID, "fabric_sword"), new TheSword(new ToolFabric()));
		Registry.register(Registry.BLOCK, new Identifier(MODID, "fabric_block"), FABRIC_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(MODID, "fabric_block"), new BlockItem(FABRIC_BLOCK, new Item.Settings().group(Main.FABRIC_EXAMPLE_GROUP)));
		LOGGER.info("Hello Fabric world!");
	}
}
