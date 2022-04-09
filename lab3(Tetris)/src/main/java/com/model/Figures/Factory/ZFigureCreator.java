package com.model.Figures.Factory;

import com.model.Block;
import com.model.ColorEnum;
import com.model.Figures.ConcreteFigure;
import com.model.Figures.Figure;
import com.model.Point;

public class ZFigureCreator implements FigureCreator {
    @Override
    public Figure createFigure() {
        Point centre = new Point(1, 0);
        Block[] blocks = {
                new Block(0, 1),
                new Block(1, 1),
                new Block(1, 0),
                new Block(2, 0)
        };
        return new ConcreteFigure(centre, blocks, ColorEnum.Red);
    }
}
