package xyz.cbfh.zeasin.Tools;

import java.util.Random;
import java.util.Set;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import xyz.cbfh.zeasin.Main;

public class TheSword extends SwordItem{

    private static Vec3d VELOCITY = null;
    private static double X,Y,Z;
    private static boolean isRecorded = false;

    public TheSword(ToolMaterial material) {
        super(material, 0, 0f, new Item.Settings().group(Main.FABRIC_EXAMPLE_GROUP));
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        //entity.getBrain().setCoreActivities(Set.of(Activity.CELEBRATE));
        entity.getBrain().setDefaultActivity(Activity.AVOID);
        user.sendMessage(Text.of(entity.getBrain().toString()), false);
        return ActionResult.PASS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Integer a = new Random().nextInt();
        
        if (isRecorded == true) {
            user.setVelocity(VELOCITY);
            user.setPosition(X,Y,Z);
            isRecorded = false;
            user.sendMessage(Text.of("Resumed"),false);
            Main.LOGGER.error("Resumed "+a.toString());
            user.getItemCooldownManager().set(this, 20);
        } else {
            VELOCITY = user.getVelocity();
            X = user.getX();
            Y = user.getY();
            Z = user.getZ();
            isRecorded = true;
            user.sendMessage(Text.of("Recorded"),false);
            Main.LOGGER.error("Recorded "+a.toString());
            user.getItemCooldownManager().set(this, 20);
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
    
}
