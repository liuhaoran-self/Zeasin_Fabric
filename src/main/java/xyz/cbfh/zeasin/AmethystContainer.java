package xyz.cbfh.zeasin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class AmethystContainer extends Block { //todo: BlockWithEntity
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public BlockState getPlacementState(ItemPlacementContext ctx) {return this.getDefaultState().with(FACING, ctx.getPlayerFacing());}
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {builder.add(FACING);}
    public AmethystContainer(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

}
