package com.model.Figures;

import com.model.Block;
import com.model.ColorEnum;


public interface Figure {
    void rotateClockwise();
    void rotateCounterclockwise();
    void shift(int xShift, int yShift);
    Block[] getBlocks();
    ColorEnum getColor();
    void set(int x, int y);
}
