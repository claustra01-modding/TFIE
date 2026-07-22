package net.claustra01.tfie.common;

import blusunrize.immersiveengineering.api.multiblocks.BlockMatcher;
import net.dries007.tfc.util.Metal;
import net.minecraft.world.level.block.Block;

public final class MultiblockCompatibility {
    private MultiblockCompatibility() {
    }

    public static void register() {
        final Block steelPlatedBlock = Metal.STEEL.getBlock(Metal.BlockType.BLOCK);
        final Block blackSteelPlatedBlock = Metal.BLACK_STEEL.getBlock(Metal.BlockType.BLOCK);
        BlockMatcher.addPredicate((expected, found, level, pos) -> {
            final Block requiredBlock;
            if (expected.is(steelPlatedBlock)) {
                requiredBlock = steelPlatedBlock;
            } else if (expected.is(blackSteelPlatedBlock)) {
                requiredBlock = blackSteelPlatedBlock;
            } else {
                return BlockMatcher.Result.DEFAULT;
            }
            return found.is(requiredBlock)
                ? BlockMatcher.Result.allow(3)
                : BlockMatcher.Result.deny(3);
        });
    }
}
