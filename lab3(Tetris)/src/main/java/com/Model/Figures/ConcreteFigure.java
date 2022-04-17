package com.Model.Figures;

import com.Model.Block;
import com.Model.Point;

import java.awt.*;

public class ConcreteFigure implements Figure {
    private final Point centre;
    private final Block[] blocks;
    private final Color color;

    public ConcreteFigure(Point centre, Block[] blocks, Color color) {
        this.centre = centre;
        this.blocks = blocks;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void rotateClockwise() {
        for (Block block : blocks) {
            block.rotateClockwise(centre);
        }
    }

    @Override
    public void rotateCounterclockwise() {
        for (Block block : blocks) {
            block.rotateCounterclockwise(centre);
        }
    }

    @Override
    public void shift(int xShift, int yShift) {
        for (Block block : blocks) {
            block.shift(xShift, yShift);
        }
        centre.shift(xShift, yShift);
    }

    @Override
    public Block[] getBlocks() {
        return blocks;
    }

    @Override
    public void set(int x, int y) {
        shift(x - (int)centre.getX(), y - (int)centre.getY());
    }
}
