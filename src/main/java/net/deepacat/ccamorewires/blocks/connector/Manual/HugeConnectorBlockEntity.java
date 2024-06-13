package net.deepacat.ccamorewires.blocks.connector.Manual;

import net.deepacat.ccamorewires.blocks.connector.base.AbstractConnectorBlock;
import net.deepacat.ccamorewires.blocks.connector.base.AbstractConnectorBlockEntity;
import net.deepacat.ccamorewires.config.Config;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class HugeConnectorBlockEntity extends AbstractConnectorBlockEntity {

    private final static float OFFSET_HEIGHT = 3f;
    public final static Vec3 OFFSET_DOWN = new Vec3(0f, -OFFSET_HEIGHT/16f, 0f);
    public final static Vec3 OFFSET_UP = new Vec3(0f, OFFSET_HEIGHT/16f, 0f);
    public final static Vec3 OFFSET_NORTH = new Vec3(0f, 0f, -OFFSET_HEIGHT/16f);
    public final static Vec3 OFFSET_WEST = new Vec3(-OFFSET_HEIGHT/16f, 0f, 0f);
    public final static Vec3 OFFSET_SOUTH = new Vec3(0f, 0f, OFFSET_HEIGHT/16f);
    public final static Vec3 OFFSET_EAST = new Vec3(OFFSET_HEIGHT/16f, 0f, 0f);

    public HugeConnectorBlockEntity(BlockEntityType<?> blockEntityTypeIn, BlockPos pos, BlockState state) {
        super(blockEntityTypeIn, pos, state);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> list) {}

    @Override
    public int getMaxIn() {
        return Config.HUGE_CONNECTOR_MAX_INPUT.get();
    }

    @Override
    public int getMaxOut() {
        return Config.HUGE_CONNECTOR_MAX_OUTPUT.get();
    }

    @Override
    public int getNodeCount() {
        return 4;
    }

    @Override
    public Vec3 getNodeOffset(int node) {
        return switch (getBlockState().getValue(AbstractConnectorBlock.FACING)) {
            case DOWN -> OFFSET_DOWN;
            case UP -> OFFSET_UP;
            case NORTH -> OFFSET_NORTH;
            case WEST -> OFFSET_WEST;
            case SOUTH -> OFFSET_SOUTH;
            case EAST -> OFFSET_EAST;
        };
    }

    public int getMaxWireLength() {
        return Config.HUGE_CONNECTOR_MAX_LENGTH.get();
    }
}
