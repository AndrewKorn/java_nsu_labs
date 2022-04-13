package com.Model.Figures.Factory;

import com.Model.Block;
import com.Model.ColorEnum;
import com.Model.Figures.ConcreteFigure;
import com.Model.Figures.Figure;
import com.Model.Point;

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
