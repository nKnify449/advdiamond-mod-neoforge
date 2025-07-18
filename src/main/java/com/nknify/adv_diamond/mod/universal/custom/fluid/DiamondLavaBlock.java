package com.nknify.adv_diamond.mod.universal.custom.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DiamondLavaBlock extends LiquidBlock {
    public DiamondLavaBlock(FlowingFluid fluid, BlockBehaviour.Properties properties) {
        super(fluid, properties);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);

        if (!entity.fireImmune()) {
            entity.setSharedFlagOnFire(true);// 🔥 sets player/entity on fire for 4 seconds
            entity.setRemainingFireTicks(80);
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, net.minecraft.world.level.BlockGetter level,
                                        BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
        return Shapes.empty(); // so entity is considered inside the fluid
    }
}

