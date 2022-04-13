package com.Model.Figures;

import com.Model.Block;
import com.Model.ColorEnum;


public interface Figure {
    void rotateClockwise();
    void rotateCounterclockwise();
    void shift(int xShift, int yShift);
    Block[] getBlocks();
    ColorEnum getColor();
    void set(int x, int y);
}
