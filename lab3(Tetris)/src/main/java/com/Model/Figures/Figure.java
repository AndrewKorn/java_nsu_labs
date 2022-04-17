package com.Model.Figures;

import com.Model.Block;

import java.awt.*;


public interface Figure {
    void rotateClockwise();
    void rotateCounterclockwise();
    void shift(int xShift, int yShift);
    Block[] getBlocks();
    Color getColor();
    void set(int x, int y);
}
