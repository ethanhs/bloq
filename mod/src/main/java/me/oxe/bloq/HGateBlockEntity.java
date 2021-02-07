package me.oxe.bloq;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;

public class HGateBlockEntity extends GateBlockEntity {

  private int dummy_number = 7;

  public HGateBlockEntity() {
    super(BloqMod.H_GATE_BLOCK_ENTITY);
  }

  @Override
  public CompoundTag toTag(CompoundTag tag) {
    tag.putInt("dummy_number", dummy_number);
    return super.toTag(tag);
  }

  // Deserialize the BlockEntity
  @Override
  public void fromTag(BlockState state, CompoundTag tag) {
    super.fromTag(state, tag);
    dummy_number = tag.getInt("dummy_number");
  }

  @Override
  public void setStack(int slot, ItemStack stack) {
    if (slot == 0) {
      if (!this.world.isClient) {
        QuantumWatcher watcher = QuantumWatcher.getInstance();
        watcher.appendQubitGate(stack, "x", 0);
        this.inventory.set(1, stack.copy());
        stack.decrement(1);
        markDirty();
      }
    }
  }

}
