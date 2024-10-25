package com.barion.the_witcher.util;

import com.ametrinstudios.ametrin.world.gen.util.StructurePieces;
import com.barion.the_witcher.TheWitcher;
import com.mojang.logging.LogUtils;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.slf4j.Logger;

public final class TWUtil {
    public static final Logger Logger = LogUtils.getLogger();
    public static StructurePieces.Builder pieceBuilder() { return new StructurePieces.Builder(); }
    @Deprecated
    public static ResourceLocation locate(String key) { return ResourceLocation.fromNamespaceAndPath(TheWitcher.MOD_ID, key); }


    public static VoxelShape rotate(VoxelShape shape, Direction newDir)
    {
        return rotate(shape, Direction.NORTH, newDir);
    }

    public static VoxelShape rotate(VoxelShape shape, Direction originalDir, Direction newDir)
    {
        if (originalDir != newDir)
        {
            VoxelShape[] newShape = new VoxelShape[] { Shapes.empty() };
            shape.forAllBoxes((x, y, z, a, b, c) ->
            {
                double i = 1 - c;
                double j = 1 - z;
                newShape[0] = Shapes.or(newShape[0], Shapes.box(Math.min(i, j), y, x, Math.max(i, j), b, a));
            });
            return rotate(newShape[0], originalDir.getClockWise(), newDir);
        }
        return shape;
    }

    public static VoxelShape mirror(VoxelShape shape, Direction.Axis axis)
    {
        VoxelShape[] newShape = new VoxelShape[] { Shapes.empty() };
        switch (axis)
        {
            case X:
                shape.forAllBoxes((x, y, z, a, b, c) ->
                {
                    double i = 1 - x;
                    double j = 1 - a;
                    newShape[0] = Shapes.or(newShape[0], Shapes.box(Math.min(i, j), y, z, Math.max(i, j), b, c));
                });
                break;
            case Z:
                shape.forAllBoxes((x, y, z, a, b, c) ->
                {
                    double i = 1 - z;
                    double j = 1 - c;
                    newShape[0] = Shapes.or(newShape[0], Shapes.box(x, y, Math.min(i, j), a, b, Math.max(i, j)));
                });
                break;
            case Y:
                shape.forAllBoxes((x, y, z, a, b, c) ->
                {
                    double i = 1 - y;
                    double j = 1 - b;
                    newShape[0] = Shapes.or(newShape[0], Shapes.box(x, Math.min(i, j), z, a, Math.max(i, j), c));
                });
                break;
        }
        return newShape[0];
    }
}