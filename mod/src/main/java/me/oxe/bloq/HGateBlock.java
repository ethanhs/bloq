package me.oxe.bloq;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class HGateBlock extends GateBlock {

  public HGateBlock(Settings settings) {
    super(settings);
  }

  @Override
  public BlockEntity createBlockEntity(BlockView world) {
    return new HGateBlockEntity();
  }

}
