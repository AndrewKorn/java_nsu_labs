package com.Figures;

import com.Block;
import com.ColorEnum;


public interface Figure {
    void rotateClockwise();
    void rotateCounterclockwise();
    void shift(int xShift, int yShift);
    Block[] getBlocks();
    ColorEnum getColor();
    void set(int x, int y);
}
