package com.Figures.Factory;

import com.Block;
import com.ColorEnum;
import com.Figures.ConcreteFigure;
import com.Figures.Figure;
import com.Point;

public class LFigureCreator implements FigureCreator {
    @Override
    public Figure createFigure() {
        Point centre = new Point(1, 0);
        Block[] blocks = {
                new Block(0, 0),
                new Block(1, 0),
                new Block(2, 0),
                new Block(2, 1)
        };
        return new ConcreteFigure(centre, blocks, ColorEnum.Orange);
    }
}
